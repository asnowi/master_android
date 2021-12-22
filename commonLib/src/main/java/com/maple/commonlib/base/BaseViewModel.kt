package com.maple.commonlib.base
import androidx.lifecycle.viewModelScope
import com.maple.baselib.utils.LogUtils
import com.maple.baselib.utils.NetworkUtil
import com.maple.commonlib.http.error.ERROR
import com.maple.commonlib.http.error.ExceptionHandle
import com.maple.commonlib.http.error.ResponseThrowable
import com.maple.commonlib.http.resp.BaseResp
import com.maple.commonlib.http.resp.ResultCode
import kotlinx.coroutines.*
import com.maple.baselib.base.BaseViewModel as B

open class BaseViewModel: B() {

    /**
     *  不过滤请求结果
     * @param block 请求体
     * @param error 失败回调
     * @param complete  完成回调（无论成功失败都会调用）
     * @param isShowDialog 是否显示加载框
     */
    fun launchGo(
        isShowDialog: Boolean = true,
        isShowToast: Boolean = true,
        block: suspend CoroutineScope.() -> Unit,
        error: suspend CoroutineScope.(ResponseThrowable) -> Unit = {
            LogUtils.logGGQ("--isShowToast-->${isShowToast}")
            LogUtils.logGGQ("--error-->${it.errMsg}")
            if(isShowToast) defUI.onToast(it.errMsg)
        },
        complete: suspend CoroutineScope.() -> Unit = {}
    ) {
        if (!NetworkUtil.isConnected()) {
            defUI.onToast(ERROR.NETWORD_UNCONNECTED.getValue())
            return
        }
        if (isShowDialog) defUI.onShowDialog()
        launchUI {
            handleException(
                withContext(Dispatchers.IO) { block },
                { error(it) },
                {
                    complete()
                    defUI.onDismissDialog()
                }
            )
        }
    }


    /**
     * 过滤请求结果，其他全抛异常
     * @param block 请求体
     * @param success 成功回调
     * @param error 失败回调
     * @param complete  完成回调（无论成功失败都会调用）
     * @param isShowDialog 是否显示加载框
     */
    fun <T> launchOnlyResult(
        isShowDialog: Boolean = true,
        isShowToast: Boolean = true,
        block: suspend CoroutineScope.() -> BaseResp<T>,
        success: (T?) -> Unit,
        error: (ResponseThrowable) -> Unit = {
            LogUtils.logGGQ("--isShowToast--->${isShowToast}")
            LogUtils.logGGQ("--error--->${it.errMsg}")
            if(isShowToast) defUI.onToast(it.errMsg)
        },
        complete: () -> Unit = {}
    ) {
        if (!NetworkUtil.isConnected()) {
            defUI.onToast(ERROR.NETWORD_UNCONNECTED.getValue())
            return
        }
        if (isShowDialog) defUI.onShowDialog()
        launchUI {
            handleException(
                { withContext(Dispatchers.IO) { block() } },
                { res ->
                    executeResponse(res) {
                        success(it)
                    }
                },
                {
                    error(it)
                },
                {
                    if (isShowDialog) defUI.onDismissDialog()
                    complete()
                }
            )
        }
    }


    /**
     * 请求结果过滤
     */
    private suspend fun <T> executeResponse(
        response: BaseResp<T>,
        success: suspend CoroutineScope.(T?) -> Unit
    ) {
        coroutineScope {
            if (ResultCode.isSuccess(response.code)) {
                success(response.data)
            } else {
                throw ResponseThrowable(response.code, response.msg)
            }
        }
    }

    /**
     * 异常统一处理
     */
    private suspend fun handleException(
        block: suspend CoroutineScope.() -> Unit,
        error: suspend CoroutineScope.(ResponseThrowable) -> Unit,
        complete: suspend CoroutineScope.() -> Unit
    ) {
        coroutineScope {
            try {
                block()
                LogUtils.logGGQ("-->>-N-T-<<")
            } catch (e: ResponseThrowable) {
                error(ExceptionHandle.handleException(e, e))
            } finally {
                complete()
            }
        }
    }


    /**
     * 异常统一处理
     */
    private suspend fun <T> handleException(
        block: suspend CoroutineScope.() -> BaseResp<T>,
        success: suspend CoroutineScope.(BaseResp<T>) -> Unit,
        error: suspend CoroutineScope.(ResponseThrowable) -> Unit,
        complete: suspend CoroutineScope.() -> Unit
    ) {
        try {
            coroutineScope {
                try {
                    success(block())
                    LogUtils.logGGQ("-->>-T-T-<<")
                } catch (e: ResponseThrowable) {
                    error(ExceptionHandle.handleException(e, e))
                } finally {
                    complete()
                }
            }
        } catch (e: ResponseThrowable) {
            e.fillInStackTrace()
            LogUtils.logGGQ("异常--e->${e.message}")
            error(ExceptionHandle.handleException(e, e))
        }
    }

}