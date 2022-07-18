plugins {
    id("com.android.library")
    id("kotlin-parcelize")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        consumerProguardFiles(AppConfig.proguardConsumerRules)

        buildConfigField("String", "BASE_URL", "\"https://randomuser.me/\"")
        buildConfigField("int", "DATABASE_VERSION", "1")
        buildConfigField("String", "DATABASE_NAME", "\"task_database\"")
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
    implementation(project(Modules.domain))
    // data libs
    implementation(Dependencies.Collections.Data.dataLibraries)
    annotationProcessor(Dependencies.Collections.Data.dataAnnotationProcessorLibraries)
    kapt(Dependencies.Collections.Data.dataKaptLibraries)
}