package com.sip.syshumres_utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.Normalizer;

/**
 * Trim string
 * 
 * @author Prong
 * @version 2.0
 */
public final class StringTrim {
	
	private StringTrim() {
	}
	
	public static String trimAndRemoveDiacriticalMarks(String str) {
		if (str != null) {
	        // Eliminar marcas diacríticas, excepto acentos y "ñ"
			String newStr = Normalizer.normalize(str, Normalizer.Form.NFD)
					.replaceAll("[\\p{InCombiningDiacriticalMarks}&&[^\\u0301\\u0303]]", "");
			return newStr.strip();
		}
		return str;
	}
	
	public static String trimAndRemoveDiacriticalMarksPassword(String str) {
		if (str != null) {
	        // Eliminar marcas diacríticas
			String newStr = Normalizer.normalize(str, Normalizer.Form.NFD)
					.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
			return newStr.strip();
		}
		return str;
	}
	
	public static String urlDecodingAndTrim(String str) {
		if (str != null) {
			try {
				String strDecode = URLDecoder.decode(str, "UTF-8");
				//System.out.println("Text Decode: " + strDecode.strip());
				return strDecode.strip();
			} catch (UnsupportedEncodingException e) {
				return str.strip();
			}
		}
		return str;
	}

}
