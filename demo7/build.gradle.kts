plugins {
    id("java")
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.springboot)
    alias(libs.plugins.springDependencyManagement)
    alias(libs.plugins.kotlinSpring)
    id("idea")
}

dependencyManagement {
    imports {
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(libs.springBootStarter)
    implementation(libs.springBootStarterWeb)
    implementation(libs.springBootStarterSecurity)
    testImplementation(libs.springBootStarterTest)
    testImplementation(libs.kotlinTestJunit5)
}

tasks.test {
    useJUnitPlatform()
}