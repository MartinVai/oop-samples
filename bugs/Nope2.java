import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Nope2 implements Runnable {

  Socket socket;

  @Override
  public void run() {
    try {
      DataInputStream in = new DataInputStream(
          socket.getInputStream());
      DataOutputStream out = new DataOutputStream(
          socket.getOutputStream());
      String value = in.readUTF();
      out.writeUTF(value);
      in.close();
      out.close();
    } catch (IOException e) { //
    }
  }
}
