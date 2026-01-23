class MyCalendar {
    private List<int[]> bookings;
    public MyCalendar() {
        bookings = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        //if(!bookings.isEmpty()){
        for(int[] event : bookings){
            int s = event[0];
            int e = event[1];
            if(startTime <e && s< endTime ){
                return false;
            }
        }
        //}
        bookings.add(new int[]{startTime, endTime});
        return true;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */