import java.io.StringReader;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class FileCounting {

    private int characters;
    private int newLines;
    private int bytes;

    FileCounting() {
        this.characters = 0;
        this.newLines = 0;
        this.bytes = 0;        
    }

    public String ScanTheFile(String filename) {
        String results = "";
        try {
            FileInputStream inputStream = new FileInputStream(new File(filename));
            Scanner scanner = new Scanner(inputStream,"UTF-8").useDelimiter("\\A");
            results = scanner.hasNext() ? scanner.next() : "";
            // System.out.println(results);
            scanner.close();        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        
        return ScanString(results) + " " + filename;
    }

    public String ScanString(String fileContents) {
        char[] charArray = fileContents.toCharArray();

        int newLines = 0;
        int characters = fileContents.split(" ").length;
        int byteCount = 0;

        try {
            byte [] arrayBytes = fileContents.getBytes("UTF-8");
            byteCount = arrayBytes.length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        for (char c : charArray) {
            if (c == '\n') {
                newLines++;
            }
        }

        return String.format("%1$7d %2$7d %3$7d", newLines, characters, byteCount);
    }
}
