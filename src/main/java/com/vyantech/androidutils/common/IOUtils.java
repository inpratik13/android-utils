package com.vyantech.androidutils.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
	public static void close(InputStream is) {
		if (is == null) return;

		try {
			is.close();
		} catch (IOException e) {
			// Nothing
		}
	}

	public static void close(OutputStream os) {
		if (os == null) return;

		try {
			os.close();
		} catch (IOException e) {
			// Nothing
		}
	}
}
