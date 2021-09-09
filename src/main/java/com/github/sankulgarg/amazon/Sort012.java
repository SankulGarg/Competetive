package com.github.sankulgarg.amazon;

public class Sort012 {

	void sort012(int a[], int n) {

		int count0 = 0;
		int count1 = 0;
		int count2 = 0;

		for (int num : a) {
			if (num == 0)
				count0++;
			else if (num == 1)
				count1++;
			else
				count2++;
		}

		int ind = 0;
		while (count0 > 0) {
			a[ind] = 0;
			ind++;
			count0--;
		}

		while (count1 > 0) {
			a[ind] = 1;
			ind++;
			count1--;
		}

		while (count2 > 0) {
			a[ind] = 2;
			ind++;
			count2--;
		}
	}

}
