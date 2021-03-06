import org.junit.Assert;
import org.junit.*;

public class Task1_Tests extends Assert {

    /* DynamicArray */

    @Test
    public void getSize_getSizeOfNewArray_SizeEqualsZero() {
        DynamicArray<Integer> array = new DynamicArray<>();
        assertEquals(0, array.getSize());
    }

    @Test
    public void getSize_getSizeOfNewArray_SizeEqualsDefault() {
        DynamicArray<Integer> array = new DynamicArray<>(DynamicArray.DefaultSize);
        assertEquals(1024, array.getSize());
    }

    @Test
    public void setValue_setNewValue_ValueIsRight() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        array.set(1, 2);
        assertEquals(2, array.get(1).intValue());
    }

    @Test
    public void resize_SetNewSizeWithPositiveValue_NewSizeIsRight() {
        DynamicArray<Integer> array = new DynamicArray<>(2);
        array.resize(4);
        assertEquals(4, array.getSize());
    }

    @Test
    public void resize_SetNewSizeWithNegativeValue_NegativeArraySizeException() {
        DynamicArray<Integer> array = new DynamicArray<>(2);
        try {
            array.resize(-5);
            fail();
        } catch (NegativeArraySizeException e) {
            assertTrue(true);
        }
    }

    @Test
    public void getIndex_GetIndexEqualsSize_IndexOutOfBounds() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        try {
            array.get(10);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }

    @Test
    public void setIndex_SetIndexEqualsSize_IndexOutOfBounds() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        try {
            array.set(10, DynamicArray.DefaultSize);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }

    @Test
    public void insertIndex_InsertIndexEqualsSize_IndexOutOfBounds() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        try {
            array.insert(10, DynamicArray.DefaultSize);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index out of bounds", e.getMessage());
        }
    }

    @Test
    public void insertIndex_InsertNewIndexInNotExistingSlot_ValueIsRight() {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        array.set(1, 100);
        array.set(2, 200);
        array.set(3, 300);

        array.insert(4, 400);

        assertEquals(400, array.get(4).intValue());
        assertEquals(200, array.get(2).intValue());
    }

    @Test
    public void pushBack_pushBackElement_ValueIsCorrect() {
        DynamicArray<Integer> array = new DynamicArray<>(4);
        array.set(1, 100);
        array.set(2, 200);
        array.set(3, 300);

        array.pushBack(400);

        assertEquals(400, array.get(4).intValue());
    }

    @Test
    public void popBack_PopBackElementFromArray_ValueIsRight() {
        DynamicArray<Integer> array = new DynamicArray<>(3);
        array.set(0, 100);
        array.set(1, 200);
        array.set(2, 300);

        array.popBack();

        assertEquals(2, array.getSize());
    }

    @Test
    public void popBack_PopBackElementFromEmptyArray_UnsupportedOperation() {
        DynamicArray<Integer> array = new DynamicArray<>(0);
        try {
            array.popBack();
            fail();
        } catch (UnsupportedOperationException e) {
            assertTrue(true);
        }
    }

    @Test
    public void remove_RemoveElementFromArray_ValueIsRight() {
        DynamicArray<Integer> array = new DynamicArray<>(3);
        array.set(0, 100);
        array.set(1, 200);
        array.set(2, 300);

        array.remove(2);

        assertEquals(200, array.get(1).intValue());
        assertEquals(100, array.get(0).intValue());
    }

    @Test
    public void remove_RemoveIndexEqualSize_IndexOutOfBounds() {
        DynamicArray<Integer> array = new DynamicArray<>(5);
        try {
            array.remove(5);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    /* DoubleLinkedList */

    @Test
    public void createList_CreateNewDoubleLinkedList_ListIsEmpty() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        assertEquals(true, list.isEmpty());
    }

    @Test
    public void createList_CreateNewDoubleLinkedList_ListIsNotEmpty() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.pushFront(5);

        assertEquals(false, list.isEmpty());
    }

    @Test
    public void pushFront_PushElementToNewList_SizeEqualsOne() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.pushFront(5);

        assertEquals(1, list.getSize());
    }

    @Test
    public void pushBack_PushElementToNewList_SizeEqualsOne() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.pushBack(5);

        assertEquals(1, list.getSize());
    }

    @Test
    public void pushFront_PushFrontItem_ItemIsRight() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(10);

        Node<Integer> head = (Node<Integer>) list.getHead();
        Node<Integer> tail = (Node<Integer>) list.getTail();

        assertEquals(10, head.getData().intValue());
        assertEquals(10, tail.getData().intValue());
    }

    @Test
    public void pushFront_PushFrontFewItems_ItemsAreRight() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(10);
        list.pushFront(100);
        list.pushFront(1000);

        Node<Integer> head = (Node<Integer>) list.getHead();
        Node<Integer> tail = (Node<Integer>) list.getTail();

        assertEquals(1000, head.getData().intValue());
        assertEquals(10, tail.getData().intValue());
    }

    @Test
    public void get_GetIndexEqualsSize_IndexOutOfBonds() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushFront(5);
        try {
            list.get(1);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void get_GetIndex_IndexIsRight() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.pushBack(5);
        list.pushBack(10);
        list.pushBack(15);

        Node<Integer> element = (Node<Integer>) list.get(1);

        assertEquals(10, element.getData().intValue());
    }

    @Test
    public void remove_RemoveElementFromList_EmptyList() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Node<Integer> element = (Node<Integer>) list.pushBack(5);

        list.remove(element);

        assertEquals(0, list.getSize());
    }

    @Test
    public void remove_RemoveElementFromList_NotEmptyList() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Node<Integer> element1 = (Node<Integer>) list.pushBack(5);
        Node<Integer> element2 = (Node<Integer>) list.insertAfter(element1, 15);
        Node<Integer> element3 = (Node<Integer>) list.insertBefore(element1, 25);

        list.remove(element1);

        Node<Integer> item1 = (Node<Integer>) element3.getNext();
        Node<Integer> item2 = (Node<Integer>) element2.getPrev();

        assertEquals(15, item1.getData().intValue());
        assertEquals(25, item2.getData().intValue());
    }

    @Test
    public void insertListAfter_InsertListAfterFirstList_ElementsAreCorrect() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();

        list1.pushBack(5);
        list1.pushBack(15);
        list1.pushBack(25);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();

        list2.pushBack(35);
        list2.pushBack(45);
        list2.pushBack(55);

        list1.insertListAfter(list1.get(2), list2);

        Node<Integer> element1 = (Node<Integer>) list1.get(0);
        Node<Integer> element2 = (Node<Integer>) list1.get(1);
        Node<Integer> element3 = (Node<Integer>) list1.get(2);
        Node<Integer> element4 = (Node<Integer>) list1.get(3);
        Node<Integer> element5 = (Node<Integer>) list1.get(4);
        Node<Integer> element6 = (Node<Integer>) list1.get(5);

        assertEquals(5, element1.getData().intValue());
        assertEquals(15, element2.getData().intValue());
        assertEquals(25, element3.getData().intValue());
        assertEquals(35, element4.getData().intValue());
        assertEquals(45, element5.getData().intValue());
        assertEquals(55, element6.getData().intValue());

    }

    @Test
    public void insertListBefore_InsertListBeforeFirstList_ElementsAreCorrect() {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();

        list1.pushBack(35);
        list1.pushBack(45);
        list1.pushBack(55);

        DoubleLinkedList<Integer> list2 = new DoubleLinkedList<>();

        list2.pushBack(5);
        list2.pushBack(15);
        list2.pushBack(25);

        list1.insertListBefore(list1.get(0), list2);

        Node<Integer> element1 = (Node<Integer>) list1.get(0);
        Node<Integer> element2 = (Node<Integer>) list1.get(1);
        Node<Integer> element3 = (Node<Integer>) list1.get(2);
        Node<Integer> element4 = (Node<Integer>) list1.get(3);
        Node<Integer> element5 = (Node<Integer>) list1.get(4);
        Node<Integer> element6 = (Node<Integer>) list1.get(5);

        assertEquals(5, element1.getData().intValue());
        assertEquals(15, element2.getData().intValue());
        assertEquals(25, element3.getData().intValue());
        assertEquals(35, element4.getData().intValue());
        assertEquals(45, element5.getData().intValue());
        assertEquals(55, element6.getData().intValue());

    }
}

