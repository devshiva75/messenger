package in.devshiva.messenger.messenger;

import java.util.ArrayList;
import java.util.List;

public class NewSample {

	public static void main(String[] args) {

		String line = "12467930";
		
		//int i = Integer.parseInt(line);
		
		//int i = 0;
		
		/*List<Character> charLis = new ArrayList<>();
		
		while(isEven(line.charAt(i)) && isEven(line.charAt(i+1))){
			charLis.add(line.charAt(i));
			charLis.add('*');
			charLis.add(line.charAt(i+1));
		}
		
		System.out.println(charLis);*/
		
		ArrayList al = new ArrayList<>();
		al.add("a");
		al.add(1);
		
		List<Integer> intList = new ArrayList<>();
		
		for (int i = 0; i < line.length(); i++) {
			char j = line.charAt(i);
			String s = "" + j;
			Integer m = Integer.parseInt(s);
			intList.add(m);
		}
		
		System.out.println(intList);
		
		for(int i = 1;i<intList.size();i++){
			
			if(isEven(intList.get(i)) && isEven(intList.get(i-1))){
				intList.add(i, -1);
				
			} else{
				System.out.println("hhh");
			}
			
			/*else if(isOdd(intList.get(i)) && isOdd(intList.get(i-1))){
				intList.add(i, -9);
			}*/
		}
		
		System.out.println(intList);
	}

	

	
	static boolean isEven(int num){
		if(num == 0){
			return false;
		}
		
		if(num%2 == 0){
			return true;
		}
		return false;
	}
	
	
	static boolean isOdd(int num){
		
		
		if(num%2 != 0){
			return true;
		}
		return false;
	}
	
	

}
