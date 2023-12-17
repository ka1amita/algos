package src.codewars;

import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DuplicatesEverywhere {
  public static void main(String[] args) {
    // Map<Integer, List<String>> res = new HashMap<>();
    // List<String> empty = new ArrayList<>();
    // res.put(534, empty);
    // System.out.println(res);

    Map<Integer, List<String>> input = new HashMap<>();
    input.put(1, new ArrayList<>());
    input.put(2, List.of("A", "B"));
    input.put(3, List.of("A", "B"));

    System.out.println(solve(input));
    System.out.println(removeDuplicateIds(input));
  }

  public static Map<Integer, List<String>> removeDuplicateIds(Map<Integer, List<String>> obj) {
    var seen = new HashSet<>();
    return obj.entrySet()
              .stream()
              .sorted(Map.Entry.<Integer, List<String>>comparingByKey()
                               .reversed())
              .collect(toMap(Map.Entry::getKey,
                             e -> e.getValue()
                                   .stream()
                                   .filter(seen::add)
                                   .toList()
                            ));
  }

  public static Map<Integer, List<String>> solve(Map<Integer, List<String>> input) {
    // for each key from biggest to smallest
    // for each element in corresponding values
    // add to set of encountered values
    // if in encountered values set
    // remove
    // else keep

    Set<String> encounteredValues = new HashSet<>();
    Map<Integer, List<String>> result = new HashMap<>();
    for (Integer key : input.keySet()
                            .stream()
                            .sorted((a, b) -> -Integer.compare(a, b))
                            .toList()) {
      List<String> filteredLetters = new ArrayList<>();
      for (String letter : input.get(key)) {
        if (encounteredValues.add(letter)) { // returns the same as !set.contains(value)
          filteredLetters.add(letter);
        }
      }
      result.put(key, filteredLetters);
    }
    return result;
  }
}
