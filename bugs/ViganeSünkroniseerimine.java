import java.util.List;

public class ViganeSünkroniseerimine implements Runnable {
  private List<String> data;
  private String valueToAdd;

  public ViganeSünkroniseerimine(List<String> data, String valueToAdd) {
    this.data = data;
    this.valueToAdd = valueToAdd;
  }

  @Override
  public void run() {
    if (!data.contains(valueToAdd)) {
      synchronized (data) {
        data.add(valueToAdd);
      }
    }
  }
}

/*
Bugi:
Kõik kohad, mis data fieldi kasutavad, ei ole sünkroniseeritud.
Sünkroniseerima ei pea ainult andmeid muutvaid käske, vaid alati ka
andmeid lugevad käsud. Antud juhul saavad kaks lõime listi sama
väärtuse lisada. Õnnetu ajastuse korral saab nii juhtuda:
Thread1: data.contains(value) -> false
Thread2: data.contains(value) -> false
Thread2: data.add(value) -> lisati esimest korda
Thread1: data.add(value) -> lisati teist korda
 */

class ViganeSünkroniseerimineLahendus implements Runnable {
  private List<String> data;
  private String valueToAdd;

  public ViganeSünkroniseerimineLahendus(List<String> data, String valueToAdd) {
    this.data = data;
    this.valueToAdd = valueToAdd;
  }

  @Override
  public void run() {
    // sünkroniseerima peab ka kõigis teistes
    // kohtades, kus seda listi kasutatakse!
    synchronized (data) {
      if (!data.contains(valueToAdd)) {
        data.add(valueToAdd);
      }
    }
  }
}
