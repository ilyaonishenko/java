import java.util.Iterator;
public class sample{
    private static boolean less(int v,int w){
        return v<w;
    }
    private static void exch(int[] a,int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void show(int[] a){
        for(int i:a)
            System.out.print(i+" ");
        System.out.println();
    }
    private static void selectionSort(int[] a){
        int N = a.length;
        for (int i=0;i<N;i++){
            int min = i;
            for(int j=i+1;j<N;j++)
                if(less(a[j],a[min]))
                    min = j;
            exch(a,i,min);
        }
    }
    private static void selectionSort2(int a[]){
        int N = a.length;
        for (int i=0;i<N;i++){
            int min = i;
            for(int j=i+1;j<N;j++)
                if (less(a[j],a[min]))
                    min = j;
            exch(a,i,min);
        }
    }
    private static void insertionSort(int[] a){
        int N=a.length;
        for(int i=1;i<N;i++){
            for(int j=i;j>0&&less(a[j],a[j-1]);j--)
                exch(a,j,j-1);
        }
    }
    private static void shellSort(int[] a){
        int N = a.length;
        int h = 1;
        while(h<N/3)
            h = 3*h+1;
        while(h>=1){
            for(int i=h;i<N;i++){
                for(int j=i;j>=h&&less(a[j],a[j-1]);j--)
                    exch(a,j,j-1);
            }
            h=h/3;
        }
    }
    public static void main(String[] args){
        int[] array = new int[10];
        array[0] = 3;
        array[1] = 9;
        array[2] = 1;
        array[3] = 6;
        array[4] = 0;
        array[5] = 15;
        array[6] = 19;
        array[7] = 2;
        array[8] = 11;
        array[9] = 23;
        show(array);
        shellSort(array);
        show(array);
    }

}
public class Stack<Item>{
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current!=null;
        }
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
