public class Nope3 {

  public static void main(String[] args) {
    Runnable code = () -> {
      System.out.println("running in thread " +
          Thread.currentThread().getName());
    };

    for (int i = 0; i < 3; i++) {
      new Thread(code).run();
    }
  }
}
