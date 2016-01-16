import java.io.PrintWriter;

public class Test {
  public static void main(String[] args) throws Exception {
    Logija logija;
    if (args.length == 1 && args[0].equals("fail")) { // args on käsurea argumendid
      logija = new FailiLogija(
          new PrintWriter("vead.txt"),
          new PrintWriter("teated.txt"));
    } else {
      logija = new KäsureaLogija();
    }
    new AmeerikaMäed(logija).alustaSõitu();
  }
}
