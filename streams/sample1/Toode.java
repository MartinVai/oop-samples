import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Toode {
  String nimi;
  double kogus;
  double tükiHind;

  Toode(String nimi, double kogus, double tükiHind) {
    this.nimi = nimi;
    this.kogus = kogus;
    this.tükiHind = tükiHind;
  }

  void salvesta(DataOutputStream dos) throws Exception {
    dos.writeUTF(nimi);
    dos.writeDouble(kogus);
    dos.writeDouble(tükiHind);
  }

  static Toode laadi(DataInputStream dis) throws Exception {
    String nimi = dis.readUTF();
    double kogus = dis.readDouble();
    double tükiHind = dis.readDouble();
    return new Toode(nimi, kogus, tükiHind);
  }
}
