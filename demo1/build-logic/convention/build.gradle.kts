plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

gradlePlugin {
    plugins {
        create("springboot"){
            id = "sage.springboot"
            implementationClass = "SpringbootConventionPlugin"
        }
    }
}
