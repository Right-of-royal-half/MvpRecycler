package mvpframework.bwie.com.mvprecycler.presenter;

import mvpframework.bwie.com.mvprecycler.Bean.NbaBean;
import mvpframework.bwie.com.mvprecycler.model.IMainModel;
import mvpframework.bwie.com.mvprecycler.model.MainModel;
import mvpframework.bwie.com.mvprecycler.net.NetWorkListener;
import mvpframework.bwie.com.mvprecycler.view.IMainActivity;

/**
 * Created by 杨杰 on 2017/12/6.
 */

public class MainPresenter {
    final IMainActivity iMainActivity;
    IMainModel iMainModel;
    public MainPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        iMainModel=new MainModel();
    }
    public void doGet(){
        iMainModel.gwtbean(new NetWorkListener<NbaBean>() {
            @Override
            public void onSuccess(NbaBean bean) {
               /* Log.d("AAAAAAAAAA",bean.getNewslist().get(0).getTitle());*/
                iMainActivity.show(bean);
            }

            @Override
            public void onFailed(Exception e) {

            }
        });
    }
}
