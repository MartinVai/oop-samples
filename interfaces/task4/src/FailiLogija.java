import java.io.PrintWriter;

public class FailiLogija {
  private PrintWriter logiFail;

  FailiLogija(PrintWriter logiFail) {
    this.logiFail = logiFail;
  }

  void logiFaili(String teade) {
    logiFail.println(teade);
    logiFail.flush(); // kirjuta kohe faili
  }
}
