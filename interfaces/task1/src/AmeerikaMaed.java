public class AmeerikaMaed {
  boolean vanusedSobivad(IdKaart[] idKaardid, OpilasPilet[] opilasPiletid) {
    for (IdKaart id : idKaardid) {
      if (!id.onVahemalt12Aastane())
        return false;
    }
    for (OpilasPilet pilet : opilasPiletid) {
      if (!pilet.onVahemalt12Aastane())
        return false;
    }
    return true;
  }
}
