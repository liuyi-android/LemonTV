package com.yis.video.ui.view;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yis.video.R;
import com.yis.video.base.RootView;
import com.yis.video.presenter.contract.MainContract;
import com.yis.video.ui.activity.MainActivity;
import com.yis.video.ui.adapter.MainPagerAdapter;
import com.yis.video.ui.fragment.HotFragment;
import com.yis.video.ui.fragment.IndexFragment;
import com.yis.video.ui.fragment.UserFragment;
import com.yis.video.ui.fragment.ZhiboFragment;
import com.yis.video.utils.Preconditions;
import com.yis.video.widget.UnScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by yivideo on 2017/8/22.
 */

public class MainView extends RootView<MainContract.Presenter> implements MainContract.View {

    @BindView(R.id.view_pager)
    UnScrollViewPager viewPager;
    private MainPagerAdapter mainPagerAdapter;

    @BindView(R.id.rg_tab)
    RadioGroup rgTab;
    @BindView(R.id.rb_index)
    RadioButton rbIndex;
    @BindView(R.id.rb_hot)
    RadioButton rbHot;
    @BindView(R.id.rb_zhibo)
    RadioButton rbZhibo;
    @BindView(R.id.rb_user)
    RadioButton rbUser;

    public MainView(Context context) {
        super(context);
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.activity_main_view, this);
    }

    @Override
    protected void initView() {

        List<Fragment> fragments = new ArrayList<>();
        Fragment indexFragment = new IndexFragment();
        Fragment hotFragment = new HotFragment();
        Fragment zhiboFragment = new ZhiboFragment();
        Fragment userFragment = new UserFragment();
        fragments.add(indexFragment);
        fragments.add(hotFragment);
        fragments.add(zhiboFragment);
        fragments.add(userFragment);
        mainPagerAdapter = new MainPagerAdapter(((MainActivity) mContext).getSupportFragmentManager(), fragments);
        viewPager.setAdapter(mainPagerAdapter);
        viewPager.setOffscreenPageLimit(fragments.size());
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = Preconditions.checkNotNull(presenter);
    }

    @Override
    protected void initEvent() {
        rgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.rb_index:
                        viewPager.setCurrentItem(0, false);
                        break;
                    case R.id.rb_hot:
                        viewPager.setCurrentItem(1, false);
                        break;
                    case R.id.rb_zhibo:
                        viewPager.setCurrentItem(2, false);
                        break;
                    case R.id.rb_user:
                        viewPager.setCurrentItem(3, false);
                        break;
                }
            }
        });
    }

    @Override
    public void showError(String msg) {

    }

}
