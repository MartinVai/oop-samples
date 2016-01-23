import java.time.LocalDate;

public class Õpilaspilet implements Dokument {
  int sünniaasta;

  Õpilaspilet(int sünniaasta) {
    this.sünniaasta = sünniaasta;
  }

  public boolean onVähemalt12Aastane() {
    return sünniaasta + 12 <= LocalDate.now().getYear();
  }
}
