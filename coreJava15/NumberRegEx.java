package coreJava15;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberRegEx {
	final static String pattern="\\d+";
	public boolean isValid(String num) {
		Pattern regex = Pattern.compile(pattern);
		Matcher matcher=regex.matcher(num);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

}
