package TestData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestDataCSV {
	public static Object[][] readCSV(String filePath) {
        String line;
        String splitBy = ",";
        int rowCount = 0;
        int colCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // First, count the number of rows and columns
            while ((line = br.readLine()) != null) {
                rowCount++;
                String[] values = line.split(splitBy);
                colCount = values.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Now, read the data into a 2D Object array
        Object[][] data = new Object[rowCount][colCount];
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int row = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(splitBy);
                for (int col = 0; col < values.length; col++) {
                    data[row][col] = values[col];
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
