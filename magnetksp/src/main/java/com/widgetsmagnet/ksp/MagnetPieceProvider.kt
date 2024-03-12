package com.widgetsmagnet.ksp

import com.google.devtools.ksp.KspExperimental
import com.google.devtools.ksp.getAnnotationsByType
import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid
import com.google.devtools.ksp.validate

class MagnetPieceProcessor(val codeGenerator: CodeGenerator, val logger: KSPLogger) :
    SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols = resolver.getSymbolsWithAnnotation(MagnetPiece::class.java.name)
        val ret = symbols.filter { !it.validate() }.toList()
        symbols.filter { it.validate() }
            .forEach {
                it.accept(TestVisitor(), Unit)
            }
        return ret
    }

    inner class TestVisitor : KSVisitorVoid() {
        @OptIn(KspExperimental::class)
        override fun visitClassDeclaration(classDeclaration: KSClassDeclaration, data: Unit) {
            val piece =
                classDeclaration.getAnnotationsByType(MagnetPiece::class).firstOrNull() ?: return
            val name = piece.name
            val className =
                "${name.replaceFirst(name.first(), name.first().uppercaseChar())}Extension"
            val packageName = classDeclaration.containingFile!!.packageName.asString()
            val file = codeGenerator.createNewFile(
                Dependencies(true),
                packageName,
                className
            )

            val valueTypePackage = piece.valueType.packageName()

            val sb = StringBuilder()
            sb.append("package $packageName\n\n")
            sb.append("import androidx.annotation.IdRes\n")
            if (valueTypePackage != null) {
                sb.append("import $valueTypePackage.${piece.valueType.name}\n")
            }
            sb.append("import com.magnetwidgets.magnet.Magnet\n\n")
            sb.append("fun Magnet.$name(@IdRes viewId: Int, vararg values: ${piece.valueType.name}) {\n")
            sb.append("    execute(\"$name\", viewId, *values${if (piece.valueType.needTypedArray()) ".toTypedArray()" else ""})\n")
            sb.append("}")
            file.write(sb.toString().encodeToByteArray())
        }
    }
}

class MagnetPieceProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor {
        return MagnetPieceProcessor(environment.codeGenerator, environment.logger)
    }
}

