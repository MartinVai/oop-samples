public class Test {
  public static void main(String[] args) {
    IdKaart[] idKaardid = { new IdKaart("39108071234") };
    Õpilaspilet[] õpilaspiletid = { new Õpilaspilet(2001) };

    AmeerikaMäed ameerikaMäed = new AmeerikaMäed();
    System.out.println(ameerikaMäed.vanusedSobivad(idKaardid, õpilaspiletid));
  }
}

