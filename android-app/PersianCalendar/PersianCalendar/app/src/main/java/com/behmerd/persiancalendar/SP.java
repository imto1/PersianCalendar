package com.behmerd.persiancalendar;

import android.content.Context;
import android.content.SharedPreferences;

public class SP{
    private static final String myprefs = "PCPrefs";
    private static SharedPreferences sp;
    private static Context context;
    //Periodical work time preferences definitions
    private static final String timeSheetKey = "spTimeSheet";

    public SP(Context context){
        this.context = context;
    }

    //Periodical work time preferences
    public static boolean setPWT(boolean status, String work, String rest, String start){
        sp = context.getSharedPreferences(myprefs, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(timeSheetKey, String.valueOf(status) + "~" + work + "~" + rest + "~" + start);
        return editor.commit();
    }
    public static String getPWT(){
        sp = context.getSharedPreferences(myprefs, Context.MODE_PRIVATE);
        return sp.getString(timeSheetKey, null);
    }

    public static boolean clearPrefs(){
        sp = context.getSharedPreferences(myprefs, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        return editor.commit();
    }
}
