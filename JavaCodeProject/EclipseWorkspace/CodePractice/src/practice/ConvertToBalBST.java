/**
 * Given a sorted singly linked list produce a balanced BST.
 */
package practice;

import dataStructures.*;
import java.util.*;

/**
 * @author anuplal
 *
 */
public class ConvertToBalBST {
	private static SinglyLinkedListNode sortedLinkedListHead;
	private static int listSize; 
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the lenght of sorted linked list");
		listSize = input.nextInt();
		System.out.println("Enter elements of sorted linked list");
		
		//initilize head node
		SinglyLinkedListNode currentNode = new SinglyLinkedListNode();
		sortedLinkedListHead = currentNode;
		currentNode.setVal(input.nextInt());
		
		for(int i = 1;i<listSize;i++) {
			SinglyLinkedListNode nextNode = new SinglyLinkedListNode();
			nextNode.setVal(input.nextInt());
			currentNode.setNext(nextNode);
			currentNode = nextNode;
		}
		
		input.close();
		
		printLinkedList(sortedLinkedListHead);
		
		//convert to 
		
		
	}
	public static void printLinkedList(SinglyLinkedListNode head) {
		while(head !=null) {
			System.out.println(head.getVal()+"\t");
			head = head.getNext();
		}
	}
	
}
