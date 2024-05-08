/**
 * @project OtherProjects
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "src/hust/soict/dsai/garbage/text.txt";
        byte[] inputBytes = {0};
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        startTime = System.currentTimeMillis();
        StringBuilder outputSB = new StringBuilder();
        for (byte b : inputBytes) {
            outputSB.append((char) b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) + "ms");
    }
}

