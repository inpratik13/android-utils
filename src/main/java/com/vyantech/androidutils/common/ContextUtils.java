package com.vyantech.androidutils.common;

import android.content.Context;
import android.view.LayoutInflater;

public class ContextUtils {

	public static LayoutInflater getInflater(Context context){
		return (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	/*public static Drawable getDrawable(Context context, int resourceDrawableId){
		return context.getResources().getDrawable(resourceDrawableId);
	}*/
	
	public static int getColor(Context context, int colorId){
		return context.getResources().getColor(colorId);
	}
	
	public static int getIdentifier(Context context, String name, String nameSpace){
		return context.getResources().getIdentifier(name, "id", nameSpace);
	}
	
	/**
	 * Finds only in current project's package.
	 * 
	 * @param context
	 * @param name
	 * @return
	 */
	public static int getStringIdentifier(Context context, String name){
		return context.getResources().getIdentifier(name, "string", context.getPackageName());
	}
	
	/**
	 * Finds only in current project's package.
	 * 
	 * @param context
	 * @param name
	 * @return
	 */
	public static int getArrayIdentifier(Context context, String name){
		return context.getResources().getIdentifier(name, "array", context.getPackageName());
	}
}
