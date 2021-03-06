package learn.avinash.thread.utils;

import java.io.*;

public class IOUtils {
    public static void copy(InputStream src, OutputStream dest) throws IOException {
        int value;
        while((value = src.read()) !=1){
            dest.write(value);
        }

    }

    public static void copyFile(String src, String dest) throws IOException {
        FileInputStream fin = new FileInputStream(src);
        FileOutputStream fout = new FileOutputStream(dest);

        IOUtils.copy(fin, fout);

        System.out.println("Done");
        fin.close();
        fout.close();
    }
}
