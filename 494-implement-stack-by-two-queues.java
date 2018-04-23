public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    Queue<Integer> stack = new LinkedList<>();
    Queue<Integer> queue = new LinkedList<>();
    
    public void push(int x) {
        while (!stack.isEmpty()) {
            queue.offer(stack.poll());
        }    
        stack.offer(x);
        while (!queue.isEmpty()) {
            stack.offer(queue.poll());
        }
    }

    /*
     * @return: nothing
     */
    public void pop() {
        stack.poll();
    }

    /*
     * @return: An integer
     */
    public int top() {
        return stack.peek();
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}