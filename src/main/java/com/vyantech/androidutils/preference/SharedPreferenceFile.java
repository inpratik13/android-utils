package com.vyantech.androidutils.preference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * Created by patrix on 20/10/17.
 */

public abstract class SharedPreferenceFile {
    private final String name;
    private SharedPreferences pref;

    public SharedPreferenceFile(Context context, String name) {
        this(context, name, Activity.MODE_PRIVATE);
    }

    public SharedPreferenceFile(Context context, String name, int mode) {
        this.name = name;

        pref = context.getSharedPreferences(name, mode);
        _loadPreferences(pref);
    }

    private void _loadPreferences(SharedPreferences pref) {
        load(pref.getAll());
    }

    protected void remove(String key){
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(key);
        editor.commit();
    }

    protected void save(Map<String, ?> prefData) {
        SharedPreferences.Editor editor = pref.edit();

        for(Map.Entry<String, ?> e : prefData.entrySet()){
            _put(editor, e.getKey(), e.getValue());
        }

        editor.commit();
    }

    private static void _put(SharedPreferences.Editor editor, String key, Object obj){
        if(obj == null){
            editor.remove(key);
            return;
        }

        if(obj instanceof Boolean){
            editor.putBoolean(key, (Boolean) obj);
        } else if(obj instanceof Float){
            editor.putFloat(key, (Float) obj);
        } else if(obj instanceof Integer){
            editor.putInt(key, (Integer) obj);
        } else if(obj instanceof Long){
            editor.putLong(key, (Long) obj);
        } else if(obj instanceof String){
            editor.putString(key, (String) obj);
        } else {
            throw new IllegalArgumentException("Unsupported data to store in preferences");
        }
    }

    protected abstract void load(Map<String, ?> prefData);

}
