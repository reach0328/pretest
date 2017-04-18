package pretest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test3 {
	
	public static void main(String[] args) {
		String num[] = {"2","3","4","5","6","7","8","9","T","Q","K","A"};
		String figure[] = {"c","d","h","s"};
		List<String> player1 = new ArrayList<>();
		List<Integer> pNum1 = new ArrayList<>();
		List<String> player2 = new ArrayList<>();
		List<Integer> pNum2 = new ArrayList<>();
		List<String> card = new ArrayList<>();
		for(int i=0 ;i<12;i++){
			for(int j=0;j<4;j++){
				card.add(num[i]+figure[j]);
			}
		}
		Random ran = new Random();
		for(int j=0;j<5;j++) {
			int temp1 = ran.nextInt(48);
			if(pNum1.contains(temp1))
				temp1 = ran.nextInt(48);
			pNum1.add(temp1);
			int temp2 = ran.nextInt(48);
			if(pNum2.contains(temp2))
				temp2 = ran.nextInt(48);
			pNum2.add(temp2);
		}
		for(int i = 0; i<5;i++){
			player1.add(card.get(pNum1.get(i)));
			player2.add(card.get(pNum2.get(i)));
		}
		for(int i = 0;i<5;i++){
			
		}
	}
}
