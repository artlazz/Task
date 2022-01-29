plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        consumerProguardFiles(AppConfig.proguardConsumerRules)

        buildConfigField("String", "BASE_URL", "\"https://randomuser.me/\"")
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
}

dependencies {
    implementation(project(Modules.common))
    // data libs
    implementation(Dependencies.dataLibraries)
}