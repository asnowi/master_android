package com.maple.baselib.utils

import android.util.Log
import com.blankj.utilcode.util.SizeUtils

class LogUtils {
    companion object {
        fun log(s: String?) {
            if(s != null) {
                Log.e("GGQ", s)
            }
        }
    }
}