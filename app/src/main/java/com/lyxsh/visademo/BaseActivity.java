package com.lyxsh.visademo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lyxsh.visademo.Bean.BankCardList;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import butterknife.ButterKnife;

/**
 * Created by xushengheng on 2018/8/21.
 */
public abstract class BaseActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QMUIStatusBarHelper.translucent(this);
        ActivityManage.getInstance().addActivity(this);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        sharedPreferences = getSharedPreferences("visa",MODE_PRIVATE);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManage.getInstance().removeActivity(this);
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

    public BankCardList getbankcard(){
        BankCardList bankCardList = null;
        String bankcardjson;
        bankcardjson = sharedPreferences.getString("bankcard","");
        if (!bankcardjson.equals("")){
            bankCardList = new Gson().fromJson(bankcardjson,BankCardList.class);
        }
        return bankCardList;
    }
}
