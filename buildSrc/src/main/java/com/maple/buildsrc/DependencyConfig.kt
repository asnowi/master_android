package com.maple.buildsrc

/**
 * 项目依赖版本统一管理
 */
object DependencyConfig {


    object AndroidX {

    }

    object Junit {
//        testImplementation 'junit:junit:4.+'
//        androidTestImplementation 'androidx.test.ext:junit:1.1.2'
//        androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'

        const val Junit = "junit:junit:4.+"
        const val TestExtJunit = "androidx.test.ext:junit:1.1.2"
        const val TestEspresso = "androidx.test.espresso:espresso-core:3.3.0"
    }
}