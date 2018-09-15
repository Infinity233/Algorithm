class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] nums = new int[10];
        for (int i = 0; i < 9; i++) {
            init(nums);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                int cNum = board[i][j] - '0';
                nums[cNum]++;
                if (nums[cNum] > 1) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            init(nums);
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.')
                    continue;
                int c = board[j][i] - '0';
                nums[c]++;
                if (nums[c] > 1) {
                    return false;
                }
            }
        }
        int tx, ty;
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                init(nums);
                for (int k = 0; k < 3; k++) {
                    for (int z = 0; z < 3; z++) {
                        tx = i + k;
                        ty = j + z;
                        if (board[tx][ty] == '.')
                            continue;
                        int c = board[tx][ty] - '0';
                        nums[c]++;
                        if (nums[c] > 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void init(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValidSudoku(new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
    }
}