package com.maple.buildsrc

/**
 * 项目相关参数配置
 */
object ProjectBuildConfig {

    const val applicationId = "com.maple.master"

    const val compileSdkVersion = 31
    const val buildToolsVersion = "31.0.0"
    const val minSdkVersion = 21
    const val targetSdkVersion = 31

    const val versionLibCode = 100
    const val versionLibName = "1.0.0"

    const val versionCode = 100
    const val versionName = "1.0.0"

    const val isAppMode = false


    /**
     * 项目当前的版本状态
     * 正式版:RELEASE、开发版:DEV
     */
    object Version {

        const val RELEASE = "VERSION_RELEASE"

        const val DEV = "VERSION_DEV"
    }
}