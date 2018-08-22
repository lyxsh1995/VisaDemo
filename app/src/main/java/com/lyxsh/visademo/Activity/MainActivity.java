package com.lyxsh.visademo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lyxsh.visademo.BaseActivity;
import com.lyxsh.visademo.R;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import butterknife.*;

public class MainActivity extends BaseActivity {
    @BindView(com.lyxsh.visademo.R.id.main_ok_button)
    QMUIRoundButton okbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.lyxsh.visademo.R.layout.activity_main);
    }

    @OnClick(R.id.main_ok_button)
    public void ok(){
        startActivity(new Intent(this,PhoneActivity.class));
    }
}
