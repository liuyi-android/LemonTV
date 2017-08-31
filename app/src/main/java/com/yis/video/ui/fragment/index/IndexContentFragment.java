package com.yis.video.ui.fragment.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yis.video.R;
import com.yis.video.base.BaseFragment;
import com.yis.video.utils.KL;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;

/**
 * 首页内容区
 * Created by Yis on 2017/8/29.
 */
public class IndexContentFragment extends BaseFragment {

    @BindView(R.id.tv_name)
    TextView tvName;

    @Override
    protected int getLayout() {
        return R.layout.fragment_index_content;
    }

    @Override
    protected void lazyFetchData() {
        tvName.setText("首页& 当前时间是：" + transferLongToDate("MM/dd/yyyy HH:mm:ss", System.currentTimeMillis()));
    }

    public String transferLongToDate(String dateFormat, Long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(millSec);
        return sdf.format(date);
    }
}
