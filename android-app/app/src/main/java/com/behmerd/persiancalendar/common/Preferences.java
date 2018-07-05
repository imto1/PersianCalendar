package com.behmerd.persiancalendar.common;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    private final String KEY = "PCPrefs";
    private final String TimeSheetKey = "spTimeSheet";
    private android.content.SharedPreferences preferences;
    private Context context;
    //Periodical work time preferences definitions

    public Preferences(Context context){
        this.context = context;
    }

    //Periodical work time preferences
    public boolean setPWT(boolean status, String work, String rest, String start){
        preferences = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(TimeSheetKey, String.valueOf(status) + "~" + work + "~" + rest + "~" + start);
        return editor.commit();
    }
    public String getPWT(){
        preferences = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        return preferences.getString(TimeSheetKey, null);
    }

    public boolean clearPrefs(){
        preferences = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        return editor.commit();
    }
}
