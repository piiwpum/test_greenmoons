import Dependencies.implementationCommon
import Dependencies.implementationFeature
import Dependencies.implementationNavigation

plugins {
    id("base-gradle-config")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")

}

android {
    namespace = "features.movie"
}

dependencies {
    implementation(project(BuildModule.CORE))
    implementation(project(BuildModule.DOMAIN))
    implementation(project(BuildModule.RESOURCE))
    implementation(project(BuildModule.NAVIGATION))
    implementationCommon()
    implementationFeature()
    implementationNavigation()


}