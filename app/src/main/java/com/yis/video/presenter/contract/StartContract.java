package com.yis.video.presenter.contract;

import com.yis.video.base.BasePresenter;
import com.yis.video.base.BaseView;


/**
 * Created by sunny on 2017/8/22.
 */

public interface StartContract {

    interface View extends BaseView<Presenter> {
        boolean isActive();

        void showImg(String img);

        void showFail(String msg);

        void jumpToMain();
    }

    interface Presenter extends BasePresenter {
        void getStartImg();
    }
}
