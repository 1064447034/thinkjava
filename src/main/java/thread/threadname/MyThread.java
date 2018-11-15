package thread.threadname;

public class MyThread extends Thread {
	public MyThread() {
		super();
        System.out.println(".....MyThread begin.....");
        System.out.println("Thread.currentThread().getName() = "+Thread.currentThread().getName());
        System.out.println("this.getName() = "+this.getName());
        System.out.println(this.getId());
        System.out.println(Thread.currentThread().getId());
        System.out.println(".....MyThread end.......");
        System.out.println();
    }

    @Override
    public void run() {
        System.out.println(".....run begin.....");
        System.out.println("Thread.currentThread().getName() = "+Thread.currentThread().getName());
        System.out.println("this.getName() = "+this.getName());
        System.out.println(this.getId());
        System.out.println(Thread.currentThread().getId());
        System.out.println("Thread.currentThread()==this :"+ (Thread.currentThread() == this));
        System.out.println(".....run end.......");
    }
}
