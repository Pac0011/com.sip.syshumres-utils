package com.sip.syshumres_utils;

import java.text.Normalizer;

/**
 * Trim string
 * 
 * @author Prong
 * @version 2.0
 */
public class StringTrim {
	
	public static String trimAndRemoveDiacriticalMarks(String str) {
	    //"ÀÂÃÄÅÆÇÈÊËÌÎÏÐÑÒÔÕÖØÙÛÜÝßàâãäåæçèêëìîïðñòôõöøùûüýÿ";
		if (str != null) {
	        // Eliminar marcas diacríticas, excepto acentos y "ñ"
			String newStr = Normalizer.normalize(str, Normalizer.Form.NFD)
					.replaceAll("[^\\\\p{InCombiningDiacriticalMarks}&&[^\\\\u0301\\\\u0300]]", "");
			return newStr.strip();
		}
		return str;
	}

}
