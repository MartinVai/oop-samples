import java.util.ArrayList;
import java.util.List;

public class Nope4 {
  public static void main(String[] args) {
    List<FactorialTask> tasks = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      FactorialTask task = new FactorialTask(i * 10);
      new Thread(task).start();
      tasks.add(task);
    }
    for (FactorialTask task : tasks) {
      System.out.println(task.input + " -> " + task.result);
    }
  }
}
class FactorialTask implements Runnable {
  public long input;
  public long result;
  public FactorialTask(long input) {
    this.input = input;
  }
  @Override
  public void run() {
    result = 1;
    for (long i = input; i >= 0; i--) {
      result = result * i;
    }
  }
}
