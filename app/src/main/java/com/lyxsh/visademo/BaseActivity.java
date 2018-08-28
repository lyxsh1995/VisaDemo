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

    public BankCardList getbankcard(){
        BankCardList bankCardList = new BankCardList();
        String bankcardjson;
        bankcardjson = sharedPreferences.getString("bankcardlist","");
        if (!bankcardjson.equals("")){
            bankCardList = new Gson().fromJson(bankcardjson,BankCardList.class);
        }
        return bankCardList;
    }

    public void addbankcard(BankCardList.BankCard bankCard){
        BankCardList bankCardList = getbankcard();
        bankCardList.add(bankCard);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("bankcardlist",new Gson().toJson(bankCardList));
        editor.apply();
    }

    public void toast(String string){
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();
    }
}
