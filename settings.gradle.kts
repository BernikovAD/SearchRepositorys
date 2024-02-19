pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SearchRepositorys"
include(":app")
include(":common")
include(":core")
include(":core:model")
include(":features")
include(":features:mainScreen")
include(":features:detailsScreen")
include(":core:domain")
