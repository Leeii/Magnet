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
        symbols.filter { it.validate() }.forEach {
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
            val identifier = piece.identifier
            val className =
                "${
                    identifier.replace(Regex("[, ()]"), "")
                        .replaceFirst(name.first(), name.first().uppercaseChar())
                }Extension"
            val packageName = classDeclaration.containingFile!!.packageName.asString()
            val file = codeGenerator.createNewFile(
                Dependencies(true), packageName, className
            )

            val sb = StringBuilder()
            sb.append("package $packageName\n\n")
            sb.append("import androidx.annotation.IdRes\n")

            val parameterTypes = piece.parameterTypes
            val valueNames = piece.parameterNames
            parameterTypes.distinct().forEach { type ->
                type.packageName()?.also {
                    sb.append("import $it.${type.name}\n")
                }
            }
            sb.append("import com.magnetwidgets.magnet.Magnet\n\n")
            sb.append("fun Magnet.$name(@IdRes viewId: Int, ")
            parameterTypes.forEachIndexed { index, valueType ->
                val parameterName = valueNames.getOrNull(index) ?: "value${index}"
                sb.append("$parameterName: ${valueType.name}")
                if (index != parameterTypes.size - 1) {
                    sb.append(", ")
                }
            }
            sb.append(") {\n")
            sb.append("    execute(\"$identifier\", viewId, *arrayOf(")
            sb.append(Array(parameterTypes.size) {
                valueNames.getOrNull(it) ?: "value${it}"
            }.joinToString(", "))
            sb.append("))\n")
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

