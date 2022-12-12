package com.DeckOfCards;

import java.util.Random;

public class MyQueue<T> {

    MyLinkedList<T> linkedList;
    public MyQueue() {
        linkedList = new MyLinkedList<T>();
    }
    public void enqueueData(T data){
        linkedList.add(data);
    }
    public T dequeueData() {
        return linkedList.pop(0);
    }

}

class MyLinkedList<T> {

    MyNode<T> head;
    MyNode<T> current;
    int position;

    public MyLinkedList() {
        head = null;
        current = null;
        position = -1;
    }
    public void add(T data){
        MyNode<T> node = new MyNode<T>(data);
        if(head == null){
            head = node;
            current = head;
        }
        else{
            current.next = node;
            current = current.next;
        }
        position++;
    }

    public T pop(int location){
        MyNode<T> tempCurrent = head;
        MyNode<T> tempPrev = null;
        int tempPosition = 0;
        position--;
        while(tempPosition != location){
            tempPrev = tempCurrent;
            tempCurrent = tempCurrent.next;
            tempPosition++;
        }
        if(tempCurrent == head){
            head = head.next;
            return tempCurrent.data;
        }
        else if(tempCurrent == current){
            current = tempPrev;
            tempPrev.next = tempCurrent.next;
            return tempCurrent.data;
        }
        else{
            tempPrev.next = tempCurrent.next;
            return tempCurrent.data;
        }
    }

}

class MyNode<T>{
    T data;
    MyNode<T> next;

    MyNode(T data){
        this.data = data;
        next = null;
    }
}


