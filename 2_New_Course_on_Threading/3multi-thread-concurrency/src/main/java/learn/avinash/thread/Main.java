package learn.avinash.thread;

import learn.avinash.thread.utils.IOUtils;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String sourceFile1 = "E:\\MultiThreading\\Multi-Threading-In-Java\\2_New_Course_on_Threading\\3multi-thread-concurrency\\src\\a.txt";
        String destFile1 = "E:\\MultiThreading\\Multi-Threading-In-Java\\2_New_Course_on_Threading\\3multi-thread-concurrency\\src\\c.txt";

        String sourceFile2 = "E:\\MultiThreading\\Multi-Threading-In-Java\\2_New_Course_on_Threading\\3multi-thread-concurrency\\src\\b.txt";
        String destFile2 = "E:\\MultiThreading\\Multi-Threading-In-Java\\2_New_Course_on_Threading\\3multi-thread-concurrency\\src\\d.txt";

        IOUtils.copyFile(sourceFile1, destFile1);
        IOUtils.copyFile(sourceFile2, destFile2);


    }
}
