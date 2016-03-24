import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PuuduvFinally implements Runnable {

  @Override
  public void run() {
    try {
      DataInputStream in = new DataInputStream(
          new FileInputStream("sisend.bin"));
      DataOutputStream out = new DataOutputStream(
          new FileOutputStream("väljund.bin"));
      String value = in.readUTF();
      out.writeUTF(value);
      in.close();
      out.close();
    } catch (IOException e) { //
    }
  }
}

/*
Bugid:
- erind püütakse kinni, aga ei tehta korda.
  ära püüa, kui ei oska korda teha!
- vooge ei suleta, kui erind tekib
 */

class PuuduvFinallyLahendus implements Runnable {

  @Override
  public void run() {
    try (DataInputStream in = new DataInputStream(new FileInputStream("sisend.bin"));
         DataOutputStream out = new DataOutputStream(new FileOutputStream("väljund.bin"))) {
      String value = in.readUTF();
      out.writeUTF(value);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
