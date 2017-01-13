package com.cy.core.test;

import java.util.Deque;
import java.util.LinkedList;

public class Fab {
	public static void main(String[] args) {
		System.err.println(fab(40));

		System.err.println(fab2(40));
	}
	public static long fab(int num){
		long[] i = { 1, 1 ,0};
		for (int j = 2; j < num; j++) {
			i[2] = i[1];
			i[1] = i[0] + i[1];
			i[0] = i[2];
		}
		return i[1];
	}
	
	public static long fab2(int num){
		
		Deque<Long> deque = new LinkedList<>();
		deque.push(1L);
		deque.push(1L);
		for (int j = 2; j < num; j++) {
			deque.offerLast(deque.pop()+deque.peek());
		}
		return deque.peekLast();
		
	}
}
