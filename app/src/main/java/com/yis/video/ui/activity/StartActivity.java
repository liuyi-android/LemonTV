package com.yis.video.ui.activity;

import android.os.Bundle;

import com.yis.video.R;
import com.yis.video.base.BaseActivity;
import com.yis.video.ui.presenter.StartPresenter;
import com.yis.video.ui.view.StartView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yivideo on 2017/8/18.
 */

public class StartActivity extends BaseActivity {

    @BindView(R.id.start_view)
    StartView startView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        unbinder = ButterKnife.bind(this);
        mPresenter = new StartPresenter(startView);
    }
}
