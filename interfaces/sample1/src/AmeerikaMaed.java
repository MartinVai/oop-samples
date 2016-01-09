class AmeerikaMaed {
  boolean vanusedSobivad(Dokument[] dokumendid) {
    for (Dokument dokument : dokumendid) {
      if (!dokument.onVahemalt12Aastane())
        return false;
    }
    return true;
  }
}
