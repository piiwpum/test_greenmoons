import Dependencies.implementationCommon

plugins {
    id("base-gradle-config")

}

android {
    namespace = "resource"

}

dependencies {
    implementation(project(BuildModule.CORE))
    implementationCommon()
}