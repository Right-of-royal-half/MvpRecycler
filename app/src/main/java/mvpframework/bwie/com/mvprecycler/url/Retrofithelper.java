package mvpframework.bwie.com.mvprecycler.url;

import mvpframework.bwie.com.mvprecycler.net.Api;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 杨杰 on 2017/12/6.
 */

public class Retrofithelper {
    public static OkHttpClient okHttpClient;
    public static ServiceApi serviceApi;
    static {
        initOkhttp();
    }

    public static void initOkhttp() {
        if (okHttpClient==null){
            synchronized (Retrofithelper.class){
                if (okHttpClient==null){
                  okHttpClient = new OkHttpClient.Builder()
                            .build();
                }
            }
        }
    }
    public static ServiceApi getServiceApi(){
        if (serviceApi==null){
            synchronized (Retrofithelper.class){
                if (serviceApi==null){
                    serviceApi = onCreatApi(ServiceApi.class, Api.HOST);
                }
            }
        }
        return serviceApi;
    }
    public static <T> T onCreatApi(Class<T> tClass,String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(tClass);
    }
}
