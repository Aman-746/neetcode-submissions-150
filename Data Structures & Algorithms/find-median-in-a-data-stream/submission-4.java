class MedianFinder {

    private Queue<Integer> smallHeap; // smaller elements (maxHeap)
    private Queue<Integer> largeHeap; // larger elements (minHeap)

    public MedianFinder() {
        smallHeap=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        largeHeap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallHeap.add(num);
        if(smallHeap.size()>largeHeap.size()+1 || (!largeHeap.isEmpty() && smallHeap.peek()>largeHeap.peek())){
            largeHeap.add(smallHeap.poll());
        }
        if(largeHeap.size()>smallHeap.size()+1){
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if(smallHeap.size()==largeHeap.size()){
            return (double) (smallHeap.peek()+largeHeap.peek())/2;
        } else{
            if(smallHeap.size()>largeHeap.size()) return (double) smallHeap.peek();
            else return (double) largeHeap.peek();
        }
    }
}
