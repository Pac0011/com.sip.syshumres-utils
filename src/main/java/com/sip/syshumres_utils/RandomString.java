package com.sip.syshumres_utils;

import java.util.Random;

/**
 * Implementacion de hash
 * 
 * @author Prong
 * @version 2.0
 */
public final class RandomString {
	
	private static final Random RANDOM = new Random();// NOSONAR
	
	private RandomString() {
	}
	
	public static String getRandomString(int i) {
		//EL java.util.UUID; no se recomienda porque puede repetir las cadenas
        String alphaNumericS;
        StringBuilder builder;
        alphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; 
        //create the StringBuffer
        builder = new StringBuilder(i); 

        for (int m = 0; m < i; m++) {
        	// generate numeric        	
            int myindex 
                = (int)(alphaNumericS.length() 
                        * Math.random());// NOSONAR
            // add the characters
            builder.append(alphaNumericS 
                        .charAt(myindex)); 
        }
        return builder.toString(); 
    }
	
	public static String getRandomNumber(int i) {
		//EL java.util.UUID; no se recomienda porque puede repetir las cadenas
        String numericS;
        StringBuilder builder;
        numericS = "012345678901234567890123456789876543210"; 
        //create the StringBuffer
        builder = new StringBuilder(i); 

        for (int m = 0; m < i; m++) {
            // generate numeric
            int myindex 
                = (int)(numericS.length() 
                        * Math.random());// NOSONAR
            builder.append(numericS 
                        .charAt(myindex)); 
        }
        return builder.toString(); 
    }
	
	public static String getRandomStringStream(int i) {
		//Only ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 characters
	    return RANDOM.ints(48, 123)
	           .filter(num -> (num<58 || num>64) && (num<91 || num>96))
	           .limit(i)
	           .mapToObj(c -> (char)c).collect(StringBuffer::new, StringBuffer::append, StringBuffer::append)
	          .toString();
	}

}
