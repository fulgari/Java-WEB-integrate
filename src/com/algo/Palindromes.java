package com.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Palindromes {
	public static void main(String[] args) {
		while(true) {
		boolean isPalin=false, isMirrored=false;
		Scanner sc = new Scanner(System.in);
		String sOrigin=sc.next();
		
		sOrigin.replaceAll("0", "O");
		
		if(sOrigin==null) return;
		char[] temp=sOrigin.toCharArray();
		char[] chInv = new char[temp.length];
		for(int i=0; i<temp.length;i++) {
			chInv[i] = temp[temp.length-i-1];
		}
		String sInv = String.valueOf(chInv);
		if(sInv.equals(sOrigin)) isPalin=true;
		
		if(mirror(sInv).equals(sOrigin)) isMirrored=true;
		System.out.println(sInv+", "+mirror(sInv));
		System.out.println("isPalindrome:"+isPalin+", isMirrored:"+isMirrored+" ^^");
		}
	}
	
	private static String mirror(String s) {
		char[] sample = {'A','E','H','I','J','L','M','O','S','T','U','V','W','X','Y','Z','1','2','3','5','8'};
		char[] corres = {'A','3','H','I','L','J','M','O','2','T','U','V','W','X','Y','5','1','S','E','Z','8'};
		StringBuffer sbuff = new StringBuffer();
		char[] cs = s.toCharArray();
		String sSam = String.valueOf(sample);
		for(int i=0; i<s.length(); i++) {
			if(sSam.indexOf(cs[i])!=-1) sbuff.append(corres[sSam.indexOf(cs[i])]);
			else sbuff.append('#');
		}
		return sbuff.toString();
	}
	
}
