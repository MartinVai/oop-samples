import java.time.LocalDate;

public class OpilasPilet {
  int sunniaasta;

  OpilasPilet(int sunniaasta) {
    this.sunniaasta = sunniaasta;
  }

  boolean onVahemalt12Aastane() {
    return sunniaasta + 12 <= LocalDate.now().getYear();
  }
}
