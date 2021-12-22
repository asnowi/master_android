package com.maple.commonlib.base

import com.zackratos.ultimatebarx.ultimatebarx.statusBarOnly
import com.maple.baselib.base.BaseFragment as B

abstract class BaseFragment: B() {

    /**
     * toast
     * @param s 显示内容
     */
    open fun showToast(s: String?) {
//        ToastUtils.showToast(s)
//        ToastUtils.showSnackbar(context,s)
    }

    override fun setStatusBarMode(color: Int) {
        super.setStatusBarMode(color)
        // 只需要设置状态栏，不需要设置导航栏
        statusBarOnly {
            // 布局是否侵入状态栏（true 不侵入，false 侵入）
            this.fitWindow = true
            // 状态栏背景颜色（资源 id）
            this.colorRes = color
            // light模式：状态栏字体 true: 灰色，false: 白色 Android 6.0+
            this.light = true
        }
    }
}