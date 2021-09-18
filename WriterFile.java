package homeWorkFive;

import java.io.*;
import java.util.Scanner;

public class WriterFile {
    public static void main(String[] args) {
        File file = new File("./src/homeWorkFive/data.csv");

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (OutputStream outputStream = new FileOutputStream(file, true)) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            outputStream.write(s.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
