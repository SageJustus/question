@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("sage.springboot")
    alias(libs.plugins.kotlin.jpa)
}

dependencies {
    api(libs.mysql.connector.java)
    api(libs.spring.boot.starter.data.jpa)
}
