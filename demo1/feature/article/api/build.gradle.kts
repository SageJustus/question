@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("sage.springboot")
}

dependencies{
//    api(libs.spring.boot.starter.web)
    api(project(":core:api"))
    implementation(project(":feature:article:service"))
}
