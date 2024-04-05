//532. K-diff Pairs in an Array
class Solution {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        if(k == 0){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i : nums){
                if(map.containsKey(i)){
                    int a = map.get(i);
                    
                    map.put(i, a + 1);
                    if(a == 1) count = count + a;
                }
                else{
                    map.put(i, 1);
                }
            }
            return count;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int[] num = new int[set.size()];
        // set.toArray(num);
        int b = 0;
        for(int i : set){
            num[b++] = i;
        }
        Arrays.sort(num);
        // System.out.println(Arrays.toString(num));
        int n = num.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = i; j < n; j++){
                if(Math.abs(num[i] - num[j]) == k){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
