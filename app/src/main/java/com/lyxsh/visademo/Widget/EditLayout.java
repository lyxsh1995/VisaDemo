package com.lyxsh.visademo.Widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lyxsh.visademo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xushengheng on 2018/8/21.
 */
public class EditLayout extends LinearLayout {
    @BindView(R.id.editlayout_layout)
    LinearLayout mainLayout;
    @BindView(R.id.editlayout_editText)
    TextView editText;
    @BindView(R.id.editlayout_imageView)
    ImageView imageView;
    String hint = "";
    int src;

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

        initView();
    }

    private void initView() {
        editText.setHint(hint);
        imageView.setImageResource(src);
    }

}
