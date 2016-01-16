import java.time.LocalDate;

public class ÕpilasPilet implements Dokument {
  int sünniaasta;

  ÕpilasPilet(int sünniaasta) {
    this.sünniaasta = sünniaasta;
  }

  public boolean onVähemalt12Aastane() {
    return sünniaasta + 12 <= LocalDate.now().getYear();
  }
}
