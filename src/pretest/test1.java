package pretest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test1 {
	public static void main(String[] args) {
		int read[] = {13,14,15,16,20,23,24,25,100};
		int temp = read[0];
		String show = ""+temp;
		int count = 1;
		for(int i = 1; i < read.length;i++) {
			temp = temp+1;
			count++;
			if(temp != read[i] && i !=1){
				if(count>2){
					count=1;
					show = show +"~"+ read[i-1];
				}
				temp = read[i];
				show = show +", "+ read[i];
			}
		}
		System.out.println(show);
	}
}
