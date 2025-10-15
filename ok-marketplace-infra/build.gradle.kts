plugins {
    id("build-jvm")
    id("maven-publish")
}

//todo перенести весь модуль в ok-marketplace-other
//todo модуль должен называться ok-marketplace-other/ok-marketplace-dcomp
//todo пенести в 202508

group = "com.otus.otuskotlin.marketplace"
version = "0.0.1"

kotlin {
    tasks.processResources {
        copy {
            from("backend")
            into(layout.buildDirectory.dir("resources/main/backend"))
        }
        delete {
            delete(
                layout.buildDirectory.dir("resources/main/backend/Dockerfile"),
                layout.buildDirectory.dir("resources/main/backend/call-envoy.sh"),
                layout.buildDirectory.dir("resources/main/backend/cert-gen.sh"),
                layout.buildDirectory.dir("resources/main/backend/keycloak-tokens.sh"),
                layout.buildDirectory.dir("resources/main/backend/README.md")
            )
        }
    }

}


publishing {
    repositories {
        maven {
            name = "LocalRepo"
            url = uri("${rootProject.projectDir}/build/repo") // Локальный репозиторий для примера
        }
    }
    publications {
        val backendInfra by publications.creating(MavenPublication::class) {
            from(components["kotlin"])
            artifactId = "backend-infra"
        }
    }
}