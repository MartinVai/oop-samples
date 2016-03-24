import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PrintStackTrace implements Runnable {

  @Override
  public void run() {
    FileInputStream fis = null;
    try {
      fis = new FileInputStream("filename");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    DataInputStream dis = new DataInputStream(fis);
    String s = null;
    try {
      s = dis.readUTF();
      System.out.println(s);
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      dis.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

/*
Bugid:
- kood püüab exceptioneid, mida ta ei oska korda teha
- catch plokkides on e.printStackTrace(), mis on tõenäoliselt
  automaatselt genereeritud ja ei tee midagi kasulikku
- pärast exceptioni tekkimist jätkatakse, nagu kõik oleks korras.
  tulemusena tekib ainult uusi exceptioneid, mis varjavad algset põhjust
- dis.close() ei ole finally plokis
 */

class PrintStackTraceLahendus implements Runnable {

  @Override
  public void run() {
    // try-with-resources sulgeb automaatselt vood
    try (FileInputStream fis = new FileInputStream("filename");
         DataInputStream dis = new DataInputStream(fis)) {
      String s = dis.readUTF();
      System.out.println(s);
    } catch (IOException e) {
      // peame erindi RuntimeExceptionisse mähkima, sest
      // run on liidese meetod, kuhu me ei saa throws
      // IOException lisada
      throw new RuntimeException(e);
    }
  }
}
