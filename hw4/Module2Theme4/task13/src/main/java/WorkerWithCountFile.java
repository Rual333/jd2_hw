import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class WorkerWithCountFile {

    private static final String countfilePath = "/countTask13.txt";
    private static String filePath = countfilePath;

    public static void createCountFile(String path) {
        filePath = path + countfilePath;
        try {
            File f = new File(filePath);
            if (f.createNewFile()) {
                FileWriter fw = new FileWriter(filePath, false);
                fw.write(Integer.toString(0));
                fw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getCountAndIncrement() {
        int count = 0;
        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            count = scanner.nextInt() + 1;
            FileWriter fw = new FileWriter(filePath, false);
            fw.write(Integer.toString(count));
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int getCount() {
        int count = 0;
        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            count = scanner.nextInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

}