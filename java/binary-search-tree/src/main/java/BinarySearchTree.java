import java.util.*;

class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> firstNode = new Node<>();

    void insert(T value) {
        this.firstNode.insert(value);
    }


    List<T> getAsSortedList() {
        return firstNode.asSortedTree();
    }

    List<T> getAsLevelOrderList() {
        List<T> result = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<>();

        queue.offer(firstNode);

        Node<T> item;
        T data;

        while(!queue.isEmpty()) {
            item = queue.poll();
            data = item.getData();
            if (data != null) {
                result.add(data);
                queue.offer(item.left);
                queue.offer(item.right);
            }
        }
        return result;
    }

    Node<T> getRoot() {
        return this.firstNode;
    }

    static class Node<T extends Comparable<T>> {
        T data;
        Node<T> left;
        Node<T> right;

        Node<T> getLeft() {
            return this.left;
        }

        Node<T> getRight() {
            return this.right;
        }

        T getData() {
            return this.data;
        }

        void insert(T value) {
             if (this.data == null) {
                 this.data = value;
                 this.right = new Node<>();
                 this.left = new Node<>();
             } else if (value.compareTo(this.data) > 0) {
                 getRight().insert(value);
             } else {
                 getLeft().insert(value);
             }
        }

        List<T> asSortedTree() {
            if (this.data == null) {
                return Collections.emptyList();
            }
            List<T> result = new ArrayList<>(getLeft().asSortedTree());
            result.add(this.data);
            result.addAll(getRight().asSortedTree());
            return result;
        }
    }
}
