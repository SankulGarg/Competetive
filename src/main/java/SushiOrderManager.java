import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

class SushiOrderManager {
	List<TreeMap<Integer, List<SushiItem>>> queueList = null;
	int queueCouter = 0;
	int lastSeatServed = 0;

	public SushiOrderManager() {
		queueList = new LinkedList<>();

	}

	public void addOrder(ArrayList<SushiOrder> request) {
		TreeMap<Integer, List<SushiItem>> queue = new TreeMap<>();
		for (SushiOrder order : request) {
			if (!queue.containsKey(order.getSeatId())) {
				queue.put(order.getSeatId(), getListOfSushiItems(order));
			} else {
				queue.get(order.getSeatId()).addAll(getListOfSushiItems(order));
			}

		}
		queueList.add(queue);

	}

	public SushiItem nextItem() {

		if (queueList.isEmpty())
			return null;
		queueCouter%=queueList.size();
		TreeMap<Integer, List<SushiItem>> queue = queueList.get(queueCouter);

		if (queue.isEmpty()) {
			queueList.remove(queueCouter);
			return nextItem();
		}
		lastSeatServed++;
		try {
			Entry<Integer, List<SushiItem>> next = queue.ceilingEntry(lastSeatServed);
			lastSeatServed = next.getKey();
			SushiItem sushiItem = next.getValue().remove(0);
			if (next.getValue().isEmpty()) {
				queue.remove(lastSeatServed);
			}
			return sushiItem;
		} catch (NullPointerException e) {
			lastSeatServed=0;
			queueCouter++;
			return nextItem();
		}

	}

	private List<SushiItem> getListOfSushiItems(SushiOrder sushiOrder) {
		return sushiOrder.getMenuItemIds().stream().map(item -> new SushiItem(sushiOrder.getSeatId(), item))
				.collect(Collectors.toList());
	}

	
	class SushiItem {
		private int seatId;
		private String menuItemId;

		public SushiItem(int seatId, String menuItemId) {
			this.seatId = seatId;
			this.menuItemId = menuItemId;
		}

		public int getSeatId() {
			return seatId;
		}

		public String getMenuItemId() {
			return menuItemId;
		}

	}

	class SushiOrder {
		private int seatId;
		private List<String> menuItemIds;

		public SushiOrder(int seatId, List<String> menuItemIds) {
			this.seatId = seatId;
			this.menuItemIds = menuItemIds;
		}

		public int getSeatId() {
			return seatId;
		}

		public List<String> getMenuItemIds() {
			return menuItemIds;
		}
	}
}