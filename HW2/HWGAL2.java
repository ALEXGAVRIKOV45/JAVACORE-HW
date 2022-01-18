/**
 *  Java Core. Homework #2
 *
 *  @ author Alex Gavrikov
 *  @ version 16/01/2022
 *
 */
package HW2;
import java.util.Random;
import java.util.Scanner;

public class HWGAL2 {
	public static void main(String[]args) throws MyArraySizeException, MyArrayDataException {

		String[][]table = new String[4][4];
		String[][]tableBag = new String[4][4];
		String[][]table6 = new String[6][6];
		//создаем 3 таблицы
		initTable(table, true);
		initTable(table6, true);
		initTable(tableBag, false);
		//начинаем тестировать и печатать таблицы
		// таблица 4 Х 4
		printTable(table);
		testMyTable(table);

		// таблица где есть BAG
		printTable(tableBag);
		testMyTable(tableBag);


		// таблица 6 Х 6
		printTable(table6);
		testMyTable(table6);
	}

	static void initTable(String[][] table, boolean allString) {
		int row;
		int col;
		Random random = new Random();

		for (row = 0; row < table.length; row++){
			for (col = 0; col < table.length; col++) {
				table[row][col] = String.valueOf(row + col);
			}
		}
		if (!allString) {
			row = random.nextInt(4);
			col = random.nextInt(4);
			table[row][col] = "BAG";
		}
	}

	static void printTable(String[][] table) {
		System.out.println();
		for (int row = 0; row < table.length; row++) {
			for (int col = 0; col < table.length; col++)
				System.out.print(table[row][col] + " ");
			System.out.println();
		}

	}

	static void testMyTable(String[][] table) throws MyArraySizeException, MyArrayDataException {
		int summTable = 0;

		if (table.length != 4 ) {
			throw new MyArraySizeException("Table size is not 4 X 4 !");
		} else {
			System.out.println("Table size is OK !");
		}

		for (int row = 0; row < table.length; row++) {
			for (int col = 0; col < table.length; col++) {
				try {
					summTable = summTable + Integer.parseInt(table[row][col]);
				} catch (NumberFormatException error) {
					MyArrayDataException err2 = new MyArrayDataException("Table has BAG! in cell ROW:COL " + (row+1)+":"+(col+1));
				}

			}
		}
		System.out.println("Table summ is : " + summTable);
	}

}
