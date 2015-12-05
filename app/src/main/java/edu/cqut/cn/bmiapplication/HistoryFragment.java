package edu.cqut.cn.bmiapplication;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.cqut.cn.bmiapplication.Adapter.HistoryCardViewAdapter;
import edu.cqut.cn.bmiapplication.Bean.BMIBean;
import edu.cqut.cn.bmiapplication.ENUMS.NationalHealthy;
import edu.cqut.cn.bmiapplication.sql.SqlBeanHelper;

/**
 * Created by dun on 2015/12/5.
 */
public class HistoryFragment extends Fragment{

    RecyclerView mRecyclerView;
    List<BMIBean> dataList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_fragment,container,false);
        init(view);
        return view;
    }

    private void init(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.History_rv);
        getdate();

    }

    private void setUpRV() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(llm);
        HistoryCardViewAdapter mAdapter = new HistoryCardViewAdapter(getActivity(), (ArrayList<BMIBean>) dataList);
        mRecyclerView.setAdapter(mAdapter);
    }



    /**
     * UI线程只处理UI操作，数据库操作应该放入子线程
     * */
    public void getdate() {

        class MyAsync extends AsyncTask<String,String,String>{

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                showProgressDialog();
            }

            @Override
            protected String doInBackground(String... params) {
                SqlBeanHelper helper = new SqlBeanHelper(getActivity());
                dataList = helper.getAllBMIBean();
                helper.closeDB();
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                dismissProgressDialog();
                setUpRV();
            }
        }
        new MyAsync().execute();
    }

    private boolean isProgressDialogShowing = false;
    ProgressDialog d;
    private void showProgressDialog(){
        if(!isProgressDialogShowing){
            d = new ProgressDialog(getActivity());
            d.setTitle("正在正在获取数据");
            d.setMessage("Loading");
            d.show();
            isProgressDialogShowing=true;
        }
    }

    private void dismissProgressDialog(){
        if(d!=null&&isProgressDialogShowing){
            d.dismiss();
        }
    }

}
