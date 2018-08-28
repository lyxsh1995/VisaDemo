package com.lyxsh.visademo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lyxsh.visademo.BaseActivity;
import com.lyxsh.visademo.Bean.BankCardList;
import com.lyxsh.visademo.R;
import com.lyxsh.visademo.Widget.EditLayout;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xushengheng on 2018/8/22.
 */
public class ConfirmPinActivity extends BaseActivity {

    @BindView(R.id.confirmpin_confirm_button)
    QMUIRoundButton confirmpinConfirmButton;
    @BindView(R.id.confirmpin_pin_edit)
    EditLayout confirmpinPinEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmpin);
    }

    @OnClick(R.id.confirmpin_confirm_button)
    public void onViewClicked() {
        if (!confirmpinPinEdit.getText().toString().equals(MainActivity.pin)){
            toast("Please check the Pin.");
            return;
        }
        BankCardList.BankCard bankCard = new BankCardList.BankCard();
        bankCard.setCardID(MainActivity.cvv);
        bankCard.setType(MainActivity.cardtype);
        addbankcard(bankCard);
        startActivity(new Intent(this, WaitActivity.class));
        finish();
    }
}
