import java.util.PriorityQueue;

class MedianFinder {

	/** initialize your data structure here. */
	PriorityQueue<Integer> smaller = null;
	PriorityQueue<Integer> greater = null;
	double median = 0.0d;

	public MedianFinder() {
		smaller = new PriorityQueue<>((a, b) -> b - a);
		greater = new PriorityQueue<>();

	}

	public void addNum(int num) {
		if (smaller.size() > greater.size()) {
			if (num < median) {
				int temp = smaller.poll();
				greater.add(temp);
				smaller.add(num);

			} else
				greater.add(num);
			median = (double) (smaller.peek() + greater.peek()) / 2;

		} else if (smaller.size() == greater.size()) {
			if (num < median) {
				smaller.add(num);
				median = (double) smaller.peek();
			}

			else {
				greater.add(num);
				median = (double) greater.peek();

			}
		} else {
			if (num > median) {
				int temp = greater.poll();
				smaller.add(temp);
				greater.add(num);

			} else {
				smaller.add(num);
			}
			median = (double) (smaller.peek() + greater.peek()) / 2;
		}

	}

	public double findMedian() {
		return median;
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */