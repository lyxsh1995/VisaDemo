package com.lyxsh.visademo.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import com.lyxsh.visademo.BaseActivity;
import com.lyxsh.visademo.R;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xushengheng on 2018/8/21.
 */
public class AddCardActivity extends BaseActivity {
    @BindView(R.id.addcard_cvv_edittext)
    EditText addcardCvvEdittext;
    @BindView(R.id.addcard_confirm_button)
    QMUIRoundButton addcardConfirmButton;
    @BindView(R.id.addcard_cvv_edittext2)
    EditText addcardCvvEdittext2;
    @BindView(R.id.addcard_cvv_edittext3)
    EditText addcardCvvEdittext3;
    @BindView(R.id.addcard_cvv_edittext4)
    EditText addcardCvvEdittext4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcard);
    }

    @OnClick(R.id.addcard_confirm_button)
    public void onViewClicked() {
        if (addcardCvvEdittext.getText().toString().trim().equals("")
                && addcardCvvEdittext2.getText().toString().trim().equals("")
                && addcardCvvEdittext3.getText().toString().trim().equals("")
                && addcardCvvEdittext4.getText().toString().trim().equals("")) {
            toast("Please make sure that the information provided below is correct.");
            return;
        }
        if (!addcardCvvEdittext.getText().toString().trim().equals("")){
            MainActivity.cvv = addcardCvvEdittext.getText().toString().trim();
            MainActivity.cardtype = 1;
        }
        if (!addcardCvvEdittext2.getText().toString().trim().equals("")){
            MainActivity.cvv = addcardCvvEdittext2.getText().toString().trim();
            MainActivity.cardtype = 2;
        }
        if (!addcardCvvEdittext3.getText().toString().trim().equals("")){
            MainActivity.cvv = addcardCvvEdittext3.getText().toString().trim();
            MainActivity.cardtype = 3;
        }
        if (!addcardCvvEdittext4.getText().toString().trim().equals("")){
            MainActivity.cvv = addcardCvvEdittext4.getText().toString().trim();
            MainActivity.cardtype = 4;
        }


        startActivity(new Intent(this, ConfirmPinActivity.class));
        finish();
    }
}
