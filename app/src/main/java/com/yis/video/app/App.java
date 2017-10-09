package com.yis.video.app;


import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.support.v7.app.AppCompatDelegate;

import com.yis.video.di.component.DaggerAppComponent;
import com.yis.video.di.component.AppComponent;
import com.yis.video.di.module.AppModule;
import com.yis.video.di.module.HttpModule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.realm.Realm;

/******************************************
 * 类名称：App
 * 类描述：
 *
 * @version: 2.3.1
 * @author: caopeng
 * @time: 2016/9/13 10:53
 ******************************************/
public class App extends Application {

    private static App instance;
    private Set<Activity> allActivities;

    public static Map<Integer,Handler> sHandlerMap=new HashMap<>();
    public static Map<Integer,Runnable> sRunnableMap=new HashMap<>();

    public static void stop() {
        for (int i=0;i<App.sHandlerMap.size();i++){
            if (App.sHandlerMap.get(i)!=null){
                //NewsApplication.sHandlerMap.get(i).removeCallbacksAndMessages(null);
                App.sHandlerMap.get(i).removeCallbacks(App.sRunnableMap.get(i));
            }
        }
    }


    public static App getInstance() {
        return instance;
    }

    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //蒲公英crash上报
//        PgyCrashManager.register(this);
        //初始化内存泄漏检测
//        LeakCanary.install(this);
        //初始化过度绘制检测
//        BlockCanary.install(this, new AppBlockCanaryContext()).start();
        //初始化realm
//        initRealm();
        Realm.init(getApplicationContext());
    }

    public void registerActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<Activity>();
        }
        allActivities.add(act);
    }

    public void unregisterActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    if (act != null && !act.isFinishing())
                        act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

//    private void initRealm() {
//        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
//                .name(RealmHelper.DB_NAME)
//                .schemaVersion(1)
//                .rxFactory(new RealmObservableFactory())
//                .deleteRealmIfMigrationNeeded()
//                .build();
//        Realm.setDefaultConfiguration(realmConfiguration);
//    }

    public static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }
}