package mvpframework.bwie.com.mvprecycler.model;

import android.util.Log;

import mvpframework.bwie.com.mvprecycler.Bean.NbaBean;
import mvpframework.bwie.com.mvprecycler.net.NetWorkListener;
import mvpframework.bwie.com.mvprecycler.url.Retrofithelper;
import mvpframework.bwie.com.mvprecycler.url.ServiceApi;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 杨杰 on 2017/12/6.
 */

public class MainModel implements IMainModel{
    @Override
    public void gwtbean(final NetWorkListener<NbaBean> netWorkListener) {
        ServiceApi serviceApi = Retrofithelper.getServiceApi();
        serviceApi.bean()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<NbaBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NbaBean nbaBean) {
                           netWorkListener.onSuccess(nbaBean);
                    }
                });
    }
}
