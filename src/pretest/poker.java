package pretest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class poker {
	List<String> order;
	List<String> figure;
	List<String> card;
	public poker() {
		order = new ArrayList<>();
		figure = new ArrayList<>();
		card = new ArrayList<>();
		order.add("2");		order.add("3");
		order.add("4");		order.add("5");
		order.add("6");		order.add("7");
		order.add("8");		order.add("9");
		order.add("T");		order.add("J");
		order.add("Q");		order.add("K");
		order.add("A");		figure.add("c");
		figure.add("d");	figure.add("h");
		figure.add("s");
		for(int i=0;i<13;i++) {
			for(int j=0;j<4;j++) {
				card.add(order.get(i)+figure.get(j));
			}
		}
	}
	
	public List<String> selectRan() {
		List<String> player = new ArrayList<>();
		Random ran = new Random();
		for(int i=0;i <5;) {
			int tNum1 = ran.nextInt(card.size());
			if(!player.contains(card.get(tNum1))){
				player.add(card.get(tNum1));
				System.out.print(player.get(i)+"   ");
				i++;
			}
		}
		System.out.println("");
		return player;
	}
	
	
	public void Fight(List<String> player1,List<String> player2) {
		int pNum1 = checked(player1);
		int pNum2 = checked(player2);
		if(pNum1 > pNum2) {
			System.out.println("player1 WIN");
			return;
		} else if(pNum1 <pNum2) {
			System.out.println("player2 WIN");
			return;
		} else {
			List<Integer> o1= sOrder(player1);
			List<Integer> o2= sOrder(player2);
			System.out.println(o1.size()+"  "+o2.size());
			for(int i=o1.size()-1;i>=0;i--) {
				if(o1.get(i)>o2.get(i)){
					System.out.println("player1 WIN");
					return;
				} else if(o1.get(i)<o2.get(i)){
					System.out.println("player2 WIN");
					return;
				} else if(i==0){
					System.out.println("Draw");
					return;
				}
			}
		}
	}
	
	public int checked(List<String> card) {
		int result = 0;
		List<Integer> o = sOrder(card);
		List<String> f = sFigure(card);
		if(checkFigure(f)){
			if(checkOrderNum(o)){
				if(o.get(0)==8 && o.get(1)==9
						&& o.get(2)==10 && o.get(3)==11
						&& o.get(4)==12)
					return 10;
				return 9;
			} else {
				return 6;
			}
		} else {
			if(checkOrderNum(o)){
				return 5;
			} else {
				String checked = checkSame(o);
				if(checked.equals("one")){
					return 2;
				} else if(checked.equals("two")){
					return 3;
				} else if(checked.equals("three")){
					return 4;
				} else if(checked.equals("four")){
					return 8;
				} else if(checked.equals("full")){
					return 7;
				} else {
					return 1;
				}
			}
		}
	}
	
	public List<Integer> sOrder(List<String> card){
		List<Integer> result = new ArrayList<>();
		for(int i = 0 ;i<card.size();i++){
			result.add(order.indexOf(card.get(i).substring(0, 1)));
		}
		Collections.sort(result);
		return result;
	}
	
	public List<String> sFigure(List<String> card){
		List<String> result = new ArrayList<>();
		for(int i = 0 ;i<card.size();i++){
			result.add(card.get(i).substring(1));
		}
		Collections.sort(result);
		return result;
	}
	
	public boolean checkFigure(List<String> f) {
		for(int i = 1; i<f.size(); i++) {
			if(!f.get(0).equals(f.get(i))){
				return false;
			}
		}
		return true;
	}
	
	public boolean checkOrderNum(List<Integer> o) {
		int temp = 1;
		for(int i =1;i<o.size(); i++){
			if(!((o.get(0)+i)==o.get(i))) {
				if(o.get(4)==12 && i==4 && o.get(0)==2){
					return true;
				}
				return false;
			}
		}
		return true;
	}
	
	public String checkSame(List<Integer> o) {
		int num = 1;
		List<Integer> temp = new ArrayList<>();
		for(int i=0;i<o.size();i++) {
			num=1;
			for(int j =i+1;j<o.size();j++){
				if(o.get(i).equals(o.get(j))){
					num++;
				}
			}
			if(num>1){
				temp.add(num);
			}
		}
		if(temp.size()>0) {
			if(temp.size()==1){
				int p =temp.get(0);
				if( p == 2){
					return "one";
				} else if(p==3) {
					return "three";
				} else {
					return "four";
				}
			} else {
				if(temp.get(0)==3 || temp.get(1)==3) {
					return "full";
				} else {
					return "two";
				}
			}
		}
		return "high";
	}
	
}
