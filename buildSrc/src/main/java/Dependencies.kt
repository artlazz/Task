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
    private const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    private const val koinTest = "io.insert-koin:koin-test:${Versions.koin}"
    private const val koinAndroid = "org.koin:koin-android:${Versions.koinAndroid}"
    private const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koinAndroid}"

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
        add(koinCore)
        add(koinAndroid)
        add(koinViewModel)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
        add(koinTest)
    }

    val domainLibraries = arrayListOf<String>().apply {
        add(koinCore)
    }

    val dataLibraries = arrayListOf<String>().apply {
        add(coreKtx)
        add(koinCore)
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