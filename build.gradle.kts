import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Exec
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile

tasks.withType<DependencyUpdatesTask>().configureEach {
    revision = "release"
    rejectPreReleases = true
    checkForGradleUpdate = true
    gradleReleaseChannel = "current"
}

abstract class SayHello : DefaultTask() {

    @get:Input
    var myName: String = "Florian"

    @get:OutputFile
    abstract val greetingFile: RegularFileProperty

    @TaskAction
    fun greet() {
        val greeting = "Hello $myName"
        val output = greetingFile.get().asFile

        output.parentFile.mkdirs()
        output.writeText(greeting)

        println(greeting)
    }
}

tasks.register<SayHello>("sayHello") {
    group = "Custom"
    description = "Writes a personal greeting to a file"

    greetingFile.set(
        layout.buildDirectory.file("greeting.txt")
    )
}

tasks.register<Exec>("linuxInfo") {
    group = "Custom"
    description = "Displays Linux system information"

    commandLine(
        "bash", "-c",
        "echo 'Kernel:' && uname -a"
    )
}