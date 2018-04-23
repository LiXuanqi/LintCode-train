public class MovingAverage {
    double sum;
    int size;
    Queue<Integer> queue;
    /*
    * @param size: An integer
    */public MovingAverage(int size) {
        // do intialization if necessary
        sum = 0;
        this.size = size;
        queue = new LinkedList<>();
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        int minus = 0;
        if (queue.size() == size) {
            minus = queue.poll();
        }
        queue.offer(val);
        sum = sum - minus + val;
        return sum / queue.size();
    }
}