package com.yis.video.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yis.video.R;
import com.yis.video.base.RootView;
import com.yis.video.ui.activity.MainActivity;
import com.yis.video.ui.adapter.MainPagerAdapter;
import com.yis.video.ui.fragment.HotFragment;
import com.yis.video.ui.fragment.IndexFragment;
import com.yis.video.ui.fragment.UserFragment;
import com.yis.video.ui.fragment.ZhiboFragment;
import com.yis.video.ui.presenter.contract.MainContract;
import com.yis.video.utils.Preconditions;
import com.yis.video.widget.UnScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by yivideo on 2017/8/22.
 */

public class MainView extends RootView<MainContract.Presenter> implements MainContract.View {

//    @BindView(R.id.view_pager)
//    UnScrollViewPager viewPager;
//    private MainPagerAdapter mainPagerAdapter;

    @BindView(R.id.fl_content)
    FrameLayout flContent;
    private List<Fragment> fragments;
    private Fragment fragment;
    private FragmentTransaction ft;
    private int currentTab; // 当前Tab页面索引

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

        fragments = new ArrayList<>();
        Fragment indexFragment = new IndexFragment();
        Fragment hotFragment = new HotFragment();
        Fragment zhiboFragment = new ZhiboFragment();
        Fragment userFragment = new UserFragment();
        fragments.add(indexFragment);
        fragments.add(hotFragment);
        fragments.add(zhiboFragment);
        fragments.add(userFragment);

        showFragment(0);

//        mainPagerAdapter = new MainPagerAdapter(((MainActivity) mContext).getSupportFragmentManager(), fragments);
//        viewPager.setAdapter(mainPagerAdapter);
//        viewPager.setOffscreenPageLimit(fragments.size());
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
                        showFragment(0);
//                        viewPager.setCurrentItem(0, false);
                        break;
                    case R.id.rb_hot:
                        showFragment(1);
//                        viewPager.setCurrentItem(1, false);
                        break;
                    case R.id.rb_zhibo:
                        showFragment(2);
//                        viewPager.setCurrentItem(2, false);
                        break;
                    case R.id.rb_user:
                        showFragment(3);
//                        viewPager.setCurrentItem(3, false);
                        break;
                }
            }
        });
    }

    @Override
    public void showError(String msg) {
    }

    /**
     * 切换底部菜单栏
     *
     * @param idx 当前位置
     */
    public void showFragment(int idx) {
        for (int i = 0; i < fragments.size(); i++) {
            fragment = fragments.get(i);
            ft = ((MainActivity) mContext).getSupportFragmentManager().beginTransaction();

            getCurrentFragment().onPause(); // 暂停当前tab
            if (idx == i) {
                if (fragment.isAdded()) {
                    fragment.onResume(); // 启动目标tab的onResume()
                } else {
                    ft.add(R.id.fl_content, fragment);
                }
                ft.show(fragment);
            } else {
                ft.hide(fragment);
            }

            ft.commit();
            currentTab = idx; // 更新目标tab为当前tab
        }
    }

    /**
     * 获取当前Fragment
     *
     * @return
     */
    public Fragment getCurrentFragment() {
        return fragments.get(currentTab);
    }

}
