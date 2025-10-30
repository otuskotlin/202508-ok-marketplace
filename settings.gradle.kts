pluginManagement {
    plugins {
        val kotlinVersion: String by settings
        kotlin("jvm") version kotlinVersion
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "ok-marketplace-202508"

//includeBuild("lessons")
includeBuild("ok-marketplace-other")
includeBuild("ok-marketplace-be")
include("ok-marketplace-tests")
include("ok-marketplace-tests:ok-marketplace-e2e-be")