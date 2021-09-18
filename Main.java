package homeWorkFive;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AppData appData = new AppData();
        appData.reading("./src/homeWorkFive/file.csv");
        System.out.println(Arrays.toString(appData.getData()));
        System.out.println(Arrays.deepToString(appData.getData()));
        appData.writing("./src/homeWorkFive/file1.txt");
    }
}
