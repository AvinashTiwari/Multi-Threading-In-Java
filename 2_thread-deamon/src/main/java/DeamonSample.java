import java.math.BigInteger;

public class DeamonSample {

    public static void main(String[] args) {
        Thread thread = new Thread(new longComputation(new BigInteger("20000") , new BigInteger("100000000")));
        thread.setDaemon(true);
        thread.start();
        thread.interrupt();

    }

    public static class longComputation implements Runnable {
        BigInteger base;
        BigInteger power;

        public longComputation(BigInteger base, BigInteger power){
            this.base = base;
            this.power = power;

        }

        @Override
        public void run() {
             System.out.println("The Result " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power){
            BigInteger result = BigInteger.ONE;
            for(BigInteger i = BigInteger.ONE; i.compareTo(power) !=0 ; i = i.add(BigInteger.ONE)){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("Thread had been interrupted");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }

            return  result;
        }
    }
}
