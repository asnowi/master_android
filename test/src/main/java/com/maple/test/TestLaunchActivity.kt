package com.maple.test

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContract
import com.maple.baselib.utils.StringUtils
import com.maple.commonlib.base.BaseActivity

class TestLaunchActivity : BaseActivity() {
    private lateinit var etInput: EditText
    private lateinit var btnOpen: Button

    override fun getLayoutId(): Int = R.layout.activity_test_launch


    private val launcherResult = registerForActivityResult(object :ActivityResultContract<String,String>() {
        //创建启动页面所需的Intent对象，传入需要传递的参数
        override fun createIntent(context: Context, input: String): Intent {
            return Intent(this@TestLaunchActivity,TestResultActivity::class.java).apply {
                putExtra("input",input)
            }
        }

        //页面回传的数据解析，相当于原onActivityResult方法
        override fun parseResult(resultCode: Int, intent: Intent?): String {
           val data =  intent?.getStringExtra("result")?: ""
            return if(resultCode == RESULT_OK) data else ""
        }
    }) {
        it?.let { res ->
            etInput.setText(res)
        }
    }
    override fun initData(savedInstanceState: Bundle?) {
        etInput = findViewById(R.id.et_input)
        btnOpen = findViewById(R.id.btn_open)
        btnOpen.setOnClickListener {
            if(StringUtils.isNotEmpty(etInput.text.toString())) {
                launcherResult.launch(etInput.text.toString())
            } else{
                showToast("请输入文本！")
            }
        }
    }
}