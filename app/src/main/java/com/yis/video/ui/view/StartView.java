package com.yis.video.ui.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.google.common.base.Preconditions;
import com.yis.video.R;
import com.yis.video.base.RootView;
import com.yis.video.component.ImageLoader;
import com.yis.video.ui.activity.MainActivity;
import com.yis.video.ui.activity.StartActivity;
import com.yis.video.ui.presenter.contract.StartContract;

import butterknife.BindView;

/**
 * Created by yivideo on 2017/8/22.
 */

public class StartView extends RootView<StartContract.Presenter> implements StartContract.View {

    @BindView(R.id.iv_start)
    ImageView ivStart;

    public StartView(Context context) {
        super(context);
    }

    public StartView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setPresenter(StartContract.Presenter presenter) {
        mPresenter = Preconditions.checkNotNull(presenter);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public boolean isActive() {
        return mActive;
    }


    @Override
    public void showImg(String img) {
        ImageLoader.load(mContext, img, ivStart);
    }

    @Override
    public void showFail(String msg) {

    }

    @Override
    public void jumpToMain() {
        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);
        ((StartActivity) mContext).finish();
    }


    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.activity_start_view, this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

    }


}
