package com.yis.video.ui.fragment.index;

import com.yis.video.R;
import com.yis.video.base.BaseFragment;
import com.yis.video.ui.presenter.index.IndexContentPresenter;
import com.yis.video.ui.view.index.IndexContentView;

import butterknife.BindView;

/**
 * 首页内容区
 * Created by Yis on 2017/8/29.
 */
public class IndexContentFragment extends BaseFragment {

    @BindView(R.id.index_content_view)
    IndexContentView indexContentView;


    @Override
    protected int getLayout() {
        return R.layout.fragment_index_content;
    }

    @Override
    protected void initView() {
        mPresenter = new IndexContentPresenter(indexContentView);
        ((IndexContentPresenter) mPresenter).getData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            if (indexContentView != null) {
                indexContentView.stopBanner(false);
            }
        } else {
            if (indexContentView != null) {
                indexContentView.stopBanner(true);
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        indexContentView.stopBanner(false);
    }

    @Override
    public void onPause() {
        super.onPause();
        indexContentView.stopBanner(true);
    }

}
