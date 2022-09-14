package com.example;

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.string.shouldContain
import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class DemoCommandStringTest : StringSpec() {
    init {
        val ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)
        "Hi!" {

            val baos = ByteArrayOutputStream()
            System.setOut(PrintStream(baos))

            val args = arrayOf("-v")
            PicocliRunner.run(DemoCommand::class.java, ctx, *args)

            baos.toString() shouldContain "Hi!"
        }

        ctx.close()
    }
}