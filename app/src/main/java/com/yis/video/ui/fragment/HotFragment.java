package com.yis.video.ui.fragment;

import android.widget.TextView;

import com.yis.video.R;
import com.yis.video.base.BaseFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;

/**
 * Created by sunny on 2017/8/28.
 */

public class HotFragment extends BaseFragment {

    @BindView(R.id.tv_hot)
    TextView tvHot;

    @Override
    protected int getLayout() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void lazyFetchData() {
        //测试懒加载
        tvHot.setText("热点& 当前时间是："+transferLongToDate("MM/dd/yyyy HH:mm:ss", System.currentTimeMillis()));
    }


    public String transferLongToDate(String dateFormat, Long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(millSec);
        return sdf.format(date);
    }
}
