import org.gradle.kotlin.dsl.DependencyHandlerScope

object Dependencies {
    const val GEADLE = ""
    const val GRADLE_KOTLIN = ""

    const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
    const val KOTLIN_BOM = "org.jetbrains.kotlin:kotlin-bom:${Versions.KOTLIN_BOM}"
    const val MULTIDEX = "androidx.multidex:multidex:${Versions.MULTI_DEX}"
    const val CORE = "androidx.core:core-ktx:${Versions.Lib.CORE}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.Lib.APPCOMPAT}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.Lib.CONSTRAINT_LAYOUT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.Lib.MATERIAL}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.Lib.FRAGMENT_KTX}"

    //navigation
    const val NAVIGATION_FRAGMENT =
        "androidx.navigation:navigation-fragment-ktx:${Versions.Lib.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.Lib.NAVIGATION}"
    const val NAVIGATION_RUNTIME =
        "androidx.navigation:navigation-runtime-ktx:${Versions.Lib.NAVIGATION}"
    const val NAVIGATION_DYNAMIC_FEATURE =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.Lib.NAVIGATION}"

    //retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.Lib.RETROFIT}"
    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Versions.Lib.RETROFIT}"
    const val CHUCKER_RELEAST =
        "com.github.chuckerteam.chucker:library-no-op:${Versions.Lib.CHUCKER}"
    const val CHUCKER_DEBUG = "com.github.chuckerteam.chucker:library:${Versions.Lib.CHUCKER}"
    const val OK_HTTP = "com.squareup.okhttp3:okhttp:${Versions.Lib.OKHTTP}"
    const val OK_HTTP_LOGGING = "com.squareup.okhttp3:logging-interceptor:${Versions.Lib.OKHTTP}"
    const val LOGGER = "com.orhanobut:logger:${Versions.Lib.LOGGER}"



    //ROOM
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.Lib.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.Lib.ROOM}"
    const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.Lib.ROOM}"

    /** Room **/


    //hilt
    const val HILT = "com.google.dagger:hilt-android:${Versions.Lib.HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.Lib.HILT}"
    const val DAGGER = "com.google.dagger:dagger:${Versions.Lib.HILT}"
    const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${Versions.Lib.HILT}"
    const val HILT_JAVA_POET = "com.squareup:javapoet:1.13.0"

    //lifecycle
    const val LIVECYCLE =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Lib.LIFECYCLE_VERSION}"
    const val LIFECYCLE_EXTENSIONS =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Lib.LIFECYCLE_VERSION}"
    const val LIVE_EVENT = "com.github.hadilq.liveevent:liveevent:${Versions.Lib.LIVE_EVENT}"

    //ui
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.Lib.GLIDE}"
    const val DEXTER = "com.karumi:dexter:${Versions.Lib.DEXTER}"
    const val SHIMMER = "com.facebook.shimmer:shimmer:${Versions.Lib.SHIMMER}"


    object Test {
        const val MOCKITO = "org.mockito:mockito-core:${Versions.Test.MOCKITO}"
        object Unit {
            const val JUNIT = "junit:junit:${Versions.Test.JUNIT}"
        }

        object Integration {
            const val JUNIT = "androidx.test.ext:junit:${Versions.Test.JUNIT_INTEGRATION}"
            const val ESPRESSO_CORE =
                "androidx.test.espresso:espresso-core:${Versions.Test.ESPRESSO}"
        }
    }

    fun DependencyHandlerScope.implementationApp() {
        "implementation"(STDLIB)
        "implementation"(platform(KOTLIN_BOM))
        "implementation"(MULTIDEX)
    }

    fun DependencyHandlerScope.implementationCommon() {
        "implementation"(CORE)
        "implementation"(MATERIAL)
        "implementation"(CONSTRAINT_LAYOUT)
        "implementation"(FRAGMENT_KTX)
        "implementation"(DEXTER)
//        "implementation"(HILT_JAVA_POET)
        "implementation"(HILT)
        "implementation"(DAGGER)
        "kapt"(HILT_COMPILER)
        "kapt"(DAGGER_COMPILER)

    }

    fun DependencyHandlerScope.implementationNavigation() {
        "implementation"(NAVIGATION_FRAGMENT)
        "implementation"(NAVIGATION_UI)
        "implementation"(NAVIGATION_RUNTIME)
    }

    fun DependencyHandlerScope.implementationLifeCycle() {
        "implementation"(LIVECYCLE)
        "implementation"(LIFECYCLE_EXTENSIONS)
        "implementation"(LIVE_EVENT)
    }

    fun DependencyHandlerScope.implementationRoom() {
        "implementation"(ROOM_RUNTIME)
        "implementation"(ROOM_KTX)
        "kapt"(ROOM_COMPILER)
        "annotationProcessor"(ROOM_COMPILER)

    }

    fun DependencyHandlerScope.implementationRetrofit() {
        "implementation"(RETROFIT)
        "implementation"(RETROFIT_GSON)
        "debugImplementation"(CHUCKER_DEBUG)
        "releaseImplementation"(CHUCKER_RELEAST)
        "implementation"(Dependencies.OK_HTTP)
        "implementation"(Dependencies.OK_HTTP_LOGGING)
        "implementation"(Dependencies.LOGGER)
    }

    fun DependencyHandlerScope.implementationTest() {
        "testImplementation"(Test.Unit.JUNIT)
        "androidTestImplementation"(Test.Integration.JUNIT)
        "androidTestImplementation"(Test.Integration.ESPRESSO_CORE)
        "testImplementation"(Test.MOCKITO)

    }

    fun DependencyHandlerScope.implementationFeature() {
        "implementation"(GLIDE)
        "implementation"(SHIMMER)


    }
}