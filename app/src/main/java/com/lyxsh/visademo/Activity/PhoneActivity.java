package com.lyxsh.visademo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.lyxsh.visademo.BaseActivity;
import com.lyxsh.visademo.R;
import com.lyxsh.visademo.Widget.EditLayout;

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
    @BindView(R.id.phone_pin_edit)
    EditLayout pinedit;
    @BindView(R.id.phone_confirmpin_edit)
    EditLayout confirmpinedit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.lyxsh.visademo.R.layout.activity_phone);
    }
    @OnClick(R.id.phone_confirm_button)
    public void confirm(){
        if (pinedit.getText().toString().equals("") || !pinedit.getText().toString().equals(confirmpinedit.getText().toString())){
            toast("Please check the Pin.");
            return;
        }
        MainActivity.pin = pinedit.getText().toString();
        startActivity(new Intent(this,CardActivity.class));
    }

    @OnClick(R.id.phone_cancel_button)
    public void cancel(){
        finish();
    }
}
