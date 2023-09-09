import Dependencies.implementationCommon
import Dependencies.implementationRetrofit
import Dependencies.implementationRoom

plugins {
    id("base-gradle-config")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")

}

android {
    namespace = "data"
}

secrets {
    defaultPropertiesFileName = "secrets.defaults.properties"
}


dependencies {
    implementation(project(BuildModule.CORE))
    implementation(project(BuildModule.DOMAIN))
    implementationCommon()
    implementationRetrofit()
    implementationRoom()
}