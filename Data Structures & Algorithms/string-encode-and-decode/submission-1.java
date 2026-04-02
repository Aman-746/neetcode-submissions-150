class Solution {

    // Create a string by keeping the length of string followed
    // by special character (#) and then the string
    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String str:strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString(); //10#helloumang5#World
    }

    // Special character will work as a separator and before
    // that number will tell how long is the string so you
    // can simply trim it using substr
    public List<String> decode(String str) {
        List<String>ans=new ArrayList<>();
        int i=0;
        int j=0;
        while(j<str.length()){
            if(str.charAt(j)=='#'){
                String len=str.substring(i,j);
                int size=Integer.parseInt(len);
                String subStr=str.substring(j+1,j+size+1);
                ans.add(subStr);
                i=j+size+1;
                j=i;
            }
            else j++;
        }
        return ans;
    }
}
