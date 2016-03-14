import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nope5 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(
        new InputStreamReader(
            new FileInputStream("file.txt")));

    try {
      while (true) {
        String line = reader.readLine();
        System.out.println(line.length());
      }
    } catch (NullPointerException npe) {
      System.out.println("Faili lõpp");
    }
  }
}
