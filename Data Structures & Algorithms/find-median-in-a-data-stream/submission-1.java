class MedianFinder {
    List<Integer>li;
    public MedianFinder() {
        li=new ArrayList<>();
    }
    
    public void addNum(int num) {
        li.add(num);
        Collections.sort(li);
    }
    
    public double findMedian() {
        int n=li.size();
        double res=0;
        if(n%2==0) res=((li.get(n/2-1))+(li.get(n/2)))/2.0;
        else res=li.get(n/2);
        return res;
    }
}
