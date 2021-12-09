package task;

public class DoubleLinkedListSorter {
    public static <T extends Comparable<T>> void sort(DoubleLinkedList<T> list) {

        for (int i = 0; i < list.getSize(); ++i) {
            DoubleLinkedListItem MaxItem = list.getLast();
            DoubleLinkedListItem item = list.getLast();

            for (int j = 0; j < list.getSize() - i; ++j) {
                if(item.getData().compareTo(MaxItem.getData()) > 0){
                    MaxItem = item;
                }
                item = item.getPrev();
            }

            list.remove(MaxItem);
            list.insertBefore(list.getFirst(), (T)MaxItem.getData());
        }
    }
}
