import java.util.ArrayList;
import java.util.List;

public class PuuduvSünkroniseerimine {
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

/*
Bugid:
- peameetod käivitab lõimed, aga ei oota enne nende tulemuste
  lugemist, et lõimed töö lõpetaks. kasuta Thread#join, et
  oodata lõime töö lõppemist.
- FactorialTask väljad on ilma hea põhjuseta public
- FactorialTask väljasi kasutatakse erinevatest lõimedest ilma
  sünkroniseerimiseta. tulemused on täiesti ettearvamatud.
 */

class PuuduvSünkroniseerimineLahendus {
  public static void main(String[] args) throws InterruptedException {
    List<FactorialTaskLahendus> tasks = new ArrayList<>();
    List<Thread> threads = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      FactorialTaskLahendus task = new FactorialTaskLahendus(i * 10);
      Thread thread = new Thread(task);
      thread.start();
      threads.add(thread);
      tasks.add(task);
    }
    for (Thread thread : threads) {
      thread.join();
    }
    for (FactorialTaskLahendus task : tasks) {
      System.out.println(task.getInput() + " -> " + task.getResult());
    }
  }
}

class FactorialTaskLahendus implements Runnable {
  private long input;
  private long result;

  public FactorialTaskLahendus(long input) {
    this.input = input;
  }

  @Override
  public synchronized void run() {
    result = 1;
    for (long i = input; i >= 0; i--) {
      result = result * i;
    }
  }

  public synchronized long getInput() {
    return input;
  }

  public synchronized long getResult() {
    return result;
  }
}
