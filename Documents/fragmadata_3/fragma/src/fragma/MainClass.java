package fragma;
public class MainClass {
 public static void main(String[] args) {
  final FileOneContent foc = new FileOneContent();
  foc.setYear();
  foc.setFieldFirst();
  final SortAndDisplay sad = new SortAndDisplay();
  sad.displayFieldFirst(sad.sort(foc.getFieldFirst(), 1, "value"), 4);
  final SecondFileContent sfc = new SecondFileContent();
  sfc.setRunsBoundary();
  sad.displayRunFourSixes(sad.sort(sfc.getRunsBoundary(), 1, "key"), sfc);
  sfc.setEconomy();
  sad.dislplayEconomy(sad.sort(sfc.getEconomy(), 1.0, "Value"), 10);
  sfc.setNetRunRate();
  sad.displayNetRunRate(sad.sort(sfc.getNetRunRate(), 1.0, "Key"));

 }
}