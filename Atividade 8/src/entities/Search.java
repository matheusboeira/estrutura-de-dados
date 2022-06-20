package entities;

public class Search {
    public static int recursiveBinarySearch(Vector<Integer> vector, int element) throws Exception {
        return binarySearch(vector, element, 0, vector.size() - 1);
    }

    private static int binarySearch(Vector<Integer> vector, int element, int smaller, int larger) throws Exception {
        int mid = (smaller + larger) / 2;

        if (smaller > larger) return -1;
        if (vector.get(mid) == element) return mid;
        if (vector.get(mid) < element) return binarySearch(vector, element, mid + 1, larger);
        else return binarySearch(vector, element, smaller, mid - 1);
    }

    public static int iterativeBinarySearch(Vector<Integer> vector, int element) throws Exception {
        int start = 0, mid, end = vector.size() - 1;

        while (start <= end) {
            mid = (start + end) / 2;

            if (vector.get(mid) == element) return mid;
            else if (vector.get(mid) < element) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public static int iterativeSearch(Vector<Integer> vector, int element) throws Exception {
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i) == element) {
                return i;
            }
        }
        return -1;
    }
}
