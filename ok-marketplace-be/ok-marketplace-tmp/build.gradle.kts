plugins {
    id("build-jvm")
}

repositories {
    maven {
        name = "LocalRepo"
        url = uri("${rootProject.projectDir}/../ok-marketplace-infra/build/repo") // Локальный репозиторий для примера
    }
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("com.otus.otuskotlin.marketplace:backend-infra:0.0.1")
}