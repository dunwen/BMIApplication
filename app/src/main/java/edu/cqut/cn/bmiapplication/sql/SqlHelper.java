package edu.cqut.cn.bmiapplication.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by dun on 2015/12/5.
 */
public class SqlHelper extends SQLiteOpenHelper{

    public static final String TAG = "SqlHelper";

    public static final String dataBaseName = "BMIDataBase";
    public static final String tableName = "BMITable";

    public SqlHelper(Context context) {
        super(context, dataBaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table "+tableName+"(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "BMINumber DOUBLE," +
                "BMIString VARCHAR(20)," +
                "BMIIndex VARCHAR(20)," +
                "date VARCHAR(20))";
        Log.i(TAG, "onCreate: >>"+sql);

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
