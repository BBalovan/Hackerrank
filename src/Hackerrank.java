import java.util.ArrayList;
import java.util.Collections;

public class Hackerrank {

	static String s = "ABBABBABBABAAABAB";
	static int[] lonelyInt = new int[] { 1, 1, 2, 2, 3, 4, 5, 4, 5, 6, 6, 7, 7 };
	static String asd = "aaaaaaaaaaaaa";
	static ArrayList<Integer> intList = new ArrayList<Integer>();

	public static void main(String[] args) {

		intList.add(10);
		intList.add(100);
		intList.add(300);
		intList.add(200);
		intList.add(1000);
		intList.add(20);
		intList.add(30);

		fillingJarsOuter();
		halloweenParty(9);
		alternating(s);
		lonelyInteger(lonelyInt);
		isFibo(5);
		gameOfThrones(asd);
		angryChildren(intList, 3);
		sherlockAndSqares(3,9);
	}

	static void alternating(String s) {

		int numOfChanges = 0;

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				numOfChanges++;
			}
		}
		System.out.println(numOfChanges);

	}

	static void lonelyInteger(int[] lonelyInt) {
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for (int item : lonelyInt)
			intList.add(item);
		int isLonely = 0;
		int x = 2;
		for (int element : intList) {
			isLonely = element;
			for (int elem : intList) {
				if (elem == isLonely) {
					x--;
				}
			}
			if (x == 1) {
				System.out.println(element);
				break;
			}
			x = 2;
		}

	}

	static void isFibo(int y) {

		double z = Math.sqrt(5 * Math.pow(y, 2) + 4);
		double x = Math.sqrt(5 * Math.pow(y, 2) - 4);

		if (z % 1 == 0 || x % 1 == 0) {
			System.out.println("IsFibo");
		} else {
			System.out.println("IsNotFibo");
		}
	}

	static void gameOfThrones(String s) {

		ArrayList<Character> charList = new ArrayList<Character>();

		for (int i = 0; i < s.length(); i++) {
			charList.add(s.charAt(i));
		}
		Collections.sort(charList);
		long sameChar = 0;
		Character same_Char = 'a';
		long notEven = 0;

		for (int i = 1; i < charList.size(); i++) {
			same_Char = charList.get(i);
			Character prev = charList.get(i - 1);
			if (same_Char.equals(prev))
				sameChar++;
			else if (i != 0) {
				if (sameChar % 2 != 0) {
					notEven++;
					sameChar = 1;
				} else
					sameChar = 1;
			}
		}
		if (notEven > 1)
			System.out.println("NO");
		else
			System.out.println("YES");

	}

	static void angryChildren(ArrayList<Integer> intList, int y) {
		Collections.sort(intList);
		int actual;
		int otherNum;
		int actualSub;
		int minSub;
		try {
			minSub = intList.get(intList.size() - intList.get(0));
		} catch (IndexOutOfBoundsException e) {
			minSub = 999999999;
		}

		for (int i = 0; i < intList.size() - y; i++) {
			actual = intList.get(i);
			otherNum = intList.get((i + y) - 1);
			actualSub = otherNum - actual;

			if (actualSub < minSub) {
				minSub = actualSub;
			}
		}
		System.out.println(minSub);

	}

	public static void fillingJarsInner(ArrayList<Integer> intJarList,
			int fromJar, int toJar, int howMuch) {
		int elem;
		for (int i = fromJar; i <= toJar; i++) {
			elem = intJarList.get(i - 1);
			elem += howMuch;
			intJarList.set(i - 1, elem);
			elem = 0;
		}
	}

	public static void fillingJarsOuter() {
		ArrayList<Integer> intJarList = new ArrayList<Integer>();
		int N = 20000;
		int B = 1;
		for (int i = 0; i < N; i++) {
			intJarList.add(0);
		}

		for (int i = 0; i < B; i++) {
			fillingJarsInner(intJarList, 1, 2000, 10000);
		}
		long osszeg = 0;
		for (int elem : intJarList) {
			osszeg += intJarList.get(intJarList.indexOf(elem));
		}
		int answer = (int) (osszeg / N);
		System.out.print(answer);
	}

	static void halloweenParty(double cuts) {
		double half = cuts / 2;
		long peices = (long) Math.pow(half, 2);
		System.out.print(peices);

	}
	static void sherlockAndSqares(int minInput, int maxInput) {
		int x = 0;
		for (int i = minInput; i <= maxInput; i++) {
			if (Math.sqrt(i) % 1 == 0) 	{
				x++;
				//System.out.println(i);
				
			}
		}
		System.out.println(x);
		
	}

}
