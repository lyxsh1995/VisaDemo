package com.lyxsh.visademo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.lyxsh.visademo.BaseActivity;
import com.lyxsh.visademo.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by xushengheng on 2018/8/21.
 */
public class PhoneActivity extends BaseActivity {
    @BindView(R.id.phone_confirm_button)
    Button okbutton;
    @BindView(R.id.phone_cancel_button)
    Button cancelbutton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.lyxsh.visademo.R.layout.activity_phone);
    }
    @OnClick(R.id.phone_confirm_button)
    public void confirm(){
        startActivity(new Intent(this,CardActivity.class));
    }

    @OnClick(R.id.phone_cancel_button)
    public void cancel(){
        finish();
    }
}
