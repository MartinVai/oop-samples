public class LiigaÜldiseErindiPüüdmine {
  public static void main(String[] args) {
    try {
      Integer.parseInt(args[0]);
    } catch (Exception e) {
      throw new RuntimeException("vigane number");
    }
  }
}

/*
Bugid:
- püütakse liiga üldist erindit. peaks püüdma võimalikult
  täpset erinditüüpi, sest muidu võid kogemata ka valesi
  erindeid püüda. antud näide püüab NumberFormatException,
  kui sisestati vigane number, aga samuti ka
  ArrayIndexOutOfBoundsException, kui numbrit üldse ei
  sisestatud
- erind mähitakse RuntimeExceptionisse, mis on täiesti
  ebavajalik.
- erind mähitakse RuntimeExceptionisse, aga algset erindit
  ei "mähita kaasa". kui üldse mähkida, siis võiks kasutada
  sellist konstruktorit, kus on cause parameeter
 */

class LiigaÜldiseErindiPüüdmineLahendus {
  public static void main(String[] args) {
    try {
      Integer.parseInt(args[0]);
    } catch (NumberFormatException e) {
      throw new RuntimeException("vigane number", e);
    }
  }
}
