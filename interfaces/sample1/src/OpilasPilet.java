import java.time.LocalDate;

public class OpilasPilet implements Dokument {
  int sunniaasta;

  OpilasPilet(int sunniaasta) {
    this.sunniaasta = sunniaasta;
  }

  public boolean onVahemalt12Aastane() {
    return sunniaasta + 12 <= LocalDate.now().getYear();
  }
}
