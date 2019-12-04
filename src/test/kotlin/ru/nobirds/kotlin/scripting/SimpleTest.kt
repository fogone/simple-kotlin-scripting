package ru.nobirds.kotlin.scripting

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import java.io.File
import kotlin.script.experimental.api.ScriptEvaluationConfiguration
import kotlin.script.experimental.api.implicitReceivers
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost
import kotlin.script.experimental.jvmhost.createJvmCompilationConfigurationFromTemplate

class SimpleTest {

    @Test
    fun testScriptShouldProvideDefinedItems() {
        // simple hack, load resource like a file to support imports
        val source = File("src/test/resources/1.simple.kts").toScriptSource()

        val configuration = createJvmCompilationConfigurationFromTemplate<SimpleScript>()

        val simpleBuilder = SimpleBuilder()

        BasicJvmScriptingHost().eval(source, configuration, ScriptEvaluationConfiguration {
            implicitReceivers(simpleBuilder)
        })

        assertThat(simpleBuilder.build().items.map { it.text }, equalTo(listOf("test1", "test2", "test3")))
    }

}
