package edu.cqut.cn.bmiapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.cqut.cn.bmiapplication.Bean.BMIBean;
import edu.cqut.cn.bmiapplication.Impls.BMICounter;
import edu.cqut.cn.bmiapplication.Units.AndroidUnis;
import edu.cqut.cn.bmiapplication.Units.BMIUnits;
import edu.cqut.cn.bmiapplication.Units.DateUnits;
import edu.cqut.cn.bmiapplication.sql.SqlBeanHelper;

/**
 * Created by dun on 2015/12/4.
 */
public class CountBMIFragment extends android.app.Fragment{

    private EditText et_height = null;
    private EditText et_weight = null;
    private Button btn_count = null;
    private BMIUnits mBMIUnits = new BMIUnits();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.count_bmi_fragment,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        et_height = (EditText) view.findViewById(R.id.et_height);
        et_weight = (EditText) view.findViewById(R.id.et_weight);
        btn_count = (Button) view.findViewById(R.id.btn_count);

        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkIsLegal()){
                    double result;
                    result = mBMIUnits.CountBMI(getWeight(),getHeight());
                    String Stringresult = String.format("%2.2f",result);

                    BMIBean b = new BMIBean();
                    b.setBMIString(Stringresult);
                    b.setIndex(mBMIUnits.CountBMIIndex(result));
                    b.setDate(DateUnits.getCurrentDate());
                    save(b);
                    AndroidUnis.showCommomDialog(getActivity(),"BMI结果","你的BMI为:"+Stringresult+"" +
                            "\n该BMI的值属于"+mBMIUnits.CountBMIIndex(result)+"范围");
                }else{
                    Toast.makeText(getActivity(),"输入有误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void save(BMIBean b) {
        SqlBeanHelper helper = new SqlBeanHelper(getActivity());
        helper.InsertBean(b);
        helper.closeDB();
    }

    /**
     * @return 体重 int
     * */
    private int getWeight(){
        String s = et_weight.getText().toString();
        if(!s.equals("")){
            try {
                return Integer.parseInt(s);
            }catch (Exception e){
                return 0;
            }
        }
        return 0;
    }

    /**
     * @return 身高 float
     * */
    private float getHeight(){
        String s = et_height.getText().toString();
        if(!s.equals("")){
            try {
                return Float.parseFloat(s);
            }catch (Exception e){
                return 0;
            }
        }
        return 0;
    }




    /**
     * @return true 如果输入合法 false 如果输入不合法
     * */
    private boolean checkIsLegal() {
        try{
            String s0 = et_height.getText().toString();
            String s1 = et_weight.getText().toString();

            if(s0.equals("")||s1.equals("")){
                return false;
            }
            Float.parseFloat(s0);
            Integer.parseInt(s1);
        }catch (Exception e){
            return false;
        }
        return true;
    }







}
