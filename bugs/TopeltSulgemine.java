import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class TopeltSulgemine {
  public static void main(String[] args) throws Exception {
    FileOutputStream fileStream = new FileOutputStream("sisend.bin");
    OutputStreamWriter streamWriter = new OutputStreamWriter(fileStream, "UTF-8");
    BufferedWriter bufferedWriter = new BufferedWriter(streamWriter);

    bufferedWriter.write("hello world!");

    fileStream.close();
    streamWriter.close();
    bufferedWriter.close();
  }
}

/*
Bugid:
- vooge ei suleta, kui erind tekib
- ühte voogu sulgetakse mitu korda (mõttetu, aga mitte kahjulik)
- fileStream suletakse enne bufferedWriterit.
  kui bufferedWriter tahab sulgemise käigus veel midagi kirjutada (nt
  oma puhvri sisu), siis see pole võimalik. alati peaks välimise voo
  enne sulgema

Lisainfo:
Paljud vood mähivad teisi voogusi (antud juhul BufferedWriter mähib
OutputStreamWriter). Kõige välimise voo (see, mis teisi mähib) sulgemine
peaks alati sulgema ka kõik mähitud vood. BufferedWriter sulgemine sulgeks
automaatselt ka OutputStreamWriter. Selle sulgemine omakorda sulgeks
FileOutputStream. Seega tegelikult ongi vaja ainult BufferedWriter sulgeda.
 */

class TopeltSulgemineLahendus {
  public static void main(String[] args) throws Exception {
    try (BufferedWriter bufferedWriter = new BufferedWriter(
        new OutputStreamWriter(
            new FileOutputStream("sisend.bin"), "UTF-8"))) {

      bufferedWriter.write("hello world!");
    }
  }
}
