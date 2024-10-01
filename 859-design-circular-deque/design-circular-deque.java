class MyCircularDeque {
    int[] array;
    int start;
    int last;
    int counter;

    public MyCircularDeque(int k) {
        array = new int[k];
        start = 0;
        last = array.length - 1;
        counter = 0;
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;

        start = ((start -  1) + array.length) % array.length;
        array[start] = value;

        counter++;

        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;

        last = ((last + 1) % array.length);
        array[last] = value;
        counter++;

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;

        start = ((start + 1)) % array.length;

        counter--;

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;

        last = ((last - 1) + array.length) % array.length;
        
        counter--;

        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;

        return array[start];
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        System.out.println(last);
        return array[last];
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public boolean isFull() {
        return counter == array.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */