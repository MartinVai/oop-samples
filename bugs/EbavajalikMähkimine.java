import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EbavajalikMähkimine {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(new File("minufail.txt"))) {
      System.out.println(scanner.nextLine());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

/*
Bugi:
Erindite RuntimeExceptionisse mähkimist peaks kasutama ​ainult
siis​, kui meetodi signatuuris ei saa seda exceptionit deklareerida,
nt interface meetodites, mille signatuuri te ei saa muuta (eelkõige
Runnable). igal pool mujal peaks meetodi signatuuri kirjutama throws
MingiCheckedException.

Wrappimist peaks proovima vältida ja ainult viimases hädas kasutama,
sest see peidab exceptioni tegeliku tüübi ära. antud juhul meetodi kutsuja
ei saa enam püüda IOException, ta saab püüda ainult väga üldise
RuntimeException. samas püüdma peaks alati võimalikult täpse exceptioni
ja ainult siis, kui sa oskad sellega midagi mõistlikku teha. seetõttu
on täpse tüübi peitmine väga halb.
 */

class EbavajalikMähkimineLahendus {
  public static void main(String[] args) throws Exception {
    try (Scanner scanner = new Scanner(new File("minufail.txt"))) {
      System.out.println(scanner.nextLine());
    }
  }
}
