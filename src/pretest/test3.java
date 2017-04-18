package pretest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test3 {
	
	public static void main(String[] args) {
		poker pp = new poker();
		List<String> player1 = pp.selectRan();
		List<String> player2 = pp.selectRan();
		
		pp.Fight(player1, player2);
		
	}
}

