package com.lyxsh.visademo.Activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcard);
    }

    @OnClick(R.id.addcard_confirm_button)
    public void onViewClicked() {
        finish();
    }
}
