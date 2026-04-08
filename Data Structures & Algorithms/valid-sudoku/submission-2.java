class Solution {
    public boolean isValidSudoku(char[][] board) {
        // loop for row
        for(int i=0;i<9;i++){
            Set<Character>st=new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(st.contains(board[i][j])) {
                        System.out.println("first");
                        return false;
                    }
                    else st.add(board[i][j]);
                }
            }
        }

        // loop for column
        for(int i=0;i<9;i++){
            Set<Character>st=new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[j][i]!='.'){
                    if(st.contains(board[j][i])){
                        System.out.println("second");
                        return false;
                    } 
                    else st.add(board[j][i]);
                }
            }
        }
        //for k=0,1,2-i should start from 0
        //for k=3,4,5-i should start from 3
        //for k=6,7,8-i should start from 6

        //for k=0,3,6-j should start from 0
        //for k=1,4,7-j should start from 3
        //for k=2,5,8-j should start from 6
        for(int k=0;k<9;k++){
            Set<Character>st=new HashSet<>();
            for(int i=k/3*3;i<(k/3)*3+3;i++){
                for(int j=(k%3)*3;j<(k%3)*3+3;j++){
                    if(board[i][j]!='.'){
                        if(st.contains(board[i][j])) {
                            System.out.println("third");
                            return false;
                        }
                        else st.add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }
}

