import Dependencies.implementationCommon
import Dependencies.implementationFeature
import Dependencies.implementationLifeCycle
import Dependencies.implementationNavigation
import Dependencies.implementationApp
import Dependencies.implementationTest

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.phanupan.greenmoons.test"
    compileSdk = Versions.App.COMPILE_SDK

    defaultConfig {
        applicationId = Versions.App.APP_ID
        minSdk = Versions.App.MIN_SDK
        targetSdk = Versions.App.TARGET_SDK
        versionCode = Versions.App.VERSION_CODE
        versionName = Versions.App.VERSION_NAME
        multiDexEnabled = true

        testInstrumentationRunner = Versions.App.TEST
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        named("debug") {
            isShrinkResources = false
            isMinifyEnabled = false
        }

        named("release") {
            isMinifyEnabled = false
//            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
//            proguardFiles("proguard-rules.pro")

        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }

    android.sourceSets.all {
        java.srcDir("src/$name/kotlin")
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {
    implementation(project(BuildModule.CORE))
    implementation(project(BuildModule.DATA))
    implementation(project(BuildModule.DOMAIN))
    implementation(project(BuildModule.RESOURCE))
    implementation(project(BuildModule.NAVIGATION))
    implementation(project(BuildModule.FEATURE_MOVIE))
    implementationApp()
    implementationNavigation()
    implementationCommon()
    implementationLifeCycle()
    implementationTest()
    implementationNavigation()
    implementationFeature()
}