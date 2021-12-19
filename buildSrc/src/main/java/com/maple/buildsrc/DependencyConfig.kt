package com.maple.buildsrc

/**
 * 项目依赖版本统一管理
 */
object DependencyConfig {


    object Android {
        const val Material = "com.google.android.material:material:1.3.0"
    }

    object AndroidX {
        const val CoreKtx = "androidx.core:core-ktx:1.6.0"
        const val Appcompat = "androidx.appcompat:appcompat:1.3.0"
        const val ConstraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val ActivityKtx = "androidx.activity:activity-ktx:1.4.0"
        const val FragmentKtx = "androidx.fragment:fragment-ktx:1.4.0"
        const val MultiDex = "androidx.multidex:multidex:2.0.1"
        const val Recyclerview = "androidx.recyclerview:recyclerview:1.2.1"
    }

    object Kotlin {
        const val KotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:1.5.20"
        const val CoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2"
        const val CoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"
    }

    object JetPack {
        const val ViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0"
        const val ViewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:2.4.0"
        const val LiveData = "androidx.lifecycle:lifecycle-livedata-ktx:2.4.0"
        const val Lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0"
        const val Extensions = "android.arch.lifecycle:extensions:1.1.1"
        const val LifecycleCompilerAPT = "androidx.lifecycle:lifecycle-compiler:2.4.0"
    }

    object Junit {
        const val Junit = "junit:junit:4.+"
        const val TestExtJunit = "androidx.test.ext:junit:1.1.2"
        const val TestEspresso = "androidx.test.espresso:espresso-core:3.3.0"
    }

    object Http {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val converter = "com.squareup.retrofit2:converter-gson:2.9.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:4.9.0"
        const val gson = "com.google.code.gson:gson:2.8.6"
    }

    object EventBus {
        const val eventBus = "org.greenrobot:eventbus:3.2.0"
        const val eventBusAPT = "org.greenrobot:eventbus-annotation-processor:3.2.0"
    }

    object ImageLoader {

    }

    object Db {

    }

    object Ext {
        const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.7"
        const val utils = "com.blankj:utilcodex:1.31.0"
        const val statePage = "com.github.Zhao-Yan-Yan:MultiStatePage:2.0.2"
        const val statusBar = "com.gitee.zackratos:UltimateBarX:0.8.0"
        const val networkState = "com.github.kongqw:NetworkMonitor:1.1.0"

    }

}