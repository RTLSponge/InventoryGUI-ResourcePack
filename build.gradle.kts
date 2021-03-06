import org.gradle.api.internal.artifacts.ImmutableModuleIdentifierFactory
import org.gradle.api.internal.artifacts.ivyservice.projectmodule.ProjectPublicationRegistry
import org.gradle.configuration.project.ProjectConfigurationActionContainer
import kotlin.jvm.javaClass

description = "A Minecraft Resource Pack build Pipeline"
version = "0.0.1"

buildscript {

}

plugins {
    id("base")
    id("resourcepack")
}

resourcepack {
    out = "rp-out"
    zipOut = "rp-out"
    src = "rp"
}