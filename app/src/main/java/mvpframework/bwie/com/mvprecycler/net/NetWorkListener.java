package mvpframework.bwie.com.mvprecycler.net;

/**
 * Created by 杨杰 on 2017/12/6.
 */

public interface NetWorkListener<T>{
    public void onSuccess(T t);
    public void onFailed(Exception e);
}
