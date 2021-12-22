package com.maple.buildsrc

/**
 * 项目依赖版本统一管理
 */
object DependencyConfig {

    object Android {
        const val material = "com.google.android.material:material:1.4.0"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.6.0"
        const val appcompat = "androidx.appcompat:appcompat:1.3.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.1"
        const val activityKtx = "androidx.activity:activity-ktx:1.4.0"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.4.0"
        const val multiDex = "androidx.multidex:multidex:2.0.1"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.2.1"
    }

    object Kotlin {
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:1.5.20"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"
    }

    object JetPack {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0"
        const val viewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:2.4.0"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:2.4.0"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0"
        const val extensions = "android.arch.lifecycle:extensions:1.1.1"
        const val lifecycleCompilerAPT = "androidx.lifecycle:lifecycle-compiler:2.4.0"
    }

    object Navigation {
        const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:2.4.0-beta02"
        const val navigationUIKtx = "androidx.navigation:navigation-ui-ktx:2.4.0-beta02"
        const val navigationTesting = "androidx.navigation:navigation-testing:2.4.0-beta02"
    }
    object Junit {
        const val junit = "junit:junit:4.+"
        const val testExtJunit = "androidx.test.ext:junit:1.1.2"
        const val testEspresso = "androidx.test.espresso:espresso-core:3.3.0"
    }

    object Http {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val converter = "com.squareup.retrofit2:converter-gson:2.9.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:4.9.0"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.9.0"
        const val gson = "com.google.code.gson:gson:2.8.6"
    }

    object EventBus {
        const val eventBus = "org.greenrobot:eventbus:3.2.0"
        const val eventBusAPT = "org.greenrobot:eventbus-annotation-processor:3.2.0"
    }

    object ImageLoader {
        const val coil = "io.coil-kt:coil:1.4.0"
        const val coilGIF = "io.coil-kt:coil-gif:1.4.0"
        const val coilSVG = "io.coil-kt:coil-svg:1.4.0"

    }

    object Db {

    }

    object Ext {
        const val utils = "com.blankj:utilcodex:1.31.0"
        const val statePage = "com.github.Zhao-Yan-Yan:MultiStatePage:2.0.2"
        const val statusBar = "com.gitee.zackratos:UltimateBarX:0.8.0"
        const val networkState = "com.github.kongqw:NetworkMonitor:1.1.0"
        const val mmkv = "com.tencent:mmkv:1.2.11"
        const val lottie = "com.airbnb.android:lottie:4.2.2"

    }

}