plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
//        versionCode = AppConfig.versionCode
//        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        consumerProguardFiles(AppConfig.proguardConsumerRules)
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
}

dependencies {
    implementation(project(Modules.common))
    // data libs
    implementation(Dependencies.dataLibraries)
}