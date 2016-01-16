public class Test {
  public static void main(String[] args) {
    IdKaart[] idKaardid = new IdKaart[]{
        new IdKaart("39108071234")
    };
    ÕpilasPilet[] õpilasPiletid = new ÕpilasPilet[]{
        new ÕpilasPilet(2001)
    };

    AmeerikaMäed ameerikaMäed = new AmeerikaMäed();
    System.out.println(ameerikaMäed.vanusedSobivad(idKaardid, õpilasPiletid));
  }
}

