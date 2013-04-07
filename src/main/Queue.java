/*
Queue.java
Author: Anne Gatchell
Date modified: 18 March 2013

An implemenation of a generic queue.
*/

package src.main;

public class Queue<T>{

	Node front;
	Node back;
	int length;

	class Node{
		T item;
		Node next;
		Node(T i){
			item = i;
			next = null;
		}
	}

	public Queue(){
		length = 0;
		front = null;
		back = null;
	}

	public void enqueue(T item){
		Node n = new Node(item);
		if(isEmpty()){
			front = n;
			back = n;
		}
		else{
			back.next = n;
			back = n;
		}
		length++;
	}

	public T dequeue(){
		if(length > 0){
			Node n = front;
			front = front.next;
			length--;
			return n.item;
		}
		return null;
	}

	public boolean isEmpty(){
		return front == null;
	}

	public int size(){
		return length;
	}

}