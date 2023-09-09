import org.gradle.api.JavaVersion

object Versions {
    const val GRADLE = "7.1.3"
    const val KOTLIN = "1.8.2"
    const val KOTLIN_BOM = "1.8.0"
    const val MULTI_DEX = "2.0.1"

    const val SECRETS_GRADLE = "2.0.1"

    //Java Version
    val JAVA = JavaVersion.VERSION_1_8

    object App {
        const val APP_ID = "com.phanupan.greenmoons_test"
        const val VERSION_CODE = 1
        const val VERSION_NAME = "1.0.0"
        const val MIN_SDK = 24
        const val TARGET_SDK = 33
        const val COMPILE_SDK = 33
        const val TEST = "androidx.test.runner.AndroidJUnitRunner"
    }

    object Test {
        const val JUNIT = "4.13.2"
        const val JUNIT_INTEGRATION = "1.1.5"
        const val ESPRESSO = "3.3.0"
        const val MOCKITO = "5.5.0"
    }

    object Lib {
        const val MATERIAL = "1.7.0"
        const val CORE = "1.9.0"
        const val APPCOMPAT = "1.6.0"
        const val CONSTRAINT_LAYOUT = "2.1.4"
        const val FRAGMENT_KTX = "1.5.5"

        //navigation
        const val NAVIGATION = "2.6.0"

        //retrofit
        const val RETROFIT = "2.9.0"
        const val CHUCKER = "3.5.2"
        const val OKHTTP = "4.10.0"
        const val LOGGER = "2.2.0"

        //room
        const val ROOM = "2.5.2"

        //hilt
        const val HILT = "2.44"

        //lifecycle
        const val LIFECYCLE_VERSION = "2.5.1"
        const val LIVE_EVENT = "1.2.0"


        //glide
        const val GLIDE = "4.15.1"

        //dexter
        const val DEXTER = "6.2.2"

        //location
        const val SMART_LOCATION = "3.3.3"

        //shimmer
        const val SHIMMER = "0.5.0"

    }


}
