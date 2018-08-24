import au.id.rleach.resourcepack.LangMap
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

mcmeta {
    pack.description = "InventoryGUI ResourcePack"
    pack.pack_format = 3

    language["en_AU"].name = "bob"
    language["en_AU"].region = "bob"
    language["en_AU"].bidi = false
}