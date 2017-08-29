package com.yis.video.di.component;


import com.yis.video.app.App;
import com.yis.video.di.module.AppModule;
import com.yis.video.di.module.HttpModule;
import com.yis.video.model.DataManager;
import com.yis.video.model.db.RealmHelper;
import com.yis.video.model.http.RetrofitHelper1;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    RetrofitHelper1 retrofitHelper();  //提供http的帮助类

    RealmHelper realmHelper();    //提供数据库帮助类

}
