package Simple_Fork_Join_Recursive_Task.Simple_Fork_Join_Recursive_Task;

import java.util.concurrent.ForkJoinPool;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     ForkJoinPool pool = new  ForkJoinPool(Runtime.getRuntime().availableProcessors());
     SimpleRecursiveTask simpleRecursiveTask = new SimpleRecursiveTask(120);
     pool.invoke(simpleRecursiveTask);
    }
}
