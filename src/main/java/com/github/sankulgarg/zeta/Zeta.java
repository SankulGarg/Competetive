package com.github.sankulgarg.zeta;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Zeta {
	/*
	 * ATM
	 * 
	 * input amount to be dispensed
	 * 
	 * denomination show print notes to be dispensed balance
	 * 
	 * negative] 9700 can not be dispensed, only 500 and 2000 available
	 * 
	 * 
	 */

	ATM atm;

	void dispenseAmount(int amount) {

		if (atm.getBalance() < amount) {
			System.out.println("insufficientBAlance");
			return;
		}
		Map<Integer, Integer> notesUsed = new HashMap<>();

		PriorityQueue<int[]> atmQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		
		for (Map.Entry<Integer, Integer> entry : atm.getNotesCount().entrySet()) {

			atmQueue.add(new int[] { entry.getKey(), entry.getValue() });
		}

		while (amount != 0 && !atmQueue.isEmpty()) {
			int note[] = atmQueue.peek();
			if (note[0] > amount || note[1] <= 0)
				atmQueue.poll();
			else {
				amount -= note[0];
				notesUsed.computeIfAbsent(note[0], a -> 0);
				notesUsed.put(note[0], notesUsed.get(note[0]) + 1);
				note[1]--;

			}

		}

		if (amount == 0) {
			for (Map.Entry<Integer, Integer> entry : notesUsed.entrySet()) {
				atm.getNotesCount().put(entry.getKey(), atm.getNotesCount().get(entry.getKey()) - entry.getValue());
				atm.updateBalance(-1 * (entry.getKey() * entry.getValue()));

			}
			System.out.println(notesUsed.entrySet());
			System.out.println("available denomination:" + atm.getNotesCount().entrySet());
		} else {
			System.out.println("Not Successfull available denomination:" + atm.getNotesCount().entrySet());
		}

	}

	public static void main(String[] args) {
		Zeta zeta = new Zeta();
		Map<Integer, Integer> atmDATA = new HashMap<>();
		atmDATA.put(100, 5);
		atmDATA.put(200, 5);
		atmDATA.put(500, 5);
		atmDATA.put(2000, 10);
		
		zeta.atm = new ATM(atmDATA);
		zeta.dispenseAmount(9500);
		System.out.println("-------------");
		zeta.dispenseAmount(9700);
		System.out.println("-------------");
		zeta.dispenseAmount(4800);

	}
}
