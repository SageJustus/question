import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

class SpringbootConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = project.extensions.getByType<VersionCatalogsExtension>().named("libs")
            pluginManager.apply(libs.findPlugin("kotlin-jvm").get().get().pluginId)
            pluginManager.apply(libs.findPlugin("kotlin-spring").get().get().pluginId)
            pluginManager.apply(libs.findPlugin("spring-framework-boot").get().get().pluginId)
            pluginManager.apply(libs.findPlugin("spring-dependency-management").get().get().pluginId)
        }
    }
}
