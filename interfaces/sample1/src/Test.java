public class Test {
  public static void main(String[] args) {
    AmeerikaMäed mäed = new AmeerikaMäed();
    Dokument[] dokumendid = new Dokument[]{
        new IdKaart("39108071234"),
        new ÕpilasPilet(1991)
    };
    System.out.println("sobib: " + mäed.vanusedSobivad(dokumendid));
  }
}
