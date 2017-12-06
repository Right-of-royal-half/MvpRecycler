package mvpframework.bwie.com.mvprecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mvpframework.bwie.com.mvprecycler.Bean.NbaBean;
import mvpframework.bwie.com.mvprecycler.adpter.MyAdpter;
import mvpframework.bwie.com.mvprecycler.presenter.MainPresenter;
import mvpframework.bwie.com.mvprecycler.view.IMainActivity;

public class MainActivity extends AppCompatActivity implements IMainActivity{
 @BindView(R.id.xlv)
    XRecyclerView xlv;
    private MainPresenter presenter;
    private List<NbaBean.NewslistBean> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
        presenter.doGet();
       /* Log.d("aaaaaaaaaaaaaaaa",presenter.toString());*/
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xlv.setLayoutManager(linearLayoutManager);
        xlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                presenter.doGet();
                xlv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                presenter.doGet();
                xlv.refreshComplete();
            }
        });
    }

    @Override
    public void show(NbaBean bean) {
        list = bean.getNewslist();
        MyAdpter adpter = new MyAdpter(list, MainActivity.this);
        xlv.setAdapter(adpter);
        Log.d("aaaaaaaaaaa", list.get(0).getCtime());
    }
}
