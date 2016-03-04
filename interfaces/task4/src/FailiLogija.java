import java.io.PrintWriter;

public class FailiLogija {
  private PrintWriter logiFail;

  public FailiLogija(PrintWriter logiFail) {
    this.logiFail = logiFail;
  }

  public void logiFaili(String teade) {
    logiFail.println(teade);
    logiFail.flush(); // kirjuta kohe faili
  }
}
