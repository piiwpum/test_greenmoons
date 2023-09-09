import Dependencies.implementationNavigation

plugins {
    id("base-gradle-config")
    id("androidx.navigation.safeargs.kotlin")

}

android {
    namespace = "navigation"
}

dependencies {
    implementationNavigation()
    implementation(project(BuildModule.DOMAIN))
}