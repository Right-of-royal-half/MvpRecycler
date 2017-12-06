package mvpframework.bwie.com.mvprecycler.url;

import mvpframework.bwie.com.mvprecycler.Bean.NbaBean;
import mvpframework.bwie.com.mvprecycler.net.Api;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by 杨杰 on 2017/12/6.
 */

public interface ServiceApi {
    @GET(Api.URL)
    Observable<NbaBean> bean();
}
