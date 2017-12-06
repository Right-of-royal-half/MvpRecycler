package mvpframework.bwie.com.mvprecycler.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import mvpframework.bwie.com.mvprecycler.Bean.NbaBean;
import mvpframework.bwie.com.mvprecycler.R;


/**
 * Created by 杨杰 on 2017/12/6.
 */

public class MyAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<NbaBean.NewslistBean> list;
    private Context context;

    public MyAdpter(List<NbaBean.NewslistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        final NbaBean.NewslistBean bean = list.get(position);
        myViewHolder.sdv.setImageURI(bean.getPicUrl());
        myViewHolder.tv.setText(bean.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.sdv)
        SimpleDraweeView sdv;
        @BindView(R.id.tv)
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
