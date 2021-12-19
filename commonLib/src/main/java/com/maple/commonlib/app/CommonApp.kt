package com.maple.commonlib.app

import com.kongqw.network.monitor.NetworkMonitorManager
import com.maple.baselib.app.BaseApp
import com.tencent.mmkv.MMKV

abstract class CommonApp: BaseApp() {

    companion object {
        @JvmStatic
        lateinit var instance: CommonApp
            private set
    }

    override fun initApp() {
        super.initApp()
        instance = this
        MMKV.initialize(this)
        NetworkMonitorManager.getInstance().init(this)
    }
}