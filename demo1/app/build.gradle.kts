import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("sage.springboot")
}

dependencies {
    implementation(libs.kotlin.reflect)
    implementation(libs.spring.boot.starter)
    implementation(libs.spring.boot.starter.test)
    implementation(libs.spring.boot.starter.web)
    implementation(libs.jackson.module.kotlin)
    implementation(libs.mysql.connector.java)
//    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<ProcessResources> {
//    filesMatching("**/application.yml") {
//        expand("activeProfile" to "dev")
//    }
    expand(project.properties)
}

