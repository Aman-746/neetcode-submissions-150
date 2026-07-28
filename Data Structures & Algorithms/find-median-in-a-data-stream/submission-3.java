class MedianFinder {
    List<Integer>li;
    public MedianFinder() {
        li=new ArrayList<>();
    }
    
    public void addNum(int num) {
        int n=li.size();
        if(n==0){
            li.add(num);
            return;
        }
        
        int start=0;
        int end=n;
        while(start<end){
            int mid=start+(end-start)/2;
            if(num>li.get(mid)) start=mid+1;
            else end=mid;
        }
        li.add(start,num);
    }
    
    public double findMedian() {
        int n=li.size();
        double res=0;
        if(n%2==0) res=((li.get(n/2-1))+(li.get(n/2)))/2.0;
        else res=li.get(n/2);
        return res;
    }
}
