class MyCalendar {
    private TreeMap<Integer, Integer> bookings;
    public MyCalendar() {
        bookings = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        //if(!bookings.isEmpty()){
        // for(int[] event : bookings){
        //     int s = event[0];
        //     int e = event[1];
        //     if(startTime <e && s< endTime ){
        //         return false;
        //     }
        // }
        // //}
        // bookings.add(new int[]{startTime, endTime});
        // return true;
        Integer prev = bookings.floorKey(startTime);
        if(prev!=null && bookings.get(prev)> startTime)
        return false;
        Integer next = bookings.ceilingKey(startTime);
        if (next!=null && endTime > next) return false;
        bookings.put(startTime, endTime);
        return true;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */