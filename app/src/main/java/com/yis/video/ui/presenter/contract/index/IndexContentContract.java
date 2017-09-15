package com.yis.video.ui.presenter.contract.index;

import com.yis.video.base.BasePresenter;
import com.yis.video.base.BaseView;

import java.util.List;

/**
 * Created by Yis on 2017/8/31.
 */

public interface IndexContentContract {

    interface View extends BaseView<Presenter>{
        //activity是否被销毁
        boolean isDesActivity();

        //展示内容
        void showData(List<String> playImgs,List<String> videoImgs);
    }

    interface Presenter extends BasePresenter{

        //获取数据
        void getData();

    }
}
