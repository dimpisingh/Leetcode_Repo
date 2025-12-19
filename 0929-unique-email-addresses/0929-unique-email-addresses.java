class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> st = new HashSet<>();

        for(String email:emails){
            int atPos = email.indexOf("@");
            String localNm = email.substring(0,atPos);
            String domainNm = email.substring(atPos);
            if(localNm.contains(".")){
                localNm = localNm.replaceAll("\\.","");
            }
            if(localNm.contains("+")){
                int pl = localNm.indexOf("+");
                localNm = localNm.substring(0,pl);
            }
            st.add(localNm+domainNm);
            System.out.println(localNm+domainNm);

        }
        return st.size();
        
    }
}