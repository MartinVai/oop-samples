import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Ostukorv {
  private String klient;
  private List<Toode> tooted;

  Ostukorv(String klient, List<Toode> tooted) {
    this.klient = klient;
    this.tooted = tooted;
  }

  void salvesta(DataOutputStream dos) throws Exception {
    dos.writeUTF(klient);
    dos.writeInt(tooted.size());
    for (Toode toode : tooted) {
      toode.salvesta(dos);
    }
  }

  static Ostukorv laadi(DataInputStream dis) throws Exception {
    String klient = dis.readUTF();
    List<Toode> tooted = new ArrayList<>();
    int tooteid = dis.readInt();
    for (int i = 0; i < tooteid; i++) {
      tooted.add(Toode.laadi(dis));
    }
    return new Ostukorv(klient, tooted);
  }
}
