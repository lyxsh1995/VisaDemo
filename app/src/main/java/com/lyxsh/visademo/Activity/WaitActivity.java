package com.lyxsh.visademo.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;

import com.lyxsh.visademo.BaseActivity;
import com.lyxsh.visademo.R;
import com.qmuiteam.qmui.widget.QMUIProgressBar;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xushengheng on 2018/8/22.
 */
public class WaitActivity extends BaseActivity {
    @BindView(R.id.confirmpin_progressbar)
    QMUIProgressBar confirmpinProgressbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);

        setprogress();
    }

    private void setprogress() {
        confirmpinProgressbar.setQMUIProgressBarTextGenerator(new QMUIProgressBar.QMUIProgressBarTextGenerator() {
            @Override
            public String generateText(QMUIProgressBar progressBar, int value, int maxValue) {
                return value/10+"%";
            }
        });
        Flowable flowable = Flowable.intervalRange(1,1000,0,50, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        confirmpinProgressbar.setProgress(aLong.intValue());
                    }
                })
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        if (isFinishing()){
                            return;
                        }
                        new QMUIDialog.MessageDialogBuilder(WaitActivity.this)
                                .setMessage("Succeed")
                                .addAction("OK", new QMUIDialogAction.ActionListener() {
                                    @Override
                                    public void onClick(QMUIDialog dialog, int index) {
                                        dialog.dismiss();
                                        finish();
                                    }
                                })
                                .setCanceledOnTouchOutside(false)
                                .create(R.style.DialogTheme2)
                                .show();
                    }
                });
                flowable.subscribe();
    }
}
