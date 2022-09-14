package com.example

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.StringSpec
import io.micronaut.test.extensions.kotest.annotation.MicronautTest

@MicronautTest
class GoogleRepoTest(private val repo: GoogleRepo) : StringSpec() {

    init {
        "foo" {
            shouldNotThrowAny {
                repo.curls()
            }
        }
    }
}
