package com.yis.video.presenter.contract;

import com.yis.video.base.BasePresenter;
import com.yis.video.base.BaseView;

/**
 * Created by sunny on 2017/8/22.
 */

public interface MainContract {


    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter {
    }
}
