import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    // std lib
    private const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    // android ui
    private const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private const val material = "com.google.android.material:material:${Versions.material}"
    private const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    // test libs
    private const val junit = "junit:junit:${Versions.junit}"
    private const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    // coroutines
    private const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutineVersion}"
    private const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineVersion}"

    // navigation
    private const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    private const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // DI
    private const val koinAndroid = "org.koin:koin-android:${Versions.koinAndroid}"
    private const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koinAndroid}"

    // networking
    private const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private const val okHttpUrlConnection =
        "com.squareup.okhttp3:okhttp-urlconnection:${Versions.okHttpUrlConnection}"
    private const val moshiConverter =
        "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"
    private const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    // local db (Room)
    private const val roomRuntime = "androidx.room:room-runtime:${Versions.roomRuntime}"
    private const val roomRuntimeKtx = "androidx.room:room-ktx:${Versions.roomRuntimeKtx}"


    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coreKtx)
        add(appcompat)
        add(material)
        add(constraintLayout)
        add(coroutines)
        add(coroutinesAndroid)
        add(navigationFragment)
        add(navigationUi)
        add(koinAndroid)
        add(koinViewModel)
    }

    val appAndroidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val appTestLibraries = arrayListOf<String>().apply {
        add(junit)
    }

    val domainLibraries = arrayListOf<String>().apply {
        add(koinAndroid)
    }

    val dataLibraries = arrayListOf<String>().apply {
        add(coreKtx)
        add(koinAndroid)
        add(coroutines)
        add(retrofit)
        add(okHttpUrlConnection)
        add(moshiConverter)
        add(loggingInterceptor)
        add(roomRuntime)
        add(roomRuntimeKtx)
    }

    val commonLibraries = arrayListOf<String>().apply {
//        add()
    }
}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}