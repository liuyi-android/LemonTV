package com.yis.video.ui.presenter.index;

import android.support.annotation.NonNull;

import com.yis.video.base.RxPresenter;
import com.yis.video.ui.presenter.contract.index.IndexContentContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yis on 2017/8/31.
 */

public class IndexContentPresenter extends RxPresenter implements IndexContentContract.Presenter {

    private IndexContentContract.View mView;

    public IndexContentPresenter(@NonNull IndexContentContract.View mView) {
        this.mView = mView;
        mView.setPresenter(this);
        this.mView = mView;
        getData();
    }

    @Override
    public void getData() {

        List<String> playImgs = new ArrayList<>();
        playImgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504184658261&di=6d5e58b99998a6dbf0174ba34a11b672&imgtype=0&src=http%3A%2F%2Fwww.kfzimg.com%2FG01%2FM00%2FDB%2FD3%2Fo4YBAFQAHh2AZcR9AALfYOL0qdg874_b.jpg");
        playImgs.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1811895296,592744249&fm=11&gp=0.jpg");
        playImgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504779390&di=98d1e8327cc24a2ca366b8e630c327f1&imgtype=jpg&er=1&src=http%3A%2F%2Ffile02.16sucai.com%2Fd%2Ffile%2F2014%2F0526%2F4c902d99cd5edf6576d5f2f1f639aa4e.jpg");
        playImgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504184622802&di=a92ee3944c42c4c8c113e12fbf722cdf&imgtype=0&src=http%3A%2F%2Fimg14.3lian.com%2F201509%2F09%2Fd999e9547f0a3aded455e740d4cdda3d.jpg");
        playImgs.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2179715986,301401901&fm=26&gp=0.jpg");
        playImgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504184675384&di=04cf71b3dc1f1d5babe41a0f395fb305&imgtype=0&src=http%3A%2F%2Fpic68.nipic.com%2Ffile%2F20150601%2F13291986_151734185401_2.jpg");

        //省略网络请求获取内容...
        List<String> videoImgs = new ArrayList<>();
        videoImgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504515095575&di=235b7a7cb5886fe95b17c6315348e36e&imgtype=0&src=http%3A%2F%2Fimage12.m1905.cn%2Fmapps%2Fuploadfile%2Fedu%2F2015%2F0402%2Fthumb_0_400_800_2015040204150679559.jpg");
        videoImgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505109686&di=09f4b3057988d9e64ba305f147ab6a1b&imgtype=jpg&er=1&src=http%3A%2F%2Fningbo.sinaimg.cn%2F2013%2F0428%2FU9588P1480DT20130428182032.jpg");
        videoImgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505109702&di=43921104ea3b080cc336aef6c9fb646f&imgtype=jpg&er=1&src=http%3A%2F%2Fi1.3conline.com%2Fimages%2Fpiclib%2F201404%2F04%2Fbatch%2F1%2F221420%2F1396601426330m8t9fgn9pe_medium.jpg");
        videoImgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505109712&di=53f9afc1350133fda07fd0a797d23903&imgtype=jpg&er=1&src=http%3A%2F%2Fi2.3conline.com%2Fimages%2Fpiclib%2F201404%2F04%2Fbatch%2F1%2F221420%2F1396601426330avfnjs1eew_medium.jpg");
        videoImgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504515015518&di=fcc0b5983c5ccdd539270f1198bc950c&imgtype=0&src=http%3A%2F%2Fi2.3conline.com%2Fimages%2Fpiclib%2F201404%2F04%2Fbatch%2F1%2F221420%2F1396601426330x80kxg55hi_medium.jpg");
        videoImgs.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3264114231,1417726962&fm=27&gp=0.jpg");
        videoImgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505109755&di=98106e038c0f149118b2274d03333b9e&imgtype=jpg&er=1&src=http%3A%2F%2Fpic05.997788.com%2Fpic_search%2F00%2F14%2F96%2F98%2Fse14969852.jpg");
        videoImgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505109770&di=b80bbd9460c82e512bdee7f2241cd868&imgtype=jpg&er=1&src=http%3A%2F%2Fy3.ifengimg.com%2Fcmpp%2F2015%2F03%2F21%2F03%2F24bc7a9b-5d1a-489c-a34d-ae9719a7c402_size285_w400_h560.jpg");
        videoImgs.add("https://ss3.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D220/sign=cd0cd8c9104c510fb1c4e51850592528/9a504fc2d5628535af95d4209aef76c6a7ef63bd.jpg");
        videoImgs.add("https://ss1.baidu.com/-4o3dSag_xI4khGko9WTAnF6hhy/image/h%3D220/sign=cf30875e0323dd543e73a06ae109b3df/80cb39dbb6fd5266d435c72ea118972bd40736e9.jpg");
        videoImgs.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1728975595,999389818&fm=27&gp=0.jpg");
        videoImgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504514778637&di=40c5f32d2d2224cb5cd02909f601a2e2&imgtype=0&src=http%3A%2F%2Fimg1.cache.netease.com%2Fcatchpic%2F8%2F81%2F8170FE097FF75FC65BA4B1347D8662CA.jpg");
        videoImgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504514778637&di=9a23f75f12ff7d5e0e37f9411e6de049&imgtype=0&src=http%3A%2F%2Fcdn2.bjweekly.com%2Fuploads%2F2016-08-25%2F3398681436198232619.jpg");
        videoImgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504514838291&di=8bd0f18f60672b1ebb13abe4e4ba9a00&imgtype=jpg&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D169650987%2C2756355827%26fm%3D214%26gp%3D0.jpg");
        videoImgs.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=809079700,32485680&fm=27&gp=0.jpg");
        videoImgs.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1704622251,736423685&fm=27&gp=0.jpg");
        videoImgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504514890526&di=5a520d92a1a5792e5f0745833b964a30&imgtype=0&src=http%3A%2F%2Fi.shangc.net%2F2016%2F0117%2F20160117085945739.jpg");
        videoImgs.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1388481985,1680607566&fm=27&gp=0.jpg");
        videoImgs.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3341857023,1342909865&fm=27&gp=0.jpg");
        videoImgs.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1892384643,4124994092&fm=27&gp=0.jpg");
        videoImgs.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2427475390,3210586542&fm=27&gp=0.jpg");
        videoImgs.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=896937856,2414562917&fm=27&gp=0.jpg");
        videoImgs.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3846803825,281712244&fm=27&gp=0.jpg");
        mView.showData(playImgs, videoImgs);
    }
}
