@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("sage.springboot")
}

dependencies{
    implementation(libs.spring.boot.starter.web)
    api(project(":feature:article:article-database"))
    implementation(libs.spring.boot.starter.data.jpa)
}
