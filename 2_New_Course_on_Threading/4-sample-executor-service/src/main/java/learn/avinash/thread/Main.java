package learn.avinash.thread;

import learn.avinash.thread.utils.IOUtils;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CopyTask implements  Runnable{
    String sourceFile;
    String destFile;

    public CopyTask(String sourceFile, String destFile) {
        this.sourceFile = sourceFile;
        this.destFile = destFile;
    }

    public void run() {
        try {
            IOUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        String sourceFile1 = "E:\\MultiThreading\\Multi-Threading-In-Java\\2_New_Course_on_Threading\\3multi-thread-concurrency\\src\\a.txt";
        String destFile1 = "E:\\MultiThreading\\Multi-Threading-In-Java\\2_New_Course_on_Threading\\3multi-thread-concurrency\\src\\c.txt";

        String sourceFile2 = "E:\\MultiThreading\\Multi-Threading-In-Java\\2_New_Course_on_Threading\\3multi-thread-concurrency\\src\\b.txt";
        String destFile2 = "E:\\MultiThreading\\Multi-Threading-In-Java\\2_New_Course_on_Threading\\3multi-thread-concurrency\\src\\d.txt";

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new CopyTask(sourceFile1, destFile1));
        executorService.execute(new CopyTask(sourceFile2, destFile2));


    }
}
