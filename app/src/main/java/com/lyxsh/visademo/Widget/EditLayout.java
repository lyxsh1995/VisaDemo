package com.lyxsh.visademo.Widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lyxsh.visademo.R;

import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xushengheng on 2018/8/21.
 */
public class EditLayout extends LinearLayout {
    private final static int INPUTTYPE_TEXT = 0;
    private final static int INPUTTYPE_NUMBER = 1;
    private final static int INPUTTYPE_NUMBER_PASSWORD = 2;
    private final static int INPUTTYPE_DATE = 3;
    @BindView(R.id.editlayout_layout)
    LinearLayout mainLayout;
    @BindView(R.id.editlayout_editText)
    EditText editText;
    @BindView(R.id.editlayout_imageView)
    ImageView imageView;
    String hint = "";
    int src;
    int inputtype;

    public EditLayout(Context context) {
        this(context, null);
    }

    public EditLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EditLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.view_widget_editlayout, this);
        ButterKnife.bind(this);

        TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.EditLayout);
        hint = ta.getString(R.styleable.EditLayout_hint);
        src = ta.getResourceId(R.styleable.EditLayout_src, R.drawable.ic_visa_logo);
        inputtype = ta.getInt(R.styleable.EditLayout_inputType, INPUTTYPE_TEXT);

        initView();
    }

    private void initView() {
        editText.setHint(hint);
        imageView.setImageResource(src);
        switch (inputtype) {
            case INPUTTYPE_TEXT:
                editText.setInputType(EditorInfo.TYPE_CLASS_TEXT);
                break;
            case INPUTTYPE_NUMBER:
                editText.setInputType(EditorInfo.TYPE_CLASS_PHONE);
                break;
            case INPUTTYPE_NUMBER_PASSWORD:
                editText.setInputType(18);
                break;
            case INPUTTYPE_DATE:
                editText.setInputType(20);
                break;
        }
    }

    public CharSequence getText() {
        return editText.getText();
    }
}
