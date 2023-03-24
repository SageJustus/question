plugins {
    id("sage.springboot")
    alias(libs.plugins.kotlin.jpa)
}

dependencies{
    api(project(":core:core-database"))
}
