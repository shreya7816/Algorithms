package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PermutationOfString {

	public static void main(String[] args) {
		String s= "aba";
		Set<String> permStrs = getPermutationOfString(s);
		for(String str: permStrs) {
			System.out.println(str);
		}
		
		String str= "abc";
		List<String> permutationOfStringNotInOrder = getPermutationOfStringNotInOrder(str);
		System.out.println("*****************************");
		for(String s1: permutationOfStringNotInOrder) {
			System.out.println(s1);
		}
	}

	private static Set<String> getPermutationOfString(String str) {
		return getPermutationOfStringUtils("", str);
	}
	
	private static List<String> getPermutationOfStringNotInOrder(String str) {
		char[] chars = str.toCharArray();
		int l= chars.length;
		return getPermutationOfStringNotInOrderUtils(chars, l);
	}
	
	private static List<String> getPermutationOfStringNotInOrderUtils(char[] chars, int l) {
		List<String> strs= new ArrayList<>();
		if(l== 1) {
			String string = new String(chars);
			strs.add(string);
			return strs;
		}
		for(int i= 0;i<l;i++) {
			swap(chars, i, l-1);
			strs.addAll(getPermutationOfStringNotInOrderUtils(chars, l-1));
			swap(chars, i, l-1);
		}
		
		return strs;
	}

	private static void swap(char[] chars, int i, int j) {
		char tmp= chars[i];
		chars[i]= chars[j];
		chars[j]= tmp;
	}

	private static Set<String> getPermutationOfStringUtils(String prefix, String str) {
		Set<String> permStrs= new LinkedHashSet<String>();
		int l= str.length();
		if(l== 0) {
			permStrs.add(prefix);
			return permStrs;
		}
		for(int i= 0;i<l;i++) {
			Set<String> strs= getPermutationOfStringUtils(prefix+str.charAt(i), str.substring(0, i)+str.substring(i+1, l));
			permStrs.addAll(strs);
		}
		return permStrs;
	}
}
