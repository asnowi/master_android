package com.maple.baselib.base

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import com.maple.baselib.utils.Event
import com.maple.baselib.utils.EventBusUtils
import com.maple.baselib.utils.UIUtils
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

abstract class BaseActivity: AppCompatActivity(), IView {

    /// 布局
    abstract fun getLayoutId(): Int

    abstract fun initData(savedInstanceState: Bundle?): Unit

    /// 是否使用 event bus
    open fun hasUsedEventBus(): Boolean = false
    // 是否使用状态栏
    open fun hasStatusBarMode(): Boolean = false
    // 是否使用 返回键拦截
    open fun hasEventKeyBack(): Boolean = false

    /// base 中相比 initData 之前的调用的方法,用来封装初始化下拉刷新组件
    open fun initView(savedInstanceState: Bundle?){}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentLayout()
        if (hasStatusBarMode()) {
            setStatusBarMode()
        }
        if (hasUsedEventBus()) {
            EventBusUtils.register(this)
        }
        initView(savedInstanceState)
        initData(savedInstanceState)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }

    /// 设置布局文件(BaseActivity 和 BaseViewActivity分别重写)
    open fun setContentLayout() {
        setContentView(getLayoutId())
    }

    /// 默认透明状态栏
    open fun setStatusBarMode(color: Int = Color.TRANSPARENT) {}

    /**
     * 接收到普通的Event
     * 封装MAIN线程模式，子类可重写 onEvnetBusReceive,
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun <T> onEventBusReceive(event: Event<T>?) {
        if (event != null) {
            onEventBusDispense(event)
        }
    }

    /**
     * 接收到粘性的Event
     * 封装MAIN线程模式，子类可重写 onStickyEvnetBusReceive,
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    open fun <T> onStickyEventBusReceive(event: Event<T>?) {
        if (event != null) {
            onStickyEventBusDispense(event)
        }
    }

    /**
     * 子类重写onEventBusDispense，处理接收到的普通事件
     */
    open fun <T> onEventBusDispense(event: Event<T>) {}

    /**
     * 子类重写onStickyEventBusDispense，处理接收到的粘性事件
     */
    open fun <T> onStickyEventBusDispense(event: Event<T>) {}

    /// 按钮防抖判断
    fun onClickProxy(m: () -> Unit) {
        if (!UIUtils.isFastDoubleClick()) {
            m()
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (hasEventKeyBack()) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                onKeyBack(keyCode)
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    open fun onKeyBack(keyCode: Int) {}


    override fun onDestroy() {
        super.onDestroy()
        if(hasUsedEventBus()) {
            EventBusUtils.unregister(this)
        }
    }
}