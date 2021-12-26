package com.maple.test

import android.os.Bundle
import com.maple.commonlib.base.BaseActivity

class SplashActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun initData(savedInstanceState: Bundle?) {
        onStartActivity(TestLaunchActivity::class.java)
    }
}