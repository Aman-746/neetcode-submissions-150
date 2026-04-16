class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>>row_map=new HashMap<>();
        Map<Integer,Set<Character>>col_map=new HashMap<>();
        Map<String,Set<Character>>square_map=new HashMap<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c=board[i][j];
                if(c=='.') continue;
                
                String square_key=(i/3)+","+(j/3);

                if(row_map.computeIfAbsent(i,k->new HashSet<>()).contains(c) || 
                col_map.computeIfAbsent(j,k->new HashSet<>()).contains(c) ||
                square_map.computeIfAbsent(square_key,k->new HashSet<>()).contains(c)) return false;

                row_map.get(i).add(c);
                col_map.get(j).add(c);
                square_map.get(square_key).add(c);

            }
        }
        return true;
    }
}
