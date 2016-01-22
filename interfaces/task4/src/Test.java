import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class Test {
  public static void main(String[] args) throws Exception {
    Logija logija;
    // args on käsurea argumendid
    if (args.length == 1 && args[0].equals("kirjuta-faili")) {
      logija = new FailiLogija(
          new PrintWriter("hoiatused.txt"),
          new PrintWriter("andmed.txt"));
    } else {
      logija = new KäsureaLogija();
    }

    KütuseMõõtja mõõtja = new KütuseMõõtja(logija);
    List<Vagun> vagunid = Arrays.asList(
        new Vagun(33),
        new Vagun(5));
    for (Vagun vagun : vagunid) {
      mõõtja.mõõdaKütust(vagun);
    }
  }
}
