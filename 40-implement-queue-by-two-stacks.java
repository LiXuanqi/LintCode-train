public class MyQueue {
    Stack<Integer> mainStack;
    Stack<Integer> helpStack;
    public MyQueue() {
        mainStack = new Stack<>();
        helpStack = new Stack<>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        while (!mainStack.empty()) {
            helpStack.push(mainStack.pop());
        }
        
        mainStack.push(element);
        
        while (!helpStack.empty()) {
            mainStack.push(helpStack.pop());
        }
  
    }

    /*
     * @return: An integer
     */
    public int pop() {
        return mainStack.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        return mainStack.peek();
    }
}