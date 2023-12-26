package util;

import java.security.MessageDigest;

public class encode {
	public static String toSHA1(String str) {
	    String salt = "fhjadsvbfsfbv#$@^*vbhb@#$*";
	    String rs = null;
	    rs = rs + salt;
	    try {
	        byte[] dataBytes = str.getBytes("UTF-8");
	        MessageDigest md = MessageDigest.getInstance("SHA-1");
	        rs = org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(md.digest(dataBytes));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return rs;
	}
	
	
	public static void main(String[] args) {
		System.out.println(toSHA1("123"));
	}
}



