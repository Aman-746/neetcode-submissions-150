class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int[] arr=new int[n1+n2];

        int left=0;
        int right=0;
        int k=0;

        while(left<n1 && right<n2){
            if(nums1[left]<nums2[right]){
                arr[k++]=nums1[left++];
            } 
            else{
                arr[k++]=nums2[right++];
            }
        }

        while(left<n1) arr[k++]=nums1[left++];
        while(right<n2) arr[k++]=nums2[right++];
        double res=0.0;
        if((n1+n2)%2!=0) res=arr[(n1+n2)/2];
        else res=(arr[(n1+n2)/2]+arr[(n1+n2)/2-1])/2.0;
        return res;
    }
}
