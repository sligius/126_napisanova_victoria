import org.junit.*;

public class Task2_Tests extends Assert {

    class TestComparator implements MyComparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }

    private boolean isSorted(Integer[] data) {
        for(int i = 0; i < data.length - 1; ++i) {
            if(data[i] > data[i + 1])
                return false;
        }
        return true;
    }

    /* BubbleSort */

    @Test
    public void BubbleSort_SameNumbers_SortIsRight() {
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data = {5, 5, 5};

        bs.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{5, 5, 5}, data);
    }

    @Test
    public void BubbleSort_NotNeedSort_NumbersOnRightPlaces() {
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data = {1, 3, 5};

        bs.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{1, 3, 5}, data);
    }

    @Test
    public void BubbleSort_SortData_DataIsCorrect() {
        BubbleSort<Integer> bs = new BubbleSort<>();
        Integer[] data = {1, 5, 3};

        bs.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{1, 3, 5}, data);
    }

    /* SelectionSort */

    @Test
    public void SelectionSort_InvertedArray_DataIsCorrect() {
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data = {5, 3, 1};

        ss.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{1, 3, 5}, data);
    }

    @Test
    public void SelectionSort_UnsortedArray_DataIsCorrect() {
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data = {15, 5};

        ss.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{5, 15}, data);
    }

    @Test
    public void SelectionSort_SortArray_DataIsCorrect() {
        SelectionSort<Integer> ss = new SelectionSort<>();
        Integer[] data = {35, 15, 5, 25, 45};

        ss.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{5, 15, 25, 35, 45}, data);
    }

    /* InsertionSort */

    @Test
    public void InsertionSort_SortAlreadySortedArray_DataIsCorrect() {
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data = {5, 15};

        is.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{5, 15}, data);
    }

    @Test
    public void InsertionSort_UnsortedArray_DataIsCorrect() {
        InsertionSort<Integer> is = new InsertionSort<>();
        Integer[] data = {15, 5};

        is.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{5, 15}, data);
    }
}
