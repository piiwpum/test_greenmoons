import Dependencies.implementationCommon
import Dependencies.implementationTest

plugins {
    id("base-gradle-config")

}

android {
    namespace = "domain"

}

dependencies {
    implementation(project(BuildModule.CORE))
    implementationCommon()
    implementationTest()
}