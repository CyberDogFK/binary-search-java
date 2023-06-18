import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        int[] myList = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = List.of(1, 2, 3, 4 ,5, 6, 7, 8, 9);
        System.out.println(binarySearch(myList, 8));
        System.out.println(binarySearchGeneric(list, 8));
    }

    public static Optional<Integer> binarySearch(int[] list, int item) {
        var low = 0;
        var high = list.length- 1;

        while (low <= high) {
            var mid = (low + high) / 2;
            var guess = list[mid];
            if (guess == item) {
                return Optional.of(mid);
            }
            if (guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return Optional.empty();
    }

    public static <T extends Comparable<T>> Optional<Integer> binarySearchGeneric(List<T> list, T item) {
        var low = 0;
        var high = list.size() - 1;

        while (low <= high) {
            var mid = (low + high) / 2;
            var guess = list.get(mid);
            var compareResult = guess.compareTo(item);
            if (compareResult == 0) {
                return Optional.of(mid);
            }
            if (compareResult > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return Optional.empty();
    }
}
