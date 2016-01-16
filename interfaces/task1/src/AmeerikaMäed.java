public class AmeerikaMäed {
  boolean vanusedSobivad(IdKaart[] idKaardid, ÕpilasPilet[] õpilasPiletid) {
    for (IdKaart id : idKaardid) {
      if (!id.onVähemalt12Aastane())
        return false;
    }
    for (ÕpilasPilet pilet : õpilasPiletid) {
      if (!pilet.onVähemalt12Aastane())
        return false;
    }
    return true;
  }
}
