public class Nope6 {
  public static void main(String[] args) {
    try {
      Integer.parseInt(args[0]);
    } catch (Exception e) {
      throw new RuntimeException("vigane number");
    }
  }
}
