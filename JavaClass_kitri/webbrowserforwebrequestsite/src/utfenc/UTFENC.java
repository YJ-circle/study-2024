package utfenc;

import java.io.UnsupportedEncodingException;

public class UTFENC {
	public static String utfenc(String rawData) {
        byte[] bytes = null;;
        String utf8hexStr = ""; 
		try {
			bytes = rawData.getBytes("UTF-8");
	        for(byte oneByte : bytes) {
	        	utf8hexStr += "%" + String.format("%x", oneByte);
	        }
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        return utf8hexStr.toUpperCase();
	}
}
