package fragma;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public class SecondFileContent extends FileOneContent {
 private Map < String, Integer > teamRunsMap = new ConcurrentHashMap < String, Integer > ();
 private Map < String, String > teamBoundaryMap = new ConcurrentHashMap < String, String > ();
 private Map < String, Integer > bowlerRunsMap = new ConcurrentHashMap < String, Integer > ();
 private Map < String, Integer > bowlerBowlsMap = new ConcurrentHashMap < String, Integer > ();
 private Map < String, Integer > bowlsFaced = new ConcurrentHashMap < String, Integer > ();
 private Map < String, Integer > runsGiven = new ConcurrentHashMap < String, Integer > ();
 private Map < String, Integer > ballsBowled = new ConcurrentHashMap < String, Integer > ();
 private Map < String, Double > netRunRate = new ConcurrentHashMap < String, Double > ();
 private Map < String, Double > economy = new ConcurrentHashMap < String, Double > ();
 private String line;
 private String fileName = "/Users/girishpaul/Documents/deliveries.csv";
 private FileInputStream file2;
 BufferedReader br;
 public SecondFileContent() {
  try {
   file2 = new FileInputStream(fileName);
   br = new BufferedReader(new InputStreamReader(file2));
   setYear();

  } catch (FileNotFoundException E) {
   E.printStackTrace();
  }
 }
 public void setRunsBoundary() {
  try {
   while ((line = br.readLine()) != null) {
    String fileContent2[] = line.split(",");
    if (teamRunsMap.containsKey(getYear().get(fileContent2[0]) + "_" + fileContent2[2]) && !"TOTAL_RUNS".equals(fileContent2[15])) {
     int add = (teamRunsMap.get(getYear().get(fileContent2[0]) + "_" + fileContent2[2])) + Integer.parseInt(fileContent2[15]);
     teamRunsMap.put(getYear().get(fileContent2[0]) + "_" + fileContent2[2], add);
     if (fileContent2[15].equals("4")) {
      String getFour = teamBoundaryMap.get(getYear().get(fileContent2[0]) + "_" + fileContent2[2]);
      String splitted[] = getFour.split(" ");
      int four = Integer.parseInt(splitted[0]) + 1;
      int six = Integer.parseInt(splitted[1]);
      teamBoundaryMap.put(getYear().get(fileContent2[0]) + "_" + fileContent2[2], four + " " + six);
     }

     if (fileContent2[15].equals("6")) {
      String getFour = teamBoundaryMap.get(getYear().get(fileContent2[0]) + "_" + fileContent2[2]);
      String splitted[] = getFour.split(" ");
      int four = Integer.parseInt(splitted[0]);
      int six = Integer.parseInt(splitted[1]) + 1;
      teamBoundaryMap.put(getYear().get(fileContent2[0]) + "_" + fileContent2[2], four + " " + six);
     }
    } else {
     if (!"TOTAL_RUNS".equals(fileContent2[15])) {
      teamRunsMap.put(getYear().get(fileContent2[0]) + "_" + fileContent2[2], Integer.parseInt(fileContent2[15]));
      if (fileContent2[15].equals("6")) {

       teamBoundaryMap.put(getYear().get(fileContent2[0]) + "_" + fileContent2[2], "0" + " " + "1");
      } else if (fileContent2[15].equals("6")) {

       teamBoundaryMap.put(getYear().get(fileContent2[0]) + "_" + fileContent2[2], "1" + " " + "0");
      } else
       teamBoundaryMap.put(getYear().get(fileContent2[0]) + "_" + fileContent2[2], "0" + " " + "0");
     }
    }

   }

  } catch (IOException E) {
   E.printStackTrace();
  }
 }
 public void setBowlerRunsBowls() {
  try {
   file2.getChannel().position(0);
   file2 = new FileInputStream(fileName);
   br = new BufferedReader(new InputStreamReader(file2));
   line = "";
   while ((line = br.readLine()) != null) {
    String fileContent2[] = line.split(",");
    if (bowlerRunsMap.containsKey(getYear().get(fileContent2[0]) + "_" + fileContent2[7]) && !"TOTAL_RUNS".equals(fileContent2[15])) {
     if (fileContent2[9].equals("0") && fileContent2[10].equals("0")) {
      bowlerRunsMap.put(getYear().get(fileContent2[0]) + "_" + fileContent2[7], bowlerRunsMap.get(getYear().get(fileContent2[0]) + "_" + fileContent2[7]) + Integer.parseInt(fileContent2[15]));
     }
     if (fileContent2[8].equalsIgnoreCase("0") && fileContent2[11].equalsIgnoreCase("0")) {
      bowlerBowlsMap.put(getYear().get(fileContent2[0]) + "_" + fileContent2[7], bowlerBowlsMap.get(getYear().get(fileContent2[0]) + "_" + fileContent2[7]) + 1);
     }
    } else {
     if (!"TOTAL_RUNS".equals(fileContent2[15])) {
      bowlerRunsMap.put(getYear().get(fileContent2[0]) + "_" + fileContent2[7], Integer.parseInt(fileContent2[15]));
      bowlerBowlsMap.put(getYear().get(fileContent2[0]) + "_" + fileContent2[7], 1);
     }
    }
   }

  } catch (FileNotFoundException E) {
   E.printStackTrace();
  } catch (IOException E) {
   E.printStackTrace();
  }
 }
 public void setEconomy() {
  setBowlerRunsBowls();
  for (Map.Entry < String, Integer > names: getBowlerBowls().entrySet()) {
   if (names.getValue() / 6 >= 10) {
    int totover = names.getValue() / 6;
    double avg = getBowlerRuns().get(names.getKey()) / (double) totover;
    economy.put(names.getKey(), (double)(Math.round(avg * 100.0) / 100.0));
   }
  }
 }
 public void setBowlsFaced() {
  try {
   file2.getChannel().position(0);
   file2 = new FileInputStream(fileName);
   br = new BufferedReader(new InputStreamReader(file2));
   line = "";
   while ((line = br.readLine()) != null) {
    String fileContent2[] = line.split(",");
    if (bowlsFaced.containsKey(getYear().get(fileContent2[0]) + "_" + fileContent2[2])) {
     if (fileContent2[8].equalsIgnoreCase("0") && fileContent2[11].equalsIgnoreCase("0"))
      bowlsFaced.put(getYear().get(fileContent2[0]) + "_" + fileContent2[2], bowlsFaced.get(getYear().get(fileContent2[0]) + "_" + fileContent2[2]) + 1);
    } else {
     if (!"SEASON".equals(getYear().get(fileContent2[0])) || !"BATTING_TEAM".equals(fileContent2[2]))
      bowlsFaced.put(getYear().get(fileContent2[0]) + "_" + fileContent2[2], 1);
    }
    if (runsGiven.containsKey(getYear().get(fileContent2[0]) + "_" + fileContent2[3]) && !"TOTAL_RUNS".contentEquals(fileContent2[15])) {
     runsGiven.put(getYear().get(fileContent2[0]) + "_" + fileContent2[3], runsGiven.get(getYear().get(fileContent2[0]) + "_" + fileContent2[3]) + Integer.parseInt(fileContent2[15]));
    } else {
     if (!"TOTAL_RUNS".contentEquals(fileContent2[15]))
      runsGiven.put(getYear().get(fileContent2[0]) + "_" + fileContent2[3], Integer.parseInt(fileContent2[15]));
    }
    if (ballsBowled.containsKey(getYear().get(fileContent2[0]) + "_" + fileContent2[3])) {
     if (fileContent2[8].equalsIgnoreCase("0") && fileContent2[11].equalsIgnoreCase("0"))
      ballsBowled.put(getYear().get(fileContent2[0]) + "_" + fileContent2[3], ballsBowled.get(getYear().get(fileContent2[0]) + "_" + fileContent2[3]) + 1);
    } else
     ballsBowled.put(getYear().get(fileContent2[0]) + "_" + fileContent2[3], 1);
   }
  } catch (FileNotFoundException E) {
   E.printStackTrace();
  } catch (IOException E) {
   E.printStackTrace();
  }
 }
 public void setNetRunRate() {
  setBowlsFaced();
  for (Map.Entry < String, Integer > name: bowlsFaced.entrySet()) {
   double nrr = (double)(teamRunsMap.get(name.getKey()) / (double)(name.getValue() / 6)) - (double)(runsGiven.get(name.getKey()) / (double)(ballsBowled.get(name.getKey()) / 6));
   netRunRate.put(name.getKey(), (double) Math.round(nrr * 100.0) / 100.0);
  }
 }
 public Map < String, Integer > getRunsBoundary() {
  return teamRunsMap;
 }
 public Map < String, String > getTeamBoundary() {
  return teamBoundaryMap;
 }
 public Map < String, Integer > getBowlerRuns() {
  return bowlerRunsMap;
 }
 public Map < String, Integer > getBowlerBowls() {
  return bowlerBowlsMap;
 }
 public Map < String, Integer > getBowlsFaced() {
  return bowlsFaced;
 }
 public Map < String, Double > getNetRunRate() {
  return netRunRate;
 }
 public Map < String, Double > getEconomy() {
  return economy;
 }
}