import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Harman {

	class sankul{
		String key;
	}
	
	/*
	 * arr1[] = -1,0,1,2,-1,-412:40 output = [[-1,-1,2],[-1,0,1]]
	 */

	List<List<Integer>> sumToZero(int[] data) {

		if (data == null || data.length < 3)
			return Collections.emptyList();

		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < data.length; i++) {
			indexMap.put(data[i], i);
		}
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 1; i < data.length - 1; i++) {
			for (int j = 0; j < i; j++) {
				int sum = -1 * (data[i] + data[j]);
				if (indexMap.containsKey(sum) && indexMap.get(sum) > i) {

					List<Integer> res = new ArrayList<>();
					res.add(data[i]);
					res.add(data[j]);
					res.add(sum);
					result.add(res);

				}

			}
		}

		return result;

	}
	public static void main(String[] args) {
		System.out.println(new Harman().sumToZero(new int [] {-1,0,1,2,-1,-4}));
	}

}
