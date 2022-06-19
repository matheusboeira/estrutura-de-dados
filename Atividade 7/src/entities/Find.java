package entities;

public class Find {
    public static int maxRecursive(int start, int end, Vector<Integer> vector) {
        if (start == end) return vector.get(start);

        int mid = (start + end) / 2;
        int max1 = maxRecursive(start, mid, vector);
        int max2 = maxRecursive(mid + 1, end, vector);
        return (max1 > max2) ? max1 : max2;
    }

    public static int maxIterative(Integer start, Integer end, Vector<Integer> vector) {
        int max = Integer.MIN_VALUE;

        for (int i = start; i < end; i++) {
            if (vector.get(i) > max) {
                max = vector.get(i);
            }
        }
        return max;
    }
}
