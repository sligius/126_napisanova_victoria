package task;

public class DoubleLinkedList<T extends Comparable<T>> {
    private int size;
    private DoubleLinkedListItem first;
    private DoubleLinkedListItem last;

    public DoubleLinkedList(){
        size = 0;
    }
    public DoubleLinkedListItem findFirstItem(T data){
        DoubleLinkedListItem item = first;
        while(item.getData() != data){
            item = item.getNext();
        }
        return item;
    }
    public DoubleLinkedListItem findLastItem(T data){
        DoubleLinkedListItem item = last;
        while(item.getData() != data){
            item = item.getPrev();
        }
        return item;
    }
    public void insertAfter(DoubleLinkedListItem item, T data){
        DoubleLinkedListItem NewItem = new DoubleLinkedListItem(data);

        if(item == null && size == 0){
            first = NewItem;
            last = NewItem;
        }
        else if(item == null && size > 0){
            insertBefore(first,data);
            --size;
        }
        else if(item.getNext() == null){
            item.setNext(NewItem);
            NewItem.setPrev(item);
            last = NewItem;
        }
        else{
            NewItem.setNext(item.getNext());
            NewItem.setPrev(item);
            item.getNext().setPrev(NewItem);
            item.setNext(NewItem);
        }
        ++size;
    }
    public void insertBefore(DoubleLinkedListItem item, T data){
        DoubleLinkedListItem NewItem = new DoubleLinkedListItem(data);
        if(item == null && size == 0){
            first = NewItem;
            last = NewItem;
        }
        else if(item == null && size > 0){
            insertAfter(last,data);
            --size;
        }
        else if(item.getPrev() == null){
            item.setPrev(NewItem);
            NewItem.setNext(item);
            first = NewItem;
        }
        else{
            NewItem.setPrev(item.getPrev());
            NewItem.setNext(item);
            item.getPrev().setNext(NewItem);
            item.setPrev(NewItem);
        }
        ++size;
    }
    public void remove(DoubleLinkedListItem item){
        if(item.getNext() == null && item.getPrev() == null){
            last = null;
            first = null;
        }
        else if(item.getNext() == null && item.getPrev() != null){
            item.getPrev().setNext(null);
            last = item.getPrev();
        }
        else if(item.getNext() != null && item.getPrev() == null){
            item.getNext().setPrev(null);
            first = item.getNext();
        }
        else {
            item.getNext().setPrev(item.getPrev());
            item.getPrev().setNext(item.getNext());
            item.setNext(null);
            item.setPrev(null);
        }
        --size;
    }
    public int getSize(){
        return size;
    }
    public DoubleLinkedListItem getFirst(){
        return first;
    }
    public DoubleLinkedListItem getLast(){
        return last;
    }
}
