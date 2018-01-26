package com.vyantech.androidutils.common;

import java.io.File;

import android.content.Context;

public class FileUtils {

	/**
	 * Overwrites existing file.
	 * 
	 * @return
	 */
	public static File createNewExternalCacheFile(Context context, String name) {
		File file = new File(context.getExternalCacheDir(), name);
		delete(file);

		return file;
	}

	public static void delete(File file) {
		if (file == null) return;

		if (file.exists()) {
			file.delete();
		}
	}
}
