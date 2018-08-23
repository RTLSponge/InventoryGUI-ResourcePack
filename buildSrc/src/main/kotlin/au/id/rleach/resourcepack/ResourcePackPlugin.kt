package au.id.rleach.resourcepack

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.logging.LogLevel
import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.Delete
import org.gradle.api.tasks.bundling.Zip

import org.gradle.kotlin.dsl.*


open class ResourcePackPluginExtension {

    var out : String = "rp-out"
    var zipOut : String = "rp-out"
    var src : String = "rp"

    constructor(target: Project) {

    }
}

class ResourcePackPlugin : Plugin<Project> {

    val rpName = "resourcepack"
    val rpGroup = "resourcepack"

    override fun apply(target: Project) {
        val ext = target.extensions.create(rpName, ResourcePackPluginExtension::class.java, target)


        target.run {
            tasks {

                val cleanRP by creating(Delete::class) {
                    group = rpGroup
                    description = "deletes all files in output directory"
                    delete = setOf(target.file(ext.out))
                }

                val buildRP by creating(Copy::class) {
                    group = rpGroup
                    description = "Runs Preprocessors + copys to output directory"
                    from(ext.src)
                    into(ext.out+"/${project.name}")
                }

                val zip by creating(Zip::class) {
                    description = "Archives the resource pack output"
                    group = rpGroup
                    from(ext.out+"/${project.name}")
                    destinationDir = file(ext.zipOut)
                }

                artifacts {
                    add("archives", zip)
                }
            }
        }
    }
}