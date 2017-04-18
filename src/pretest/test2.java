package pretest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {
	public static void main(String[] args) {
		String enter = "The quick <font color=\"brown\">brown</font> fox jumps over the <i>lazy</i> dog";
		//tag
		String result = new String();
		String temp[] = enter.split("<[^>]*>");
		List<String> tempList = new ArrayList(Arrays.asList(temp));
		Pattern pattern  =  Pattern.compile("<[^>]*>");
		Matcher matcher = pattern.matcher(enter);
		List<String> tagList = new ArrayList();
		while(matcher.find()){
			tagList.add(matcher.group());
		}
		Collections.reverse(tagList);
		Collections.reverse(tempList);
		for(int i = 0;i<tagList.size();i=i+2){
			String t = tagList.get(i);
			tagList.set(i, tagList.get(i+1));
			tagList.set(i+1, t);
		}
		int tagN = 0;
		for(int i=0;i<tempList.size();i++){
			if(i!=0){
				tempList.add(i, tagList.get(tagN));
				result = result +tempList.get(i);
				tagN++;
				i++;
			}
			tempList.set(i, reverseString(tempList.get(i)));
			result = result +tempList.get(i);
		}
		System.out.println(result);
	}

	private static String reverseString(String string) {
		char temp[] = string.toCharArray();
		String result= "";
		for(int i = temp.length-1;i>=0;i--){
			result= result + temp[i];
		}
		return result;
	}
}
