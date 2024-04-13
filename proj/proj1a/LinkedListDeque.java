public class LinkedListDeque<T>{
    private class Node<T> {
        public T item;
        public Node<T> next;
        public Node<T> prev;
        public Node(T i,Node n,Node p) {
            item = i;
            next = n;
            prev = p;
        }
        public Node(T i){
            item=i;
        }
        public T getNode(int index){
            if(index==0) return this.item;
            else return this.next.getNode(index-1);
        }
    }
    T a;
    public Node<T> sentinel=new Node<>(a);
    private int size;
    public LinkedListDeque(){
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
        size=0;
    }
    public LinkedListDeque(T it){
        sentinel.next=new Node<T>(it,sentinel,sentinel);
        sentinel.prev=sentinel.next;
        size=1;
    }
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size==0) return true;
        else return false;
    }

    public void addFirst(T x){
        Node<T> p1=sentinel.next;
        p1.prev=new Node<T>(x,sentinel.next,sentinel);
        sentinel.next=sentinel.next.prev;
        size+=1;
    }
    public void addLast(T x){
        Node<T> p=sentinel.prev;
        p.next=new Node<T>(x,sentinel,p);
        sentinel.prev=p.next;
        size+=1;
    }
    public T get(int index){
        if(index==0) return null;
        Node<T> p=sentinel;
        int i=0;
        while(i<index){
            p=p.next;
            i+=1;
        }
        return p.item;
    }
    public T getRecursive(int index){
        if(index==1) return sentinel.next.item;
        else return sentinel.next.getNode(index-1);
    }
    public T removeFirst(){
        Node<T> p=sentinel.next;
        sentinel.next=p.next;
        p.next.prev=sentinel;
        p.next=null;
        p.prev=null;
        size-=1;
        return p.item;
    }
    public T removeLast(){
        Node<T> p=sentinel.prev;
        sentinel.prev=p.prev;
        p.prev.next=sentinel;
        p.next=null;
        p.prev=null;
        size-=1;
        return p.item;
    }
    public void printDeque(){
        Node<T> p=sentinel.next;
        for(int i=1;i<=size;i+=1){
            System.out.println(p.item);
            p=p.next;
        }
    }
}
