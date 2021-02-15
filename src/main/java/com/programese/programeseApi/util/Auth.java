package com.programese.programeseApi.util;

import javax.xml.bind.DatatypeConverter;

import com.programese.programeseApi.entity.Usuario;

public class Auth {

private static final String prefix="GeNeRaTiOn|";
	
	public static String encode(Usuario usuario) {
		return DatatypeConverter.printHexBinary((prefix+usuario).getBytes());
	}
	
	public static boolean isValid(String token) {
		byte strByte[] =  DatatypeConverter.parseHexBinary(token);
		String newToken = new String(strByte);
		return newToken.startsWith(prefix);
	}
}
