package com.github.sankulgarg.zeta;

import java.util.Map;

public class ATM {

	Map<Integer, Integer> notesCount;
	int balance = 0;

	public ATM(Map<Integer, Integer> notesCount) {
		super();
		this.notesCount = notesCount;

		for (Map.Entry<Integer, Integer> entry : notesCount.entrySet())
			this.balance += entry.getKey() * entry.getValue();
	}

	public Map<Integer, Integer> getNotesCount() {
		return notesCount;
	}

	public int getBalance() {
		return balance;
	}

	public void updateBalance(int amount) {
		balance += amount;
	}

}
