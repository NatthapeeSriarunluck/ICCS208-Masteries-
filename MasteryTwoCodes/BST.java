public class BST<K extends Comparable<? super K>, V> {
    K key;
    V value;
    BST<K, V> left, right;

    BST(BST<K, V> left, K key, V value, BST<K, V> right) {
        this.left = left;
        this.key = key;
        this.value = value;
        this.right = right;
    }

    V get(K k) {
        if (key == k) return value;
        else if (k.compareTo(key) > 0 && right != null) return right.get(k);
        else if (k.compareTo(key) < 0 && left != null) return left.get(k);
        else return null;
    }

    void put(K k, V v) {
        if (left == null) left = new BST<>(null, k, v, null);
        else if (right == null) right = new BST<>(null, k, v, null);
        else if (k.compareTo(key) < 0) left.put(k, v);
        else right.put(k, v);
    }

    K lowerKey(K k) {
        if (k.compareTo(key) <= 0 && left != null) return left.lowerKey(k);
        else if (k.compareTo(key) > 0) {
            K rightFloor = (right != null) ? right.lowerKey(k) : null;
            return (rightFloor == null) ? this.key : rightFloor;
        } else return null;
    }

    K floorKey(K k) {
        if (k == key) return this.key;
        else if (k.compareTo(key) < 0 && left != null) return left.floorKey(k);
        else if (k.compareTo(key) > 0) {
            K rightFloor = (right != null) ? right.floorKey(k) : null;
            return (rightFloor == null) ? this.key : rightFloor;
        } else return null;
    }
}
