package practice;

import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class ReverseEvenSegment {

	class Node {
		int data;
		Node next;
		Node(int x) {
			data = x;
			next = null;
		}
	}

	// Add any helper functions you may need here
	public Node reverseSegment(Node pre, Node first){

		if(first==null){
			return first;
		}
		if(first.next == null){//only one node to reverse
			return null;
		}
		if(first.next.data %2==1){
			return first.next;
		}


		Node segI = first;
		Node segJ = first.next;
		Node segK = first.next.next;


		while(segK !=null && segK.data%2==0){
			segJ.next = segI;
			segI = segJ;
			segJ = segK;
			segK = segK.next;
		}
		segJ.next = segI;
		pre.next=segJ;
		first.next=segK;
		return segK;

	}

	Node reverse(Node head) {
		// Write your code here
		Node headDummy = new Node(3);
		Node headI = headDummy;
		headI.next = head;
		while(headI!=null){
			if(headI.next!=null && headI.next.data%2==0){
				headI = reverseSegment(headI, headI.next);
			}else{
				headI = headI.next;
			}
		}
		return headDummy.next;
	}












	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void printLinkedList(Node head) {
		System.out.print("[");
		while (head != null) {
			System.out.print(head.data);
			head = head.next;
			if (head != null)
				System.out.print(" ");
		}
		System.out.print("]");
	}
	void check(Node expectedHead, Node outputHead) {
		boolean result = true;
		Node tempExpectedHead = expectedHead;
		Node tempOutputHead = outputHead;
		while (expectedHead != null && outputHead != null) {
			result &= (expectedHead.data == outputHead.data);
			expectedHead = expectedHead.next;
			outputHead = outputHead.next;
		}
		if (!(expectedHead == null && outputHead == null)) result = false;

		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printLinkedList(tempExpectedHead);
			System.out.print(" Your output: ");
			printLinkedList(tempOutputHead);
			System.out.println();
		}
		test_case_number++;
	}
	Node createLinkedList(int[] arr) {
		Node head = null;
		Node tempHead = head;
		for (int v : arr) {
			if (head == null) {
				head = new Node(v);
				tempHead = head;
			} else {
				head.next = new Node(v);
				head = head.next;
			}
		}
		return tempHead;
	}

	public void run() {

		int[] arr_1 = {1, 2, 8, 9, 12, 16};
		int[] expected1 = {1, 8, 2, 9, 16, 12};
		Node head_1 = createLinkedList(arr_1);
		Node expected_1 = createLinkedList(expected1);
		Node output_1 = reverse(head_1);
		check(expected_1, output_1);

		int[] arr_2 = {2, 18, 24, 3, 5, 7, 9, 6, 12};
		int[] expected2 = {24, 18, 2, 3, 5, 7, 9, 12, 6};
		Node head_2 = createLinkedList(arr_2);
		Node expected_2 = createLinkedList(expected2);
		Node output_2 = reverse(head_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new ReverseEvenSegment().run();
	}
}