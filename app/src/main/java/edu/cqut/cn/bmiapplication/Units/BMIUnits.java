package edu.cqut.cn.bmiapplication.Units;

import edu.cqut.cn.bmiapplication.ENUMS.NationalHealthy;
import edu.cqut.cn.bmiapplication.Impls.BMICounter;
import edu.cqut.cn.bmiapplication.Impls.BMIIndex;

/**
 * Created by dun on 2015/12/4.
 */
public class BMIUnits implements BMIIndex,BMICounter{

    BMIIndex mBMIIndex = this;
    BMICounter mBMICounter = this;
    public void setmBMIIndex(BMIIndex mBMIIndex) {
        this.mBMIIndex = mBMIIndex;
    }

    public BMIIndex getmBMIIndex() {
        return mBMIIndex;
    }

    public BMICounter getmBMICounter() {
        return mBMICounter;
    }

    public void setmBMICounter(BMICounter mBMICounter) {
        this.mBMICounter = mBMICounter;
    }

    @Override
    public String CountBMIIndex(double BMI) {
        if(BMI<18.5){
            return NationalHealthy.偏瘦;
        }else if(BMI<=24.9&&BMI>18.5){
            return NationalHealthy.正常;
        }else{
            return NationalHealthy.肥胖;
        }
    }

    /**
     *               @param height 身高
     *               @param weight 体重
     *               @return BMI = 体重/身高^2
     * */
    @Override
    public double CountBMI(int weight, float height) {
        double result = (double)(weight/(height*height));
        return result;
    }
}
