import java.io.PrintWriter;

public class FailiLogija {
  PrintWriter hoiatusteFail, andmeFail;

  FailiLogija(PrintWriter hoiatusteFail, PrintWriter andmeFail) {
    this.hoiatusteFail = hoiatusteFail;
    this.andmeFail = andmeFail;
  }

  void salvestaTeade(String teade, boolean ohtlikViga) {
    if (ohtlikViga) {
      hoiatusteFail.println(teade);
    } else {
      andmeFail.println(teade);
    }
  }
}
