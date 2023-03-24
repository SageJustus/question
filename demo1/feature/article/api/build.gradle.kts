@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("sage.springboot")
}

dependencies{
    api(project(":core:core-api"))
    api(project(":feature:article:service"))
}
