// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.gradle}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.saveArgs}")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
    allprojects {
        repositories {
            google()
            jcenter()
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}