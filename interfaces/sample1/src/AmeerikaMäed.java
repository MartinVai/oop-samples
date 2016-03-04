public class AmeerikaMäed {
  public boolean vanusedSobivad(Dokument[] dokumendid) {
    for (Dokument dokument : dokumendid) {
      if (!dokument.onVähemalt12Aastane())
        return false;
    }
    return true;
  }
}
