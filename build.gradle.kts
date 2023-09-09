buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
        }

    }


    dependencies {
        classpath(Plugins.GRADLE)
        classpath(Plugins.KOTLIN)
        classpath(Plugins.SECRETE_GRADLE)
        classpath(Plugins.HILT)
        classpath(Plugins.NAVIGATION_ARGS)


    }
}

allprojects {

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
        }
    }
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}