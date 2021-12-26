package com.maple.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.maple.baselib.utils.StringUtils
import com.maple.commonlib.base.BaseActivity

class TestResultActivity : BaseActivity() {
    private lateinit var etInput: EditText
    private lateinit var btnBack: Button

    override fun getLayoutId(): Int = R.layout.activity_test_result

    override fun initData(savedInstanceState: Bundle?) {
        etInput = findViewById(R.id.et_input)
        btnBack = findViewById(R.id.btn_back)

        intent?.getStringExtra("input")?.let {
            if(StringUtils.isNotEmpty(it)) {
                etInput.setText(it)
            }
        }

        btnBack.setOnClickListener {
            if(StringUtils.isNotEmpty(etInput.text.toString())) {
                val intent: Intent = Intent()
                intent.putExtra("result",etInput.text.toString())
                setResult(RESULT_OK, intent)
                this.finish()
            } else {
                showToast("请输入文本！！")
            }
        }
    }

}