
package com.example

import io.micronaut.configuration.picocli.PicocliRunner
import jakarta.inject.Inject

import picocli.CommandLine.Command
import picocli.CommandLine.Option

@Command(name = "demo", description = ["..."],
	mixinStandardHelpOptions = true)
class DemoCommand : Runnable {

	@Option(names = ["-v", "--verbose"], description = ["..."])
	private var verbose : Boolean = false

	@Inject
	lateinit var googleRepo: GoogleRepo

	override fun run() {
		// business logic here
		if (verbose) {
			googleRepo.curls()
		}
	}

	companion object {
		@JvmStatic fun main(args: Array<String>) {
			PicocliRunner.run(DemoCommand::class.java, *args)
		}
	}
}