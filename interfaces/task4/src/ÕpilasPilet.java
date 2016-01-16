import java.time.LocalDate;

public class ÕpilasPilet {
  int sünniaasta;

  ÕpilasPilet(int sünniaasta) {
    this.sünniaasta = sünniaasta;
  }

  boolean onVähemalt12Aastane() {
    return sünniaasta + 12 <= LocalDate.now().getYear();
  }
}
