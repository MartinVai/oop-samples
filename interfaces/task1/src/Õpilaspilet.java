import java.time.LocalDate;

public class Õpilaspilet {
  int sünniaasta;

  Õpilaspilet(int sünniaasta) {
    this.sünniaasta = sünniaasta;
  }

  boolean onVähemalt12Aastane() {
    return sünniaasta + 12 <= LocalDate.now().getYear();
  }
}
