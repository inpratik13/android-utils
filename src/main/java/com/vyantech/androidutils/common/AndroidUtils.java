package com.vyantech.androidutils.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.Locale;

public class AndroidUtils {
	
	public static int dpToPx(Context context, int dp) {

		DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
		int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
		return px;

	}

	public static int getColor(Context context, int colorResource){
        return ContextCompat.getColor(context, colorResource);
    }

	public static String getAppVersion(Context context){
		try{
			PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			return packageInfo.versionName;
		} catch (Exception ex){
			return null;
		}
	}

	public static Integer getAppVersionCode(Context context){
		try{
			PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			return packageInfo.versionCode;
		} catch (Exception ex){
			return null;
		}
	}
	
	public static boolean isNetworkAvailable(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}

	public static void setDividerColor(Context context, AlertDialog dialog, int colorResource) {
		int titleDividerId = ContextUtils.getIdentifier(context, "titleDivider", "android");
		View titleDivider = dialog.findViewById(titleDividerId);
		if (titleDivider != null)
			titleDivider.setBackgroundColor(colorResource);
	}

	public static void setDividerColor(Context context, Activity activity, int colorResource) {
		int titleDividerId = ContextUtils.getIdentifier(context, "titleDivider", "android");
		View titleDivider = activity.findViewById(titleDividerId);
		if (titleDivider != null)
			titleDivider.setBackgroundColor(colorResource);
	}

	/*private static final AtomicInteger sNextGeneratedId = new AtomicInteger(Constants.ONE);

	public static String encodeURI(String text) {
		try {
			return URLEncoder.encode(text, "utf-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}*/

	public static void runOnMainThread(Runnable runnable, Context context) {
		new Handler(context.getMainLooper()).post(runnable);
	}

	public static void hideKeyBoard(EditText et){
        InputMethodManager m  = (InputMethodManager)et.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        m.hideSoftInputFromWindow(et.getWindowToken(), 0);
    }

	/*public static void toggleVisibility(View v) {
		if (v.getVisibility() == View.VISIBLE) {
			v.setVisibility(View.GONE);
		} else {
			v.setVisibility(View.VISIBLE);
		}
	}

	public static int generateViewId() {
		for (;;) {
			final int result = sNextGeneratedId.get();

			int newValue = result + 1;
			if (newValue > 0x00FFFFFF)
				newValue = 1;

			if (sNextGeneratedId.compareAndSet(result, newValue)) {
				return result;
			}
		}
	}

	public static Bitmap getBitmapFromUrl(String urlString) {
		try {
			URL url = new URL(urlString);
			return BitmapFactory.decodeStream(url.openConnection().getInputStream());
		} catch (Exception e) {
			return null;
		}

	}

	public static void fullScroll(final ScrollView scroll, final int direction) {
		scroll.post(new Runnable() {
			@Override
			public void run() {
				scroll.fullScroll(direction);
			}
		});
	}*/

	/*	public static String getString(String key, Context context) {
		Resources r = context.getResources();
		return r.getString(r.getIdentifier(key, "string", context.getPackageName()));
	}

	public static String getDeviceName() {
		String manufacturer = Build.MANUFACTURER;
		String model = Build.MODEL;
		if (model.startsWith(manufacturer)) {
			return capitalize(model);
		}
		return capitalize(manufacturer) + " " + model;
	}

	private static String capitalize(String str) {
		if (TextUtils.isEmpty(str)) {
			return str;
		}
		char[] arr = str.toCharArray();
		boolean capitalizeNext = true;

		StringBuilder phrase = new StringBuilder();
		for (char c : arr) {
			if (capitalizeNext && Character.isLetter(c)) {
				phrase.append(Character.toUpperCase(c));
				capitalizeNext = false;
				continue;
			} else if (Character.isWhitespace(c)) {
				capitalizeNext = true;
			}
			phrase.append(c);
		}

		return phrase.toString();
	}*/

	public static void hideKeyboard(Activity context) {
		View view = (context).getCurrentFocus();
		if (view != null) {
			InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
		}
	}

    /**
     * Requires android:configChanges="locale" in androidManifest.xml file.<br/>
     * Also restart activity to apply locale changes.
     *
     * @param context
     * @param locale
     */
	public static void changeAppLocale(Context context, Locale locale){
        Resources res = context.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, dm);
    }
}
