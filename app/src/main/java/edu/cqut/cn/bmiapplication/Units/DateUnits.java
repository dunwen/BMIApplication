package edu.cqut.cn.bmiapplication.Units;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by dun on 2015/12/4.
 */
public class DateUnits {
    public static String getCurrentDate(){
        Date d = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance();
        return df.format(d);
    }

}
