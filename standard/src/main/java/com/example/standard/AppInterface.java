package com.example.standard;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
/**
 * @author Mark
 * @create 2018/9/29
 * @Describe
 */

public interface AppInterface {
    void setContentView(int layoutResID);

    <T extends View> T findViewById(int id);

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onDestroy();

    void onPause();

    void onSaveInstanceState(Bundle outState);

    /**
     * 需要宿主app注入给插件app上下文
     */
    void attach(Activity activity);
}