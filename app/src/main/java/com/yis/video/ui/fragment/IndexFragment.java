package com.yis.video.ui.fragment;

import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;

import com.yis.video.R;
import com.yis.video.base.BaseFragment;
import com.yis.video.ui.presenter.index.IndexPersenter;
import com.yis.video.ui.view.index.IndexView;

import butterknife.BindView;

/**
 * Created by Yis on 2017/8/28.
 */

public class IndexFragment extends BaseFragment {

    @BindView(R.id.index_view)
    IndexView indexView;

    @Override
    protected int getLayout() {
        return R.layout.fragment_index;
    }

    @Override
    protected void initView() {
        mPresenter = new IndexPersenter(indexView);
    }

    @Override
    protected void lazyFetchData() {
        ((IndexPersenter) mPresenter).getData();
    }


}
