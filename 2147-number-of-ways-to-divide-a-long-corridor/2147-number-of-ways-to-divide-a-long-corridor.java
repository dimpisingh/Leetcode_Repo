class Solution {
    public int numberOfWays(String corridor) {
    int M = 1000000007; 
        int n = corridor.length();
        List<Integer> pos = new ArrayList<>();
        for(int i=0; i<n; i++){
          
            if(corridor.charAt(i)=='S'){
                pos.add(i);
            }
        }


        if(pos.size()==0 || pos.size()%2 != 0) return 0;

        long result = 1;
        int i = 2; 
        while(i<pos.size()){
            int len = pos.get(i) - pos.get(i-1); 
            result = (result * len) % M; 
            i = i+2; 
        }
        return (int)result;
    }
}