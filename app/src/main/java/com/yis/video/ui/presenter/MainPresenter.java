package com.yis.video.ui.presenter;

import android.support.annotation.NonNull;

import com.yis.video.base.RxPresenter;
import com.yis.video.ui.presenter.contract.MainContract;
import com.yis.video.utils.Preconditions;

/**
 * Created by sunny on 2017/8/22.
 */

public class MainPresenter extends RxPresenter implements MainContract.Presenter {

    MainContract.View mView;

    public MainPresenter(@NonNull MainContract.View view) {
        mView = Preconditions.checkNotNull(view);
        mView.setPresenter(this);
    }
}
