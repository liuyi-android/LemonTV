package com.yis.video.ui.view.index;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.hintview.IconHintView;
import com.yis.video.R;
import com.yis.video.base.RootView;
import com.yis.video.constant.EventBusConstant;
import com.yis.video.ui.adapter.index.IndexContentPlayPagerAdapter;
import com.yis.video.ui.adapter.index.IndexContentVideoRecycleAdapter;
import com.yis.video.ui.presenter.contract.index.IndexContentContract;
import com.yis.video.utils.EventUtil;
import com.yis.video.utils.Preconditions;
import com.yis.video.utils.ScreenUtil;
import com.yis.video.widget.RollPagerView;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yis on 2017/8/31.
 */

public class IndexContentView extends RootView<IndexContentContract.Presenter> implements IndexContentContract.View, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recycler_view)
    EasyRecyclerView recyclerView;

    private RollPagerView rollPagerView;
    private View headView;

    private IndexContentVideoRecycleAdapter videoRecycleAdapter;

    public IndexContentView(Context context) {
        super(context);
    }

    public IndexContentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.fragment_index_content_view, this);
    }

    @Override
    protected void initView() {
        headView = inflate(mContext, R.layout.view_index_play_header, null);
        rollPagerView = ButterKnife.findById(headView, R.id.roll_pager_view);

        recyclerView.setAdapterWithProgress(videoRecycleAdapter = new IndexContentVideoRecycleAdapter(getContext()));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setErrorView(R.layout.view_error);

        //item间隔
        SpaceDecoration itemDecoration = new SpaceDecoration(ScreenUtil.dip2px(getContext(), 4));
        itemDecoration.setPaddingEdgeSide(true);
        itemDecoration.setPaddingStart(true);
        itemDecoration.setPaddingHeaderFooter(false);
        recyclerView.addItemDecoration(itemDecoration);

//        SpaceDecoration itemDecoration = new SpaceDecoration(ScreenUtil.dip2px(getContext(), 8));//参数是距离宽度
//        itemDecoration.setPaddingEdgeSide(true);//是否为左右2边添加padding.默认true.
//        itemDecoration.setPaddingStart(true);//是否在给第一行的item添加上padding(不包含header).默认true.
//        itemDecoration.setPaddingHeaderFooter(false);//是否对Header于Footer有效,默认false.

        recyclerView.addItemDecoration(itemDecoration);


    }

    @Override
    protected void initEvent() {
        recyclerView.setRefreshListener(this);
    }

    @Override
    public void setPresenter(IndexContentContract.Presenter presenter) {
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
    public void showData(final List<String> playImgs, final List<String> videoImgs) {

        videoRecycleAdapter.clear();
        videoRecycleAdapter.addAll(videoImgs);
        if (videoRecycleAdapter.getHeaderCount() == 0) {
            videoRecycleAdapter.addHeader(new RecyclerArrayAdapter.ItemView() {
                @Override
                public View onCreateView(ViewGroup parent) {
                    rollPagerView.setPlayDelay(2000);
                    rollPagerView.setHintView(new IconHintView(getContext(), R.mipmap.ic_page_indicator_focused, R.mipmap.ic_page_indicator, ScreenUtil.dip2px(getContext(), 10)));
                    rollPagerView.setHintPadding(0, 0, 0, ScreenUtil.dip2px(getContext(), 8));
                    rollPagerView.setAdapter(new IndexContentPlayPagerAdapter(getContext(), playImgs));

                    return headView;
                }

                @Override
                public void onBindView(View headerView) {

                }
            });
        }
    }

    @Subscriber(tag = EventBusConstant.STOP_BANNER)
    public void stopBanner(boolean stop) {
        if (stop) {
            rollPagerView.pause();
        } else {
            rollPagerView.resume();
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onRefresh() {
        mPresenter.getData();
    }
}
