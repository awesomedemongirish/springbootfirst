package fragma;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
public class SortAndDisplay {
 private int count = 0;
 public Map < String, Integer > sort(Map < String, Integer > map, int i, String compare) {
  Map < String, Integer > sorted = new ConcurrentHashMap < String, Integer > ();
  if (compare.equalsIgnoreCase("value")) {
   sorted = map.entrySet()
    .stream()
    .sorted(Collections.reverseOrder(ConcurrentHashMap.Entry.comparingByValue()))
    .collect(Collectors.toMap(ConcurrentHashMap.Entry::getKey, ConcurrentHashMap.Entry::getValue, (e1, e2) -> e2,
     LinkedHashMap::new));
  } else {
   sorted = map.entrySet()
    .stream()
    .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
     LinkedHashMap::new));
  }
  return sorted;
 }
 public Map < String, Double > sort(Map < String, Double > toBeSorted, double d, String compare) {
  Map < String, Double > sorted = new ConcurrentHashMap < String, Double > ();
  if (compare.equalsIgnoreCase("value")) {
   sorted = toBeSorted.entrySet() //Sorting to get the top 10 bowlers
    .stream()
    .sorted((Map.Entry.comparingByValue()))
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
     LinkedHashMap::new));
  } else {
   sorted = toBeSorted.entrySet() //Sorting to get the top 10 bowlers
    .stream()
    .sorted((Map.Entry.comparingByKey()))
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
     LinkedHashMap::new));
  }
  return sorted;
 }
 public void displayFieldFirst(Map < String, Integer > toBeDisplayed, int limit) {
  System.out.println("Top 4 teams which elected to field first after winning toss in the year 2016 and 2017.");
  System.out.println("--------------------------------------------------------------------------------------");
  System.out.format("%5s %10s %10s", "Year", "Team", "Count" + "\n\n");
  for (ConcurrentHashMap.Entry < String, Integer > name: toBeDisplayed.entrySet()) {
   if (count == limit)
    break;
   else {
    String yearTeam[] = name.getKey().split(" ");
    System.out.format("%5s %10s %10s", yearTeam[0], yearTeam[1], name.getValue() + "\n\n");
    count++;
   }
  }
  System.out.println();
  count = 0;
 }
 public void displayRunFourSixes(Map < String, Integer > map, SecondFileContent sfc) {
  System.out.println("Total Number of Four Sixes and runs With respect to team and year");
  System.out.println("-----------------------------------------------------------------");
  System.out.format("%5s %30s %8s %8s %10s", "Year", "Team", "Fours", "Sixes", "  Total Score\n\n");
  for (Map.Entry < String, Integer > name: map.entrySet()) {
   String splitedTeam[] = name.getKey().split("_");
   String getteam = splitedTeam[1];
   String splitedFours[] = sfc.getTeamBoundary().get(name.getKey()).split(" ");
   System.out.format("%5s %30s %8s %8s %10s", splitedTeam[0], getteam, splitedFours[0], splitedFours[1], name.getValue() + "\n");
   System.out.println();
  }
 }
 public void dislplayEconomy(Map < String, Double > map, int limit) {
  System.out.println("Top 10 bowlers with best economy rates according to years");
  System.out.println("----------------------------------------------------------");
  System.out.format("%1s %17s %15s", "Year", "Bowler", "Economy rate" + "\n\n");
  for (Map.Entry < String, Double > names: map.entrySet()) {
   if (count == 10)
    break;
   else {
    String splittedTeams[] = names.getKey().split("_");
    System.out.format("%1s %20s %10s", splittedTeams[0], splittedTeams[1], names.getValue() + "\n\n");
    count++;
   }
  }
 }
 public void displayNetRunRate(Map < String, Double > map) {
  System.out.println();
  System.out.println("Net runrates of teams with respect to years");
  System.out.println("--------------------------------------------");
  System.out.format("%5s %19s %20s", "Year", "Team", "NRR" + "\n\n");
  for (ConcurrentHashMap.Entry < String, Double > name: map.entrySet()) {
   String splited[] = name.getKey().split("_");
   System.out.format("%5s %30s %10s", splited[0], splited[1], name.getValue() + "\n\n");
  }
 }
}