package edu.cqut.cn.bmiapplication.Units;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by dun on 2015/12/5.
 */
public class AndroidUnis {
    public static void showCommomDialog(Context mContext,String title,String msg){
        AlertDialog.Builder b = new AlertDialog.Builder(mContext)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        Dialog d = b.create();
        d.show();
    }

}
