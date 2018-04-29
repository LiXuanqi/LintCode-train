public class RandomizedSet {
    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        // write your code here
        if (map.containsKey(val)) {
            return false;
        }
        
        list.add(val);
        map.put(val, list.size() - 1);
        
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        // write your code here
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int temp = list.get(list.size() - 1);
        list.set(index, temp);
        list.remove(list.size() - 1);
        map.put(temp, index);
        map.remove(val);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        // write your code here
        int size = list.size() - 1;
        // [0,1)
        System.out.print(Math.random() * size);
        int result = list.get((int) Math.ceil(Math.random() * size));
        return result;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param = obj.insert(val);
 * boolean param = obj.remove(val);
 * int param = obj.getRandom();
 */