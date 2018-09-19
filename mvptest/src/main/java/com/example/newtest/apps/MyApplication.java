package com.example.newtest.apps;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.example.newtest.log.LogUtils;

import java.lang.ref.WeakReference;

/**
 * @author Mark
 * @create 2018/9/13
 * @Describe
 */

public class MyApplication extends Application {

    public static boolean isNetAvailable;
    private static MyApplication instance;
    private Activity app_activity = null;
    public static MyApplication getInstance(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        initGlobeActivity();
    }
    private void initGlobeActivity() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                app_activity = activity;
                LogUtils.e("onActivityCreated===", "activity=="+activity.getClass().getSimpleName());
                LogUtils.e("onActivityCreated===",  "app_activity=="+app_activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
            //    app_activity = activity;
                Log.e("onActivityDestroyed===",  "activity=="+activity.getClass().getSimpleName());
                Log.e("onActivityDestroyed===",  "app_activity=="+app_activity.getClass().getSimpleName());

            }

            /** Unused implementation **/
            @Override
            public void onActivityStarted(Activity activity) {
                app_activity = activity;
                LogUtils.e("onActivityStarted===",  "activity=="+activity.getClass().getSimpleName());
                LogUtils.e("onActivityStarted===",  "app_activity=="+app_activity.getClass().getSimpleName());

            }


            @Override
            public void onActivityResumed(Activity activity) {
                app_activity = activity;
                LogUtils.e("onActivityResumed===", "activity" + "activity=="+activity.getClass().getSimpleName());
                LogUtils.e("onActivityResumed===",  "app_activity=="+app_activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityPaused(Activity activity) {
              //  app_activity = activity;
                LogUtils.e("onActivityPaused===", "activity" + "activity=="+activity.getClass().getSimpleName());
                LogUtils.e("onActivityPaused===", "app_activity=="+app_activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityStopped(Activity activity) {
              //  app_activity = activity;
                LogUtils.e("onActivityStopped===",  "activity=="+activity.getClass().getSimpleName());
                LogUtils.e("onActivityStopped===",   "app_activity=="+app_activity.getClass().getSimpleName());
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }
        });
    }


    /**
     * 公开方法，外部可通过 MyApplication.getInstance().getCurrentActivity() 获取到当前最上层的activity
     */
    public Activity getCurrentActivity() {
        LogUtils.e("onActivity","getCurrentActivity=="+app_activity.getClass().getSimpleName());
        return app_activity;
    }

}
