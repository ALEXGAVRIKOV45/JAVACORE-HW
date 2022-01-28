package HW5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class AppData {
	private String[] header;
	private Integer[][] data;
	public static final String SEMICOLON = ";";

	public void readFromCSV(String file) {

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			ArrayList<Integer[]> rowsList = new ArrayList<>();
			header = (reader.readLine().split(SEMICOLON));
			String line;

			while ((line = reader.readLine()) != null) {
				String[] strArr = line.split(SEMICOLON);
				Integer[] intArr = new Integer[strArr.length];
				for (int i = 0; i < strArr.length; i++) {
					intArr[i] = Integer.parseInt(strArr[i]);
				}
				rowsList.add(intArr);
			}
			data = rowsList.toArray(new Integer[][]{});

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(Arrays.stream(header).toList());
		for (int y=0; y< data.length; y++){
			for (int x=0; x< data[0].length; x++) {
				System.out.print(data[y][x]+ " ");
			}
			System.out.println();
		}
	}

	public void writeToCSV(String fileName) {
		try {
			BufferedWriter wrBuff = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8));

			StringBuffer oneLine = new StringBuffer();
			for (int i = 0; i < header.length; i++) {
				oneLine.append(header[i]);
				oneLine.append(SEMICOLON);
			}
			wrBuff.write(oneLine.toString());
			wrBuff.newLine();


			for (int i = 0; i < data.length; i++) {
				Integer[] rowData = data[i];
				oneLine.delete(0, oneLine.length());
				for (int j = 0; j < rowData.length; j++) {
					oneLine.append(rowData[j]);
					oneLine.append(SEMICOLON);
				}
				wrBuff.write(oneLine.toString());
				wrBuff.newLine();
			}

			wrBuff.flush();
			wrBuff.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}









	public String[] getHeader() {
		return header;
	}

	public Integer[][] getData() {
		return data;
	}

}
