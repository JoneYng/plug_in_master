package com.yunqi.product.core.base.application;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import com.facebook.stetho.Stetho;
import com.yunqi.product.core.BuildConfig;
import com.yunqi.product.core.base.CoreApplication;
import com.yunqi.product.core.util.AppUtils;
import com.yunqi.product.router.RouterConfig;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.tencent.bugly.crashreport.CrashReport;
import com.wanjian.cockroach.Cockroach;
import com.wanjian.cockroach.ExceptionHandler;

/**
 * @Created by TOME .
 * @时间 2018/5/14 17:20
 * @描述 ${保存全局变量设计的基本类application}
 */

public class BaseApplication extends CoreApplication {

    private String BUGLY_ID = "22f2bbe21a" ;

    //SmartRefreshLayout 有三种方式,请参考:https://github.com/scwang90/SmartRefreshLayout
    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
               // layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //Locale _UserLocale = LocaleHelper.getLanguage(this);
        //系统语言改变了应用保持之前设置的语言
        //        if (_UserLocale != null) {
        //            LocaleHelper.setLocale(this, _UserLocale);
        //        }
        //        L.i("当前语言："+_UserLocale );
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //arouter路由初始化
        RouterConfig.init(this, !BuildConfig.DEBUG);

        //bugly初始化
        initBugly();
        //初始化防止APP崩溃 catch
        install();
        //Stetho调试工具初始化
        Stetho.initializeWithDefaults(this);

    }



    private void initBugly() {
        // 获取当前包名
        String packageName = getApplicationContext().getPackageName();
        // 获取当前进程名
        String processName = AppUtils.getProcessName(android.os.Process.myPid());
        // 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(getApplicationContext());
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        CrashReport.initCrashReport(getApplicationContext(), BUGLY_ID, false, strategy);
    }

    private void install() {
        //子线程的异常,建议杀死APP
        final Thread.UncaughtExceptionHandler sysExcepHandler = Thread.getDefaultUncaughtExceptionHandler();
        final Toast toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        //DebugSafeModeUI.init(this);
        Cockroach.install(this, new ExceptionHandler() {
            @Override
            protected void onUncaughtExceptionHappened(Thread thread, Throwable throwable) {
                Log.e("AndroidRuntime", "捕获异常--->onUncaughtExceptionHappened:" + thread + "<---", throwable);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        if (BuildConfig.DEBUG) {
                            toast.setText("捕获到导致崩溃的异常");
                            toast.show();
                        }
                    }
                });
            }

            @Override
            protected void onBandageExceptionHappened(Throwable throwable) {
                throwable.printStackTrace();//打印警告级别log，该throwable可能是最开始的bug导致的，无需关心
                Log.e("AndroidRuntime", "--->onBandageExceptionHappened:" + "<---");
                if (BuildConfig.DEBUG) {
                    toast.setText("Cockroach Worked");
                    toast.show();
                }
            }

            @Override
            protected void onEnterSafeMode() {
                //好像该方法只会调用一次,首次调用
                if (BuildConfig.DEBUG) {
                Toast.makeText(BaseApplication.this, "已经进入安全模式", Toast.LENGTH_LONG).show();
                //进入界面
                }
            }

            @Override
            protected void onMayBeBlackScreen(Throwable e) {
                Thread thread = Looper.getMainLooper().getThread();
                Log.e("AndroidRuntime", "--->onUncaughtExceptionHappened:" + thread + "<---", e);
                //黑屏时建议直接杀死app
                // sysExcepHandler.uncaughtException(thread, new RuntimeException("black screen"));
            }

        });
    }
}