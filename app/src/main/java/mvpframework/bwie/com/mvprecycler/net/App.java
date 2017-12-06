package mvpframework.bwie.com.mvprecycler.net;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.BuildConfig;
import butterknife.ButterKnife;

/**
 * Created by 杨杰 on 2017/12/6.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        ButterKnife.setDebug(BuildConfig.DEBUG);
    }
}
