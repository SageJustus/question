pluginManagement {
    includeBuild("build-logic")
    repositories {
        maven("https://maven.aliyun.com/repository/google")
        maven("https://maven.aliyun.com/repository/central")
        maven("https://maven.aliyun.com/repository/public")
        mavenCentral()
        gradlePluginPortal()
        google()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://maven.aliyun.com/repository/google")
        maven("https://maven.aliyun.com/repository/central")
        maven("https://maven.aliyun.com/repository/public")
        google()
        mavenCentral()
    }
}



rootProject.name = "server"
include("app")
include("core")
include("core:api")
project(":core:api").name = "core-api"
include("core:database")
project(":core:database").name = "core-database"
include("feature")
include("feature:article")
include("feature:article:database")
project(":feature:article:database").name = "article-database"
include("feature:article:api")
project(":feature:article:api").name = "article-api"
include("feature:article:service")
