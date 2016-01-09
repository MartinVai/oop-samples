public class Test {
  public static void main(String[] args) {
    IdKaart[] idKaardid = new IdKaart[]{
        new IdKaart("39108071234")
    };
    OpilasPilet[] opilasPiletid = new OpilasPilet[]{
        new OpilasPilet(2001)
    };

    AmeerikaMaed ameerikaMaed = new AmeerikaMaed();
    System.out.println(ameerikaMaed.vanusedSobivad(idKaardid, opilasPiletid));
  }
}

