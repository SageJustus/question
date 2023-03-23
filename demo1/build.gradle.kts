import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.spring.dependency.management) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.spring) apply false
    alias(libs.plugins.spring.framework.boot) apply false
}

allprojects {
    group = "com.sage"
    version = "0.0.1-SNAPSHOT"
}

//tasks.named("bootJar") {
//    enabled = false
//}
//
//tasks.named("jar") {
//    enabled = true
//}
