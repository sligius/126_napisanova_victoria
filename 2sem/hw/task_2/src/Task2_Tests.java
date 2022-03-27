import org.junit.*;

public class Task2_Tests extends Assert {

    class TestComparator implements MyComparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
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

    private boolean isSorted(Integer[] data) {
        for(int i = 0; i < data.length - 1; ++i) {
            if(data[i] > data[i + 1])
                return false;
        }
        return true;
    }
}
