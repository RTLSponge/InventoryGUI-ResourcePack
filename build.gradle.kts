import org.gradle.api.internal.artifacts.ImmutableModuleIdentifierFactory
import org.gradle.api.internal.artifacts.ivyservice.projectmodule.ProjectPublicationRegistry
import org.gradle.configuration.project.ProjectConfigurationActionContainer
import javax.inject.Inject
import kotlin.jvm.javaClass

//apply<ResourcePackPlugin>()

description = "A Minecraft Resource Pack build Pipeline"
version = "0.0.1"

plugins {
    id("base")
}

tasks {
    "clean"(Delete::class) {
        delete("rp-out")
    }

    "build" {
        copy {
            from("rp")
            into("rp-out/${project.name}")
        }
    }

    val zip by creating(Zip::class) {
        description = "Archives the resource pack output"
        group = "rp"
        from("rp-out/${project.name}")
        destinationDir = file("rp-out")
    }

    "assemble" {
        dependsOn(zip)
    }
}

open class ResourcePackPluginExtension {
    var x:String = "thing"
}

class ResourcePackPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        val name = "resourcepack"
        project.extensions.create(name, ResourcePackPluginExtension::class.java, project)
        project.task("clean").setProperty("delete", setOf(project.projectDir.resolve("rp-out")))
    }
}