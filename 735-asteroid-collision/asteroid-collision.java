class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        boolean flag = false;

        for (int n : asteroids) {
            flag = false;

            while (!flag && !stack.isEmpty() &&
                    stack.peek() >= 0 &&
                    n < 0 &&
                    stack.peek() <= Math.abs(n)) {
                flag = stack.pop() == Math.abs(n);
            }

            if (!stack.isEmpty() && stack.peek() >= 0 && n < 0) {
                continue;
            } else if (!flag) {
                stack.push(n);
            }

        }

        return stackToArray(stack);
    }

    public static int[] stackToArray(Stack<Integer> stack) {
        int size = stack.size();
        int[] array = new int[size];

        // Llenar el array con los elementos de la pila
        for (int i = 0; i < size; i++) {
            array[i] = stack.get(i);
        }

        return array;
    }
}