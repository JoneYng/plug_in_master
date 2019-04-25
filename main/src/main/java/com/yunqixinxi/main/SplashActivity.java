package com.yunqixinxi.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGHT=3000;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        //加载布局文件
        setContentView(R.layout.main_activity_splash);

        handler=new Handler();

        //延迟 SPLASH_DISPLAY_LENGHT时间然后跳转到MainActivity
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent();
                intent.setClass(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();

            }
        }, SPLASH_DISPLAY_LENGHT);
    }

    /* 禁用返回键
     *(non-Javadoc)
     * @see android.app.Activity#onKeyDown(int, android.view.KeyEvent)
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
