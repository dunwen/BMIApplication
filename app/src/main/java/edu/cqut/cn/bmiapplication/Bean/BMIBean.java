package edu.cqut.cn.bmiapplication.Bean;

/**
 * Created by dun on 2015/12/5.
 */
public class BMIBean {
    private String Date = "";
    private String BMIString = "";
    private double BMINum = -1;
    private int _id = -1;
    private String index = "";

    public BMIBean() {}

    public String getDate() {
        return Date;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getBMIString() {
        return BMIString;
    }

    public void setBMIString(String BMIString) {
        this.BMIString = BMIString;
    }

    public double getBMINum() {
        return BMINum;
    }

    public void setBMINum(double BMINum) {
        this.BMINum = BMINum;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
