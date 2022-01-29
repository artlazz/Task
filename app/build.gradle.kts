plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-android")
}

android {
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName(AppConfig.ReleaseTypes.release) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(AppConfig.ProguardFiles.defaultProguardFile),
                AppConfig.ProguardFiles.file
            )
        }
        getByName(AppConfig.ReleaseTypes.debug) {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks {
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    viewBinding {
        android.buildFeatures.viewBinding = true
    }
}

dependencies {
    implementation(project(Modules.common))
    implementation(project(Modules.domain))
    // std libs
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //app libs
    implementation(Dependencies.appLibraries)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    // test libs
    testImplementation(Dependencies.testLibraries)
    androidTestImplementation(Dependencies.androidTestLibraries)
}