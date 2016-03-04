import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Toode {
  private String nimi;
  private double kogus;
  private double tükiHind;

  public Toode(String nimi, double kogus, double tükiHind) {
    this.nimi = nimi;
    this.kogus = kogus;
    this.tükiHind = tükiHind;
  }

  public void salvesta(DataOutputStream dos) throws Exception {
    dos.writeUTF(nimi);
    dos.writeDouble(kogus);
    dos.writeDouble(tükiHind);
  }

  public static Toode laadi(DataInputStream dis) throws Exception {
    String nimi = dis.readUTF();
    double kogus = dis.readDouble();
    double tükiHind = dis.readDouble();
    return new Toode(nimi, kogus, tükiHind);
  }
}
