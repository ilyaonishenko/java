package com.company;

/**
 * Created by wopqw on 02.02.17.
 */
public class Stack<T>{
    private class Node<T>{

        final T item;
        final Node<T> next;

        Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
        T getItem(){
            return this.item;
        }
    }
    private Node<T> first;
    private int N;
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void push(T newItem){

        Node<T> prevFirst = first;
        first = new Node<T>(newItem, prevFirst);
        N++;
    }
    public T pop(){

        T rItem = first.getItem();
        first = first.next;
        N--;
        return rItem;
    }
    public T peek(){

        if (isEmpty()) throw new RuntimeException("Stack underflow");
        return first.getItem();
    }
}
