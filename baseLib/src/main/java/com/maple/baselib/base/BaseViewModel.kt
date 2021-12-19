package com.maple.baselib.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maple.baselib.app.BaseApp
import com.maple.baselib.manager.SingleLiveEvent
import com.maple.baselib.utils.LogUtils
import com.maple.baselib.utils.UIUtils

abstract class BaseViewModel: ViewModel(), LifecycleObserver {

    val defUI: UIChange by lazy { UIChange() }

    val app: BaseApp by lazy {
        BaseApp.instance
    }


    fun onClickProxy(m: () -> Unit) {
        if (!UIUtils.isFastDoubleClick()) {
            m()
        }
    }

    override fun onCleared() {
        super.onCleared()
        LogUtils.logGGQ("VM ->> onCleared")
    }


    /**
     * UI事件
     */
    inner class UIChange {
        private val showDialog by lazy { SingleLiveEvent<Any>() }
        private val dismissDialog by lazy { SingleLiveEvent<Any>() }
        private val toastEvent by lazy { SingleLiveEvent<String>() }

        //0 content --  1 loading --  2 empty --  3 error
        private val stateViewEvent by lazy { MutableLiveData<ViewState>() }
        fun showUIContent(){
            stateViewEvent.postValue(ViewState.SUCCESS)
        }

        fun showUILoading(){
            stateViewEvent.postValue(ViewState.LOADING)
        }

        fun showUIEmpty(){
            stateViewEvent.postValue(ViewState.EMPTY)
        }

        fun showUIError(){
            stateViewEvent.postValue(ViewState.ERROR)
        }
    }
}