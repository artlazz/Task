object AppConfig {
    const val applicationId = "com.task"

    const val compileSdk = 32
    const val minSdk = 23
    const val targetSdk = 32

    const val versionCode = 1
    const val versionName = "1.0"
    const val buildToolsVersion = "29.0.3"

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
    const val proguardConsumerRules = "consumer-rules.pro"

    object ReleaseTypes {
        const val release = "release"
        const val debug = "debug"
    }

    object ProguardFiles {
        const val defaultProguardFile = "proguard-android-optimize.txt"
        const val file = "proguard-rules.pro"
    }
}