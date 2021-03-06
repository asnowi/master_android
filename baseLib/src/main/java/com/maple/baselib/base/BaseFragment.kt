package com.maple.baselib.base

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.content.res.Configuration
import com.maple.baselib.utils.LogUtils
import com.maple.baselib.utils.UIUtils

abstract class BaseFragment: Fragment(), IView {

    /// 是否第一次加载 用于懒加载
    private var isFirstLoad: Boolean = true

    abstract fun getLayoutId(): Int

    abstract fun initData(savedInstanceState: Bundle?): Unit

    /// 是否使用透明状态栏
    open fun hasStatusBarMode(): Boolean = false
    open fun hasReloadStatusBar(): Boolean = false

    open fun initView(view: View, savedInstanceState: Bundle?){}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return setContentLayout(inflater, container, savedInstanceState)
    }

    open fun setContentLayout(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (hasStatusBarMode()) {
            setStatusBarMode()
        }
        this.initView(view,savedInstanceState)
        this.initData(savedInstanceState)
    }

    open fun setStatusBarMode(color: Int = Color.TRANSPARENT) {}

    fun onClickProxy(m: () -> Unit) {
        if (!UIUtils.isFastClick()) {
            m()
        }
    }

    override fun onResume() {
        super.onResume()
        if (isFirstLoad) {
            isFirstLoad = false
            onLazyLoad()
        } else {
            onRestLoad()
        }
    }

    open fun onLazyLoad() {
         LogUtils.logGGQ("----------onLazyLoad-------->>>")
    }

    open fun onRestLoad() {
        if(hasStatusBarMode() && hasReloadStatusBar()) {
            setStatusBarMode()
        }
         LogUtils.logGGQ("----------onRestLoad-------->>>")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LogUtils.logGGQ("----------onConfigurationChanged-------->>>${newConfig.orientation}")
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}