package com.lyxsh.visademo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.lyxsh.visademo.ActivityManage;
import com.lyxsh.visademo.Adapter.BankCardAdapter;
import com.lyxsh.visademo.BaseActivity;
import com.lyxsh.visademo.Bean.BankCardList;
import com.lyxsh.visademo.R;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xushengheng on 2018/8/21.
 */
public class CardActivity extends BaseActivity {
    @BindView(R.id.card_recyclerview)
    RecyclerView cardRecyclerview;
    @BindView(R.id.card_add_button)
    QMUIRoundButton cardAddButton;

    BankCardList bankCardList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        cardRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        cardRecyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void onResume() {
        super.onResume();
        bankCardList = getbankcard();
        BankCardAdapter bankCardAdapter = new BankCardAdapter(this,bankCardList);
        cardRecyclerview.setAdapter(bankCardAdapter);
    }

    @OnClick(R.id.card_add_button)
    public void onViewClicked() {
        startActivity(new Intent(this,AddCardActivity.class));
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
