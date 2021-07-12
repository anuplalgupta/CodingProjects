package practice;

import dataStructures.SinglyLinkedListNode;

import java.util.List;

public class ImmutableStack {
    private SinglyLinkedListNode head;
    private int size=0;

    public ImmutableStack(SinglyLinkedListNode head, int size) {
        this.head = head;
        this.size = size;
    }

    public ImmutableStack push(int v){
        SinglyLinkedListNode newHead = new SinglyLinkedListNode(v);
        newHead.setNext(head);
        return new ImmutableStack(newHead,size+1);
    }

    public ImmutableStack pop(){
        SinglyLinkedListNode newHead = head.getNext();
        return new ImmutableStack(newHead,size-1);
    }

    public int getSize(){
        return size;
    }
}
