package com.yis.video.ui.view.index;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;

import com.yis.video.R;
import com.yis.video.base.RootView;
import com.yis.video.ui.activity.MainActivity;
import com.yis.video.ui.adapter.index.IndexContentPagerAdapter;
import com.yis.video.ui.fragment.index.IndexContentFragment;
import com.yis.video.ui.presenter.contract.index.IndexContract;
import com.yis.video.utils.Preconditions;

import org.simple.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Yis on 2017/8/28.
 */

public class IndexView extends RootView<IndexContract.Persenter> implements IndexContract.View, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    IndexContentPagerAdapter contentPagerAdapter;


//    RollPagerView rollPagerView;
//    View headerView;
//    MainRecycleAdapter adapter;


    public IndexView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.fragment_index_view, this);
    }

    @Override
    protected void initView() {
        final List<String> tab = new ArrayList<>();
        tab.add("精选");
        tab.add("权利游戏");
        tab.add("电视剧");
        tab.add("电影");
        tab.add("综艺");
        tab.add("动漫");
        tab.add("明日之子");

        List<Fragment> fragments = new ArrayList<>();
        int size = tab.size();

        for (int i = 0; i < size; i++) {
            fragments.add(new IndexContentFragment());
        }

        contentPagerAdapter = new IndexContentPagerAdapter(((MainActivity)mContext).getSupportFragmentManager(), fragments, tab);
        viewPager.setAdapter(contentPagerAdapter);
        viewPager.setOffscreenPageLimit(fragments.size());

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(), false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(contentPagerAdapter);



//        headerView = LayoutInflater.from(mContext).inflate(R.layout.recommend_header, null);
//        rollPagerView = ButterKnife.findById(headerView, R.id.roll_pager_view);
//        rollPagerView.setPlayDelay(2000);
//
//        recyclerView.setAdapterWithProgress(adapter = new MainRecycleAdapter(getContext()));
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
//        recyclerView.setErrorView(R.layout.view_error);
//
//        //item间隔
//        SpaceDecoration itemDecoration = new SpaceDecoration(ScreenUtil.dip2px(getContext(), 8));
//        itemDecoration.setPaddingEdgeSide(true);
//        itemDecoration.setPaddingStart(true);
//        itemDecoration.setPaddingHeaderFooter(false);
//        recyclerView.addItemDecoration(itemDecoration);
//
////        SpaceDecoration itemDecoration = new SpaceDecoration(ScreenUtil.dip2px(getContext(), 8));//参数是距离宽度
////        itemDecoration.setPaddingEdgeSide(true);//是否为左右2边添加padding.默认true.
////        itemDecoration.setPaddingStart(true);//是否在给第一行的item添加上padding(不包含header).默认true.
////        itemDecoration.setPaddingHeaderFooter(false);//是否对Header于Footer有效,默认false.
////        recyclerView.addItemDecoration(itemDecoration);
//
//        recyclerView.setRefreshListener(this);
    }

    @Override
    protected void initEvent() {
    }

    @Override
    public void setPresenter(IndexContract.Persenter presenter) {
        mPresenter = Preconditions.checkNotNull(presenter);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public boolean isDesActivity() {
        return mActive;
    }

    @Override
    public void showContent(final List<String> img, List<String> img2) {

//        if (img != null) {
//            adapter.clear();
//            adapter.addAll(img2);
//            if (adapter.getHeaderCount() == 0) {
//                adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
//                    @Override
//                    public View onCreateView(ViewGroup parent) {
//                        rollPagerView.setHintView(new IconHintView(getContext(), R.mipmap.ic_page_indicator_focused, R.mipmap.ic_page_indicator, ScreenUtil.dip2px(getContext(), 10)));
//                        rollPagerView.setHintPadding(0, 0, 0, ScreenUtil.dip2px(getContext(), 8));
//                        rollPagerView.setAdapter(new IndexContentPlayPagerAdapter(getContext(), img));
//                        return headerView;
//                    }
//
//                    @Override
//                    public void onBindView(View headerView) {
//
//                    }
//                });
//            }
//        }
    }

//    @Subscriber(tag = MainActivity.Banner_Stop)
//    public void stopBanner(boolean stop) {
//        if (stop) {
//            rollPagerView.pause();
//        } else {
//            rollPagerView.resume();
//        }
//    }

    @Override
    public void onRefresh() {
        mPresenter.getData();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        EventBus.getDefault().unregister(this);
        super.onDetachedFromWindow();
    }
}
