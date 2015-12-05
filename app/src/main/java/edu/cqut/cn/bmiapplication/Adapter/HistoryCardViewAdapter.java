package edu.cqut.cn.bmiapplication.Adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.cqut.cn.bmiapplication.Bean.BMIBean;
import edu.cqut.cn.bmiapplication.ENUMS.NationalHealthy;
import edu.cqut.cn.bmiapplication.R;

/**
 * Created by dun on 2015/12/5.
 */
public class HistoryCardViewAdapter extends RecyclerView.Adapter<HistoryCardViewAdapter.MyViewHolder>{
    private Context mContext;
    private List<BMIBean> list;

    public HistoryCardViewAdapter(Context mContext, ArrayList<BMIBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_in_histroyrecycleview,parent,false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        BMIBean b = list.get(position);
        holder.index.setText(b.getIndex());
        holder.BMINum.setText(b.getBMIString());
        holder.date.setText(b.getDate());

        GradientDrawable g = (GradientDrawable)holder.index.getBackground();
        if(b.getIndex().equals(NationalHealthy.正常)){
            g.setColor(mContext.getResources().getColor(R.color.normal));
        }else{
            g.setColor(mContext.getResources().getColor(R.color.fat));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView date;
        public TextView BMINum;
        public TextView index;

        public MyViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.date);
            BMINum = (TextView) itemView.findViewById(R.id.BMINumber);
            index = (TextView) itemView.findViewById(R.id.tv_index);
        }
    }
}
