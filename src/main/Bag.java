package src.main;

import java.util.Iterator;

public class Bag<T> implements Iterable<T>{
	Node first;
	int size;

	private class Node{
		T item;
		Node next;
		Node(T i, Node n){
			item = i;
			next = n;
		}
	}

	public Bag(){
		first = null;
		size = 0;
	}

	public void add(T i){
		Node n = new Node(i, first);
		first = n;
		size++;
	}

	public Iterator<T> iterator(){
		return new ListIterator();
	}
	class ListIterator implements Iterator<T>{
		private Node current = first;

		public boolean hasNext(){
			return current != null;
		}
		public void remove(){}
		public T next(){
			T item = current.item;
			current = current.next;
			return item;
		}
	}
	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public String toString(){
		StringBuilder s = new StringBuilder();
		for(T i: this){
			s.append(i + " ");
		}
		if(s.length() > 0){s.deleteCharAt(s.length()-1);}
		return s.toString();
	}

}