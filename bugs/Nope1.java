import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Nope1 implements Runnable {

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
