import org.gradle.api.internal.artifacts.ImmutableModuleIdentifierFactory
import org.gradle.api.internal.artifacts.ivyservice.projectmodule.ProjectPublicationRegistry
import org.gradle.configuration.project.ProjectConfigurationActionContainer
import javax.inject.Inject
import kotlin.jvm.javaClass

description = "A Minecraft Resource Pack build Pipeline"
version = "0.0.1"

plugins {
    id("base")
    `kotlin-dsl`
    `java-gradle-plugin`
}

gradlePlugin {
    (plugins) {
        "resourcepack" {
            id = "resourcepack"
            implementationClass = "au.id.rleach.resourcepack.ResourcePackPlugin"
        }
    }
}