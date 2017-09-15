package com.yis.video.ui.adapter.index;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.yis.video.ui.adapter.viewholder.MainViewHolder;

/**
 * Created by sunny on 2017/8/23.
 */

public class IndexContentVideoRecycleAdapter extends RecyclerArrayAdapter<String> {

    public IndexContentVideoRecycleAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(parent);
    }
}
