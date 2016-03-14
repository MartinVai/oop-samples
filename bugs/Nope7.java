import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Nope7 {

  public static void main(String[] args) throws Exception {
    Socket socket = new Socket(InetAddress.getLocalHost(), 1337);
    try (InputStream in = socket.getInputStream();
         OutputStream out = socket.getOutputStream()) {
      // do stuff
      socket.close();
    } catch (IOException e) {
    }
  }
}
