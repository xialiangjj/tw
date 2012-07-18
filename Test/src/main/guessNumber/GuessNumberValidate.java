package main.guessNumber;

import java.util.Calendar;
import java.util.HashSet;
import java.util.regex.Pattern;

public class GuessNumberValidate {
	
	public static boolean isDup(String in) {
		char[] cs=in.toCharArray();
		HashSet<String> set=new HashSet<String>();
		for(char ch:cs){
			set.add(ch+"");
		}
		return set.size()!=cs.length;
	}
	
	public static boolean isFourDigit(String in){
		String regex="[0-9][0-9][0-9][0-9]";
		Pattern pattern=Pattern.compile(regex);
		return pattern.matcher(in).matches();
	} 
	
}
