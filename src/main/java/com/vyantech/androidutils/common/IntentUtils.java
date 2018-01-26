package com.vyantech.androidutils.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class IntentUtils {

	public static void viewCurrentAppOnAppStore(Context context) {
		viewAppOnAppStore(context, context.getPackageName());
	}

	public static void viewAppOnAppStore(Context context, String packageName) {

		Uri uri = Uri.parse("market://details?id=" + packageName);
		Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
		context.startActivity(myAppLinkToMarket);
	}

}
