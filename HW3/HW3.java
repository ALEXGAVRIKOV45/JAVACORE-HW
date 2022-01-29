/**
 *  Java Core. Homework #3
 *
 *  @ author Alex Gavrikov
 *  @ version 22/01/2022
 *
 */

package HW3;

import java.util.Random;
import java.util.Arrays;

public class HW3 {
	public static void main(String[] args) {
		Random random;
		random = new Random();

		String[] arrayCitys = {"Moskow", "Minsk", "Kiev", "Riga", "Paris", "Barselona"};
		// initial array
		System.out.println(Arrays.toString(arrayCitys));
		// changed arrays
		System.out.println(Arrays.toString(twistCity(arrayCitys, 2, 4)));
		System.out.println(Arrays.toString(twistCity(arrayCitys, 0, 1)));
		System.out.println();
		// add fruit boxs and fill it fruits
		BoxF<Orange> oBox = new BoxF<Orange>(1.5f);
		BoxF<Apple> aBox = new BoxF<Apple>(1.0f);

		int numberO = 0;
		int numberA = 0;
		while (numberO == 0) {
			numberO = random.nextInt(10);
		}
		while (numberA == 0) {
			numberA = random.nextInt(10);
		}
		for (int i=0; i < numberO; i++) {
			oBox.addFruit(new Orange());
		}
		for (int i=0; i < numberA; i++) {
			aBox.addFruit(new Apple());
		}

		System.out.println("Orange Box has : " + oBox.getSize()+ " fruits. Weigth : " + oBox.getWeight());
		System.out.println("Apple Box has : " + aBox.getSize()+ " fruits. Weigth : " + aBox.getWeight());
		System.out.println();
		System.out.println("Compare Orange Box and Apple Box. Weigths boxs is " + (oBox.compareBoxs(aBox) ? "equals" : "not equals"));
		System.out.println();
		// sprinkle apples boxs
		BoxF<Apple> aBox2 = new BoxF<Apple>(1.0f);
		numberA = 0;
		while (numberA == 0) {
			numberA = random.nextInt(10);
		}

		for (int i=0; i < numberA; i++) {
			aBox2.addFruit(new Apple());
		}
		System.out.println();
		System.out.println("Sprinkle apple boxs");
		System.out.println("Apple Box1 has : " + aBox.getSize()+ " fruits. Weigth : " + aBox.getWeight());
		System.out.println("Apple Box2 has : " + aBox2.getSize()+ " fruits. Weigth : " + aBox2.getWeight());
		System.out.println();
		//afte sprinkle
		aBox.sprinkleFruits(aBox2);
		System.out.println("After sprinkle apple boxs");
		System.out.println("Apple Box1 has : " + aBox.getSize()+ " fruits. Weigth : " + aBox.getWeight());
		System.out.println("Apple Box2 has : " + aBox2.getSize()+ " fruits. Weigth : " + aBox2.getWeight());

	}

	public static Object[] twistCity(Object[] citys, int city1, int city2) {
		Object citytemp = citys[city1];
		citys[city1] = citys[city2];
		citys[city2] = citytemp;
		return citys;
	}
}

