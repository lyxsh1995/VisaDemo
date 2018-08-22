package com.lyxsh.visademo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

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
    }

    @Override
    protected void onResume() {
        super.onResume();
        bankCardList = getbankcard();
    }

    @OnClick(R.id.card_add_button)
    public void onViewClicked() {
        startActivity(new Intent(this,AddCardActivity.class));
    }
}
