public class ArrayDeque<Item>{
    private Item[] items;
    private int size;

    public ArrayDeque(){
        items = (Item[]) new Object[100];
        size=0;
    }
    public int size(){
        return size;
    }
    void addFirst(Item x){
        if(items.length==size){
            resize(size*2);
        }
        Item[] tem = (Item[]) new Object[items.length];
        System.arraycopy(items,0,tem,1,size);
        items=tem;
        size+=1;
    }
    void addLast(Item x){
        items[size-1]=x;
        size+=1;
    }
    public void resize(int capacity){
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items=a;
    }
    public boolean isEmpty(){
        if(size==0) return true;
        return false;
    }
    public Item removeFirst(){
        Item x=items[0];
        Item[] tem = (Item[]) new Object[items.length];
        System.arraycopy(items,1,tem,0,size-1);
        items=tem;
        size-=1;
        return x;
    }
    public Item removeLast(){
        Item x=items[size-1];
        items[size-1]=null;
        size-=1;
        return x;
    }
    public Item get(int index){
        return items[index];
    }
    public void printDeque(){
        for(int i=0;i<size;i+=1){
            System.out.println(items[i]);
        }
    }
}
