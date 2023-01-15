object AppConfig {
    const val applicationId = "com.task" // FIXME rename the applicationId

    const val compileSdk = 32
    const val minSdk = 26 // FIXME replace minSdk
    const val targetSdk = 32 // FIXME replace targetSdk

    const val versionCode = 1
    const val versionName = "0.0.1"
    const val buildToolsVersion = "0.0.1"

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
    const val proguardConsumerRules = "consumer-rules.pro"

    const val jvmTarget = "1.8"

    const val kotlinCompilerExtensionVersion = "1.1.1"

    object ReleaseTypes {
        const val release = "release"
        const val debug = "debug"
    }

    object ProguardFiles {
        const val defaultProguardFile = "proguard-android-optimize.txt"
        const val file = "proguard-rules.pro"
    }
}