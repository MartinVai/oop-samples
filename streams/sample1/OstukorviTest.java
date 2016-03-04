import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class OstukorviTest {
  public static void main(String[] args) throws Exception {
    Toode shokolaad = new Toode("shokolaad", 1.0, 1.29);
    Toode apelsin = new Toode("apelsin", 2.5, 0.89);
    Ostukorv ostukorv = new Ostukorv("Ats", Arrays.asList(shokolaad, apelsin));

    DataOutputStream dos = new DataOutputStream(new FileOutputStream("andmed.bin"));
    ostukorv.salvesta(dos);
    dos.close();

    DataInputStream dis = new DataInputStream(new FileInputStream("andmed.bin"));
    Ostukorv sisseLaetud = Ostukorv.laadi(dis); // samad andmed, mis algses
    dis.close();
  }
}
