public class ThreadRun {

  public static void main(String[] args) {
    Runnable code = new Runnable() {
      @Override
      public void run() {
        System.out.println("running in thread " + Thread.currentThread().getName());
      }
    };

    for (int i = 0; i < 3; i++) {
      new Thread(code).run();
    }
  }
}

/*
Bugi:
Thread#start asemel kasutatakse Thread#run. See ei käivita
uut paralleelset lõime vaid täitab selle lõime koodi run()
kutsuvas lõimes. Ära kasuta kunagi Thread#run.
 */
