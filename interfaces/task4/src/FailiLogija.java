import java.io.PrintWriter;

public class FailiLogija {
  PrintWriter vigadeFail, teadeteFail;

  FailiLogija(PrintWriter vigadeFail, PrintWriter teadeteFail) {
    this.vigadeFail = vigadeFail;
    this.teadeteFail = teadeteFail;
  }

  void salvestaTeade(String teade, boolean ohtlikViga) {
    if (ohtlikViga) {
      vigadeFail.println(teade);
    } else {
      teadeteFail.println(teade);
    }
  }
}
