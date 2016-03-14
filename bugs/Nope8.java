import java.util.ArrayList;
import java.util.List;

public class Nope8 {

  public static void main(String[] args) {
    List<String> data = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
      String valueToAdd = "value" + i;
      new Thread(() -> {
        if (!data.contains(valueToAdd)) {
          synchronized (data) {
            data.add(valueToAdd);
          }
        }
      }).start();
    }
  }

}
