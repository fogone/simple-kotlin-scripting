package ru.nobirds.kotlin.scripting

import org.jetbrains.kotlin.script.util.DependsOn
import org.jetbrains.kotlin.script.util.Import
import org.jetbrains.kotlin.script.util.Repository
import kotlin.script.experimental.annotations.KotlinScript
import kotlin.script.experimental.api.*
import kotlin.script.experimental.jvm.dependenciesFromClassloader
import kotlin.script.experimental.jvm.jvm

@KotlinScript(displayName = "Simple script",
    fileExtension = "simple.kts",
    compilationConfiguration = SimpleScriptConfiguration::class)
abstract class SimpleScript {

    fun simpleMethodToTest() {
        // do nothing
    }

}

object SimpleScriptConfiguration : ScriptCompilationConfiguration({
    defaultImports(
        "org.jetbrains.kotlin.script.util.*",
        "ru.nobirds.kotlin.scripting.*"
    )

    implicitReceivers(SimpleBuilder::class)

    refineConfiguration {
        onAnnotations(DependsOn::class, Repository::class, Import::class, handler = AnnotationSupportScriptConfigurator())
    }

    jvm {
        dependenciesFromClassloader(wholeClasspath = true)
    }

    ide {
        acceptedLocations(ScriptAcceptedLocation.Everywhere)
    }
})

