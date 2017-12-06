package mvpframework.bwie.com.mvprecycler.model;

import mvpframework.bwie.com.mvprecycler.Bean.NbaBean;
import mvpframework.bwie.com.mvprecycler.net.NetWorkListener;

/**
 * Created by 杨杰 on 2017/12/6.
 */

public interface IMainModel {
    public void gwtbean(NetWorkListener<NbaBean> netWorkListener);

}
