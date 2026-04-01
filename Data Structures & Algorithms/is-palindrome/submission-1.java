class Solution {
    public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<right){
            char leftChar=s.charAt(left);
            char rightChar=s.charAt(right);

            if(Character.isLetterOrDigit(leftChar) && Character.isLetterOrDigit(rightChar)){
                if(Character.isAlphabetic(leftChar) && Character.isAlphabetic(rightChar)){
                    if(Character.toLowerCase(leftChar)!=Character.toLowerCase(rightChar)) return false;
                    left++;
                    right--;
                }
                else if(Character.isDigit(leftChar) && Character.isDigit(rightChar)){
                    if(leftChar!=rightChar) return false;
                    left++;
                    right--;
                }
                else return false;
            }

            if(!Character.isLetterOrDigit(leftChar)) left++;
            if(!Character.isLetterOrDigit(rightChar)) right--;
        }
        return true;
    }
}
