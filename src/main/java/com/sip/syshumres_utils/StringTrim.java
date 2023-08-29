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
			//.replaceAll("[^\\p{ASCII}]", "")
			//.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
			String newStr = Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			return newStr.strip();
		}
		return str;
	}

}
