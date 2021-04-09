package ali;

public class OddEvenRunnable implements Runnable{
	 
    public int PRINT_NUMBERS_UPTO=10;
    static int  number=1;
    int remainder;
    int counteven;
    int countodd;
    static Object lock=new Object();
 
    OddEvenRunnable(int remainder)
    {
        this.remainder=remainder;
    }
 
    @Override
    public void run() {
        while (number < PRINT_NUMBERS_UPTO) {
            synchronized (lock) {
                while (number % 2 != remainder) { // wait for numbers other than remainder
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        
                    }
                }
                if(Thread.currentThread().getName()=="Even") {
                	counteven ++;
                }
                else if(Thread.currentThread().getName()=="Odd") {
                	countodd ++;
                }
                System.out.println(Thread.currentThread().getName() + " = " + number);
                number++;
                lock.notifyAll();
            }
        }
        System.out.println("totel Even are = " + counteven);
        System.out.println("totel Odd are = " + countodd);
        
    }
}




 