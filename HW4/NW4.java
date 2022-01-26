/**
 *  Java Core. Homework #4
 *
 *  @ author Alex Gavrikov
 *  @ version 26/01/2022
 *
 */
package HW4;

import java.lang.reflect.Array;
import java.util.*;

public class NW4 {
	public static void main(String[] args) {

		// Create ArrayList
		ArrayList<String> ListWords = new ArrayList<>(
				Arrays.asList("Plan", "Tank", "Plan", "Window", "Rain", "Road", "Tree", "Sun", "Tree", "Family", "Tree", "Car", "Map", "Rain", "Home", "Sun", "Sun", "Cat", "Dog", "Plan"));
		// Create Set
		Set<String> SetListWords = new HashSet<>();
		SetListWords.addAll(ListWords);
		// Print ArrayList
		System.out.println(ListWords);
		System.out.println(ListWords.size());
		// Print Set
		System.out.println(SetListWords);
		System.out.println(SetListWords.size());
		//
		ArrayList<String> tempList = new ArrayList<>();
		tempList.addAll(SetListWords);
		int numWord = 0;
		for (int i = 0; i < SetListWords.size() - 1; i++) {
			String word = tempList.get(i);
			for (int y = 0; y < ListWords.size() - 1; y++) {
				if (ListWords.get(y) == word) {
					numWord++;
				}
			}
			System.out.println("Word - " + word + " in ArrayList repeats: " + numWord);
			numWord = 0;
		}

		PhoneBook Book = new PhoneBook();

		Book.addManPhone("Ivanov",8912873);
		Book.addManPhone("Petrov",8913771);
		Book.addManPhone("Sidorov",8915118);
		Book.addManPhone("Ivanov",8911634);
		Book.addManPhone("Marks",8917543);
		Book.addManPhone("Lenin",8919481);
		Book.addManPhone("Marks",8918753);

		Book.PrintPhoneBook();

		System.out.println("Ivanov: " + Book.getNumberByName("Ivanov"));
		System.out.println("Marks: " + Book.getNumberByName("Marks"));
		System.out.println("Lenin: " + Book.getNumberByName("Lenin"));




	}
}












