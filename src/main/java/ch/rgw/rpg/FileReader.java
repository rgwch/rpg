package ch.rgw.rpg;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gerry on 09.05.16.
 */
public class FileReader {

    public static List<String> load(String filename) {
        try {
            File file=new File(filename);
            System.out.println(file.getAbsolutePath().toString());
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(filename);
            if (is == null) {
                is = new FileInputStream(filename);
            }
            if (is == null) {
                throw new FileNotFoundException("vornamen.txt not found");
            }

            LinkedList<String> lines = new LinkedList<String>();
            BufferedReader vn = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = vn.readLine()) != null) {
                lines.add(line);
            }
            vn.close();
            return lines;
        } catch (IOException ex) {
            return null;
        }
    }
}
