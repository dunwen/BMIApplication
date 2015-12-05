package edu.cqut.cn.bmiapplication.sql;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

import edu.cqut.cn.bmiapplication.Bean.BMIBean;

/**
 * Created by dun on 2015/12/5.
 */
public class SqlBeanHelper {

    private static final String TAG = "SqlBeanHelper";

    private Context mContext;
    private SqlHelper helper;

    public SqlBeanHelper (Context mContext){
        this.mContext = mContext;
        helper = new SqlHelper(mContext);
    }

    public boolean InsertBean(BMIBean b){
        try{
            StringBuffer sb = new StringBuffer();
            sb.append("INSERT INTO ");
            sb.append(SqlHelper.tableName);
            sb.append(" values(NULL,");
            sb.append(b.getBMINum()+",");
            sb.append("'"+b.getBMIString()+"',");
            sb.append("'"+b.getIndex()+"',");
            sb.append("'"+b.getDate()+"'");
            sb.append(")");
            Log.i(TAG, "InsertBean: >>"+sb.toString());
            helper.getWritableDatabase().execSQL(sb.toString());
            }catch (Exception e){
                return false;
            }
        return true;
    }

    public ArrayList<BMIBean> getAllBMIBean(){
        ArrayList<BMIBean> list = new ArrayList<>();
        String sql = "SELECT * FROM BMITable ORDER BY _id DESC";

       Cursor c = helper.getReadableDatabase().rawQuery(sql,null);

        while (c.moveToNext()){
            BMIBean b = new BMIBean();
            int id = c.getInt(c.getColumnIndex("_id"));
            String BMIString = c.getString(c.getColumnIndex("BMIString"));
            String BMIIndex = c.getString(c.getColumnIndex("BMIIndex"));
            String Date = c.getString(c.getColumnIndex("date"));
            double BMINmu =c.getDouble(c.getColumnIndex("BMINumber"));
            b.setDate(Date);
            b.setIndex(BMIIndex);
            b.setBMIString(BMIString);
            b.set_id(id);
            b.setBMINum(BMINmu);
            list.add(b);
        }
        c.close();
        return list;
    }

    /**
     * 这个样子会内存溢出吗？
     * */
    public void closeDB(){
        helper.close();
        mContext = null;
    }

}
