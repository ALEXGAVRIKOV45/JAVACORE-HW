package HW5;

import java.io.*;
import java.util.Random;

public class HW5 {
	public static void main(String[] args) {
		Random random;
		random = new Random();

		File file = new File("work.csv");

        try (PrintWriter out = new PrintWriter(file)) {
		out.println("N;Name;Status;City;");
		out.println("1;Alex;UP;Kurgan;");
		out.println("2;Vova;UP;Moscow;");
		out.println("3;Petr;DOWN;Paris;");
		out.println("4;Boris;UP;London;");

	} catch (IOException e) {
		e.printStackTrace();
	}

		File fileint = new File("int.csv");
	int intvalue = 0;
		try (PrintWriter out = new PrintWriter(fileint)) {
			out.println("Value1;Value2;Value3;Value4");
			for (int i=0; i < 10; i++){
				intvalue= random.nextInt(30);
				out.println(intvalue+";"+ intvalue+";"+intvalue+";"+ intvalue+";");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		AppData fileData = new AppData();
		fileData.readFromCSV("int.csv");
		fileData.writeToCSV("New int.csv");

}
}
