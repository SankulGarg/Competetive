package mmt;

import java.util.HashSet;
import java.util.Set;

public class Test {
	/**
	 * sfdghjmsndnfagfhsffdsghgf
	 * 
	 */

	int findLength(String str) {
		return str.length();
	}

	int uniqueChracters(String str) {
		Set<Character> chracterSet = new HashSet<>();

		for (char c : str.toCharArray())
			chracterSet.add(c);

		return chracterSet.size();
	}

	void printPermutations(String str, Set<Character> visited, String permutation) {
		if (permutation.length() == str.length())
			System.out.println(permutation);

		for (int i = 0; i < str.length(); i++) {
			if (!visited.contains(str.charAt(i))) {
				visited.add(str.charAt(i));
				printPermutations(str, visited, permutation + str.charAt(i));
				visited.remove(str.charAt(i));

			}
		}
	}

	public static void main(String[] args) {
		// System.out.println( new Test().findLength("sfdghjmsndnfagfhsffdsghgf"));
		new Test().printPermutations("SANKUL", new HashSet<>(), "");

		// System.out.println( new Test().uniqueChracters("sfdghjmsndnfagfhsffdsghgf"));

	}
}
