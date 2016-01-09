public class Test {
  public static void main(String[] args) {
    AmeerikaMaed maed = new AmeerikaMaed();
    Dokument[] dokumendid = new Dokument[]{
        new IdKaart("39108071234"),
        new OpilasPilet(1991)
    };
    System.out.println("sobib: " + maed.vanusedSobivad(dokumendid));
  }
}
