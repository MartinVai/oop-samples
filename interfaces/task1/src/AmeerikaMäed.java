public class AmeerikaMäed {
  boolean vanusedSobivad(IdKaart[] idKaardid, Õpilaspilet[] õpilaspiletid) {
    for (IdKaart id : idKaardid) {
      if (!id.onVähemalt12Aastane())
        return false;
    }
    for (Õpilaspilet pilet : õpilaspiletid) {
      if (!pilet.onVähemalt12Aastane())
        return false;
    }
    return true;
  }
}
