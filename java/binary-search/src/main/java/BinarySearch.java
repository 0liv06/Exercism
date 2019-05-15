import java.util.List;

public class BinarySearch {
    List<Integer> integerList;

    BinarySearch(List<Integer> integerList) {
        this.integerList = integerList;
    }

    int search(Integer index, Integer element) throws ValueNotFoundException {
        if (index.equals(integerList.size())) {
            throw new ValueNotFoundException("Value not in array");
        } else if (element.equals(integerList.get(index))) {
            return index;
        }
        return search(index + 1, element);
    }


    int indexOf(Integer element) throws ValueNotFoundException {
        return search(0, element);
    }
}
