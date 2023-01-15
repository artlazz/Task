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

    // compose ui
    private const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    private const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    private const val lifeCycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}"
    private const val composeActivity =
        "androidx.activity:activity-compose:${Versions.composeActivity}"
    private const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    private const val composeUiTestManifest =
        "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
    private const val composeConstraintLayout =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.composeConstraintLayout}"
    private const val composeUtils =
        "com.google.accompanist:accompanist-systemuicontroller:${Versions.composeSystem}"
    private const val composePager =
        "com.google.accompanist:accompanist-pager:${Versions.composePager}"
    private const val composeUtil =
        "androidx.compose.ui:ui-util:${Versions.compose}"
    private const val composeShimmer =
        "com.valentinilk.shimmer:compose-shimmer:${Versions.composeShimmer}"

    // Google map
    private const val googleMap = "com.google.maps.android:maps-ktx:${Versions.googleMap}"
    private const val googleMapUtils =
        "com.google.maps.android:android-maps-utils:${Versions.googleMapUtils}"

    // Google play services = "com.google.android.gms:play-services-maps"
    private const val googlePlayServices =
        "com.google.android.gms:play-services-maps:${Versions.googlePlayService}"
    private const val googlePlayServicesMap =
        "com.google.android.gms:play-services-maps:${Versions.googlePlayServiceMap}"
    private const val googlePlayServiceLocation =
        "com.google.android.gms:play-services-location:${Versions.googlePlayServiceLocation}"

    // Google billing
    private const val billing = "com.android.billingclient:billing-ktx:${Versions.googleBilling}"

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
    private const val composeNavigation =
        "androidx.navigation:navigation-compose:${Versions.navigation}"

    // DI
    private const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    private const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
    private const val koinCompose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"

    // networking
    private const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private const val okHttpUrlConnection =
        "com.squareup.okhttp3:okhttp-urlconnection:${Versions.okHttpUrlConnection}"
    private const val moshiConverter =
        "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"
    private const val gsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"
    private const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    // local db (Room)
    private const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    private const val roomRuntimeKtx = "androidx.room:room-ktx:${Versions.room}"
    private const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    // image processing
    private const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    // charts
    private const val chartView = "com.github.PhilJay:MPAndroidChart:${Versions.chartView}"

    private const val chuckerDebug = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    private const val chuckerRelease =
        "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"

    private const val lottieAnimations = "com.airbnb.android:lottie:${Versions.lottie}"

    private const val splashScreen = "androidx.core:core-splashscreen:${Versions.splash}"

    // Facebook
    private const val facebookSdk = "com.facebook.android:facebook-android-sdk:${Versions.facebook}"
    private const val facebookLogin = "com.facebook.android:facebook-login:${Versions.facebook}"

    // GOOGLE AUTH
    private const val googleAuth =
        "com.google.android.gms:play-services-auth:${Versions.googleAuth}"

    // Google Ad mob
    private const val googleAds = "com.google.android.gms:play-services-ads:${Versions.googleAds}"

    object Collections {
        /* app module section */
        object App {
            val appLibraries = arrayListOf<String>().apply {
                add(kotlinStdLib)
            }
            val appTestLibraries = arrayListOf<String>().apply {
                add(junit)
            }
            val appAndroidTestLibraries = arrayListOf<String>().apply {
                add(extJUnit)
                add(espressoCore)
            }
        }

        /* domain module section */
        object Domain {
            val domainLibraries = arrayListOf<String>().apply {
                add(coroutines)
                add(koinCore)
            }
        }

        /* data module section */
        object Data {
            val dataLibraries = arrayListOf<String>().apply {
                add(coroutines)
                add(koinCore)
                add(retrofit)
                add(okHttpUrlConnection)
                add(moshiConverter)
                add(loggingInterceptor)
            }
            val dataKaptLibraries = arrayListOf<String>().apply {
            }
            val dataAnnotationProcessorLibraries = arrayListOf<String>().apply {
            }
            val debugImplementation = arrayListOf<String>().apply {
                add(chuckerDebug)
            }
            val releaseImplementation = arrayListOf<String>().apply {
                add(chuckerRelease)
            }
        }
    }
}

// util functions for adding the different type dependencies from build.gradle file
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

fun DependencyHandler.annotationProcessor(list: List<String>) {
    list.forEach { dependency ->
        add("annotationProcessor", dependency)
    }
}

fun DependencyHandler.debugImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("debugImplementation", dependency)
    }
}

fun DependencyHandler.releaseImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("releaseImplementation", dependency)
    }
}
