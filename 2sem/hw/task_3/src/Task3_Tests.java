import org.junit.*;

public class Task3_Tests extends Assert {

    class TestComparator implements MyComparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return first - second;
        }
    }

    /* QuickSort */

    @Test
    public void QuickSort_SortUnsortedArray_DataIsCorrect() {
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {5, 1, 3};

        qs.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{1, 3, 5}, data);
    }

    @Test
    public void QuickSort_UnsortedArrayWithZero_DataIsCorrect() {
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {1, 0, 5, 3};

        qs.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{0, 1, 3, 5}, data);
    }

    /*
    @Test
    public void QuickSort_UnsortedArrayWithSameElements_DataIsCorrect() {
        QuickSort<Integer> qs = new QuickSort<>();
        Integer[] data = {0, 3, 5, 3, 0};

        qs.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{0, 0, 3, 3, 5}, data);
    }
     */

    /* MergeSort */

    @Test
    public void MergeSort_SortUnsortedArray_DataIsCorrect() {
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {15, 5};

        ms.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{5, 15}, data);
    }

    @Test
    public void MergeSort_FirstElementsAreUnsorted_DataIsCorrect() {
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {15, 5, 25};

        ms.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{5, 15, 25}, data);
    }

    @Test
    public void MergeSort_UnsortedArrayWithTwoSameElements_DataIsCorrect() {
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {15, 5, 5, 25};

        ms.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{5, 5, 15, 25}, data);
    }

    @Test
    public void MergeSort_UnsortedLargeArray_DataIsCorrect() {
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {15, 95, 75, 5, 55, 85, 35, 65, 25, 45};

        ms.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{5, 15, 25, 35, 45, 55, 65, 75, 85, 95}, data);
    }

    @Test
    public void MergeSort_UnsortedLargeArrayWithSameElements_DataIsCorrect() {
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {15, 55, 75, 5, 55, 55, 35, 65, 25, 45};

        ms.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{5, 15, 25, 35, 45, 55, 55, 55, 65, 75}, data);
    }

    @Test
    public void MergeSort_ReversedArray_DataIsCorrect() {
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {25, 15, 5};

        ms.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{5, 15, 25}, data);
    }

    @Test
    public void MergeSort_SortedArrayWithEvenNumberOfElements_DataIsCorrect() {
        MergeSort<Integer> ms = new MergeSort<>();
        Integer[] data = {5, 15, 25, 35};

        ms.sort(data, new TestComparator());

        assertArrayEquals(new Integer[]{5, 15, 25, 35}, data);
    }
}
