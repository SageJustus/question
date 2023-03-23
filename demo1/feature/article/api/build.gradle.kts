@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("sage.springboot")
}

dependencies{
    api(project(":core:api"))
    implementation(project(":feature:article:service"))
}
