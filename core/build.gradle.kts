import Dependencies.implementationCommon
import Dependencies.implementationNavigation
import Dependencies.implementationRetrofit
import Dependencies.implementationTest

plugins {
    id("base-gradle-config")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

secrets {
    defaultPropertiesFileName = "secrets.defaults.properties"
}

android {
    namespace = "core"
}


dependencies {
    implementationCommon()
    implementationRetrofit()
    implementationNavigation()
    implementationTest()

}