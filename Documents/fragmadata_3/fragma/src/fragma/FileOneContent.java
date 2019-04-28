package fragma;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public class FileOneContent {
 private Map < String, Integer > ma = new ConcurrentHashMap < String, Integer > ();
 private Map < String, String > year = new ConcurrentHashMap < String, String > ();
 private String line;
 private String line2;
 BufferedReader br;
 BufferedReader br2;
 public FileOneContent() {
  try {
   File file1 = new File("/Users/girishpaul/Documents/matches.csv");
   br = new BufferedReader(new FileReader(file1));
   br2 = new BufferedReader(new FileReader(file1));
  } catch (FileNotFoundException E) {
   E.printStackTrace();
  }
 }
 public void setYear() {
  try {
   while ((line = br.readLine()) != null) {
    String file1Content[] = line.split(",");
    year.put(file1Content[0], file1Content[1]);
   }
   br.close();
  } catch (IOException e) {
   e.printStackTrace();
  }
 }
 public void setFieldFirst() {
  try {
   while ((line2 = br2.readLine()) != null) {
    String file1Content[] = line2.split(",");
    if ((file1Content[1].equals("2017") || file1Content[1].equals("2016")) && file1Content[7].equalsIgnoreCase("field")) {
     if (ma.containsKey(file1Content[1] + " " + file1Content[6])) {
      int count = ma.get(file1Content[1] + " " + file1Content[6]);
      ma.put(file1Content[1] + " " + file1Content[6], count + 1);
     } else {
      ma.put(file1Content[1] + " " + file1Content[6], 1);
     }

    }
   }
   br2.close();
  } catch (IOException e) {
   e.printStackTrace();
  }
 }
 public Map < String, Integer > getFieldFirst() {
  return ma;
 }
 public Map < String, String > getYear() {
  return this.year;
 }
}