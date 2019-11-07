import java.io.File;
import java.io.IOException;
import java.io.FilenameFilter;

public class CountInFile {


    public static void main(String[] args) {
        FileCounting fileCounting = new FileCounting();
        //System.out.println(fileCounting.ScanTheFile("antonysspeech.txt"));
   
        File dir = new File(".");

        File[] matches = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });

        for (File file : matches) {
            System.out.println(fileCounting.ScanTheFile(file.getName()));
        }
    }
}
