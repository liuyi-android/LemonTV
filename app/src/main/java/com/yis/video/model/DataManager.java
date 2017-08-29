package com.yis.video.model;

import com.yis.video.model.db.DBHelper;
import com.yis.video.model.http.HttpHelper;

import io.realm.Realm;

/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @desciption:
 */
public class DataManager implements HttpHelper, DBHelper {

    HttpHelper mHttpHelper;
    DBHelper mDbHelper;

    public DataManager(HttpHelper httpHelper, DBHelper dbHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
    }

    @Override
    public Realm getRealm() {
        return mDbHelper.getRealm();
    }


}
