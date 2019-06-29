package in.devshiva.messenger.messenger;

public class Sample {

	public static void main(String[] args) {

		String line = "Cornfield, outfield";
		String[] array = line.split(",");

		String s1 = array[0];
		String s2 = array[1];
		int index1 = s1.length() - 1;
		int index2 = s2.length() - 1;
		int index3 = 0;
		char[] charArray = new char[s1.length()];
		String finalOutput = "";

		if (s1.charAt(index1) != s2.charAt(index2)) {
			System.out.println("NULL");
		}

		while (s1.charAt(index1) == s2.charAt(index2)) {

			charArray[index3] = s1.charAt(index1);

			index1--;

			index2--;
			
			index3++;

		}

		int length = charArray.length - 1;
		
		System.out.println(length);

		for (int j = length; j >= 0; j--) {

			finalOutput += charArray[j];

		}

		System.out.println(finalOutput);
	}

}
	      


