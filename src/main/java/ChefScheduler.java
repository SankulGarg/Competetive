import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

final public class ChefScheduler {
	public static boolean schedulable(HashMap<String, ArrayList<String>> requests) {
		System.out.println(requests);
		Map<String, List<String>> sorted = new LinkedHashMap<>();
		for (Map.Entry<String, ArrayList<String>> entry : requests.entrySet()) {
			Set<String> allDays = new HashSet<String>(Set.of("mon", "tue", "wed", "thu", "fri", "sat", "sun"));
			for (String day : entry.getValue()) {
				allDays.remove(day);
			}
			sorted.put(entry.getKey(), allDays.stream().collect(Collectors.toList()));

		}

		sorted = sorted.entrySet().stream().sorted(Comparator.comparingInt(e -> e.getValue().size()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> {
					throw new AssertionError();
				}, LinkedHashMap::new));

		System.out.println(sorted);
		Map<String, Integer> days = new HashMap<>();
		days.put("mon", 0);
		days.put("tue", 1);
		days.put("wed", 2);
		days.put("thu", 3);
		days.put("fri", 4);
		days.put("sat", 5);
		days.put("sun", 6);

		int[] chefCount = new int[7];

		for (Map.Entry<String, List<String>> entry : sorted.entrySet()) {
			int employeeShiftCount = 0;

			for (String day : entry.getValue()) {
				if (days.size() == 0)
					return true;
				if (!days.containsKey(day))
					continue;
				if (employeeShiftCount >= 5)
					break;
				chefCount[days.get(day)]++;
				employeeShiftCount++;
				if (chefCount[days.get(day)] == 2)
					days.remove(day);
			}

		}
		System.out.println(Arrays.toString(chefCount));
		System.err.println(days);
		return days.size() == 0;
	}

	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> requests = new HashMap<>();
		requests.put("ada", new ArrayList<>(Arrays.asList(new String[] { "mon", "tue", "wed", "fri", "sat", "sun" })));
		requests.put("emma", new ArrayList<>(Arrays.asList(new String[] { "mon", "tue", "wed", "thu", "sun" })));
		requests.put("remy", new ArrayList<>(Arrays.asList(new String[] { "mon", "thu", "fri", "sat" })));
		requests.put("zach", new ArrayList<>(Arrays.asList(new String[] {})));
		ChefScheduler.schedulable(requests);
	}
}