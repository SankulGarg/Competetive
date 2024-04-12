//package com.github.sankulgarg.leetcode.linkedLists;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
//class AllOne {
//    private final Map<String, Node> keyToNode;
//    private final Map<Integer, DoublyLinkedList<Node>> countToList;
//
//    private final Node maxNode, minNode;
//
//// Initialize your data structure here.
//
//    public AllOne() {
//        this.keyToNode = new HashMap<>();
//        this.countToList = new HashMap<>();
//        this.maxNode = null;
//        this.minNode = null;
//    }
//
//// Inserts a new key <Key> with value 1. Or increments an existing key by 1.
//
//    public void inc(final String key) {
//        final Node node;
//
//        if (this.keyToNode.containsKey(key)) {
//            node = this.keyToNode.get(key);
//            final DoublyLinkedList<Node> prevCountList = this.countToList.get(node.count);
//
//            removeNodeFromList(node);
//
//
//            if (prevCountList.isEmpty()) {
//                removeNodeFromList(this.countToNode.get(node.count));
//                this.countToNode.remove(node.count);
//                this.countToList.remove(node.count);
//            }
//
//            node.count++;
//        } else {
//            node = new Node(key, 1);
//
//            this.keyToNode.put(key, node);
//
//            if (!this.countToNode.containsKey(node.count)) {
//                final Node countNode = new Node(key, node.count);
//
//                this.countList.addFirst(countNode);
//                this.countToNode.put(countNode.count, countNode);
//            }
//        }
//
//        this.countToList.putIfAbsent(node.count, new DoublyLinkedList());
//        this.countToList.get(node.count).addFirst(node);
//    }
//
//// Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
//
//    public void dec(final String key) {
//        final Node listNode = this.keyToNode.get(key);
//
//        if (listNode.count == 1)
//            this.keyToNode.remove(key);
//        else
//            this.addPrevCountNode(key, listNode.count);
//
//        final DoublyLinkedList<Node> prevCountList = this.countToList.get(listNode.count);
//
//        removeNodeFromList(listNode);
//
//        if (prevCountList.isEmpty()) {
//            removeNodeFromList(this.countToNode.get(listNode.count));
//            this.countToNode.remove(listNode.count);
//            this.countToList.remove(listNode.count);
//        }
//
//        if (listNode.count != 1) {
//            listNode.count--;
//            this.countToList.putIfAbsent(listNode.count, new DoublyLinkedList());
//            this.countToList.get(listNode.count).addFirst(listNode);
//        }
//    }
//
//// Returns one of the keys with maximal value.
//
//    public String getMaxKey() {
//        return this.countList.isEmpty() ? "" : this.countToList.get(this.countList.getLast().count).getFirst().key;
//    }
//
//// Returns one of the keys with Minimal value.
//
//    public String getMinKey() {
//        return this.countList.isEmpty() ? "" : this.countToList.get(this.countList.getFirst().count).getFirst().key;
//    }
//
//    private void removeNodeFromList(final Node listNode) {
//        if (listNode == null)
//            return;
//
//        if (listNode.prev != null)
//            listNode.prev.next = listNode.next;
//
//        if (listNode.next != null)
//            listNode.next.prev = listNode.prev;
//    }
//
//    private void addNextCountNode(String key, final int count) {
//        final Node currNode = this.countToNode.get(count);
//
//        if (currNode.count + 1 != currNode.next.count) {
//            Node newNode = new Node(key, count + 1);
//
//            newNode.prev = currNode;
//            newNode.next = currNode.next;
//
//            currNode.next.prev = newNode;
//            currNode.next = newNode;
//
//            this.countToNode.put(newNode.count, newNode);
//        }
//    }
//
//    private void addPrevCountNode(String key, final int count) {
//        final Node currNode = this.countToNode.get(count);
//
//        if (currNode.count - 1 != currNode.prev.count) {
//            Node newNode = new Node(key, count - 1);
//
//            newNode.next = currNode;
//            newNode.prev = currNode.prev;
//
//            currNode.prev.next = newNode;
//            currNode.prev = newNode;
//
//            this.countToNode.put(newNode.count, newNode);
//        }
//    }
//
//    private class Node {
//        public Node prev, next;
//        public final String key;
//        public int count;
//
//        public Node(String key, int count) {
//            this.key = key;
//            this.count = count;
//        }
//    }
//
//
//    private final class DoublyLinkedList<T extends Node> {
//        private final Node head, tail;
//
//        public DoublyLinkedList() {
//            this.head = new Node("", -1);
//            this.tail = new Node("", -1);
//
//            this.head.next = this.tail;
//            this.tail.prev = this.head;
//        }
//
//        public void addFirst(final T listNode) {
//            listNode.next = this.head.next;
//            listNode.prev = this.head;
//            this.head.next.prev = listNode;
//            this.head.next = listNode;
//        }
//
//        public T getLast() {
//            return this.isEmpty() ? null : (T) this.tail.prev;
//        }
//
//        public T getFirst() {
//            return this.isEmpty() ? null : (T) this.head.next;
//        }
//
//        public boolean isEmpty() {
//            return this.head.next == this.tail;
//        }
//    }
//}
//
//
//class Main {
//    public static void main(String[] args) {
//        AllOne allOne = new AllOne();
//        allOne.inc("a");
//        allOne.inc("b");
//        allOne.inc("b");
//        allOne.inc("c");
//        allOne.inc("c");
//        allOne.inc("c");
//        allOne.dec("b");
//        allOne.dec("b");
//        System.out.println("result: " + allOne.getMinKey());
//        allOne.dec("a");
//        System.out.println("result: " + allOne.getMaxKey());
//        System.out.println("result: " + allOne.getMinKey());
//
//    }
//}
//
///**
// * Your AllOne object will be instantiated and called as such:
// * AllOne obj = new AllOne();
// * obj.inc(key);
// * obj.dec(key);
// * String param_3 = obj.getMaxKey();
// * String param_4 = obj.getMinKey();
// */
