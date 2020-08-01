package com.winks.demo.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.LogUtils;
import com.winks.demo.R;
import com.winks.utils.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DemoActivity extends BaseActivity {
    @BindView(R.id.demo_input)
    EditText mInput;
    @Override
    protected boolean isTranslucentStatusBar() {
        return false;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("data",mInput.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String test =  savedInstanceState.getString("data");
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_demo;
    }

    public void onSave(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        if (savedInstanceState!=null){
            String test = savedInstanceState.getString("data");
            LogUtils.e("数据Create："+test);
        }
    }
}
