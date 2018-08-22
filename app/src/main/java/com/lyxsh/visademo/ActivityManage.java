package com.lyxsh.visademo;

import android.support.v7.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

/**
 * 管理activity的manage
 */
public class ActivityManage {
    private static ActivityManage instance;
    private static Set<AppCompatActivity> activitys;

    public ActivityManage() {
    }

    public static ActivityManage getInstance() {
        if (instance == null)
            instance = new ActivityManage();
        if (activitys == null)
            activitys = new HashSet<AppCompatActivity>();
        return instance;
    }

    public void addActivity(AppCompatActivity activity) {
        activitys.add(activity);
    }

    public void removeActivity(AppCompatActivity activity) {
        activitys.remove(activity);
    }

    public void finishall() {
        for (AppCompatActivity activity : activitys) {
            if (activity != null)
                activity.finish();
        }

    }

}

