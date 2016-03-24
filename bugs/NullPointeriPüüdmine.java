import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class NullPointeriPüüdmine {

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

/*
Bugid:
- readerit ei sulgeta
- kood püüab NullPointerException. erindite püüdmine ei asenda
  tavalist if-else loogikat. võimalusel peaks kasutama if-else,
  sest seda on oluliselt lihtsam lugeda - kood ei hüppa teise
  kohta, nagu erindite puhul.
 */

class NullPointeriPüüdmineLahendus {

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(
            new FileInputStream("file.txt")))) {

      while (true) {
        String line = reader.readLine();
        if (line == null)
          break;
        System.out.println(line.length());
      }
    }
  }
}
