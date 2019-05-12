public class ThreadInhertiance {
    public static void main(String[] args) {
        Thread thread = new NewThread();
        thread.start();
    }

    private static class NewThread extends Thread{
        @Override
        public void run(){
            System.out.println("Hello I am Thread " + this.getName());
        }
    }
}
