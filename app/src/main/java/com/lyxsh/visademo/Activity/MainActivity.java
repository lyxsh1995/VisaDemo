package com.lyxsh.visademo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.lyxsh.visademo.ActivityManage;
import com.lyxsh.visademo.BaseActivity;
import com.lyxsh.visademo.R;
import com.lyxsh.visademo.Widget.EditLayout;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import butterknife.*;

public class MainActivity extends BaseActivity {
    @BindView(com.lyxsh.visademo.R.id.main_ok_button)
    QMUIRoundButton okbutton;
    @BindView(R.id.main_bithday_editlayout)
    EditLayout bithdayedit;

    public static String pin;
    public static String cvv;
    public static int cardtype = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.lyxsh.visademo.R.layout.activity_main);
    }

    @OnClick(R.id.main_ok_button)
    public void ok(){
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        try {
            df.parse(bithdayedit.getText().toString());
        } catch (ParseException e) {
            toast("Please input the correct birthday.");
            return;
        }
        startActivity(new Intent(this,PhoneActivity.class));
    }

    private long mExitTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // screenshot();
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "再按一次返回键退出", Toast.LENGTH_SHORT).show(); //Toast.LENGTH_LONG为3.5秒，LENGTH_SHORT为3秒
                mExitTime = System.currentTimeMillis();
            } else{
                ActivityManage.getInstance().finishall();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
