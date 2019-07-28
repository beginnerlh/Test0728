/*
我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"].
我们可以按下面的指令规则行动：
如果方格存在，'U' 意味着将我们的位置上移一行；
如果方格存在，'D' 意味着将我们的位置下移一行；
如果方格存在，'L' 意味着将我们的位置左移一列；
如果方格存在，'R' 意味着将我们的位置右移一列；
'!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。

示例 1：

输入：target = "leet"
输出："DDR!UURRR!!DDD!"
示例 2：

输入：target = "code"
输出："RR!DDRR!UUL!R!"
*/
package lianxi0728;

public class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.alphabetBoardPath("zdz"));
    }
}

class Solution {
    public String alphabetBoardPath(String target) {
        StringBuffer str = new StringBuffer();
        int n = 0;
        int m = 0;
        for(int i = 0;i<target.length();i++){
            char c = target.charAt(i);
            if(c == 'z'){

                int a = (c-97)/5;//行
                int b = (c-97) %5;//列
                if(b - m>0){
                    int j = b-m;
                    while(j>0){
                        str.append("R");
                        j--;
                    }
                }else if(m-b>0){
                    int j = m-b;
                    while(j>0){
                        str.append("L");
                        j--;
                    }
                }


                if(a - n>0){
                    int j = a-n;
                    while(j>0){
                        str.append("D");
                        j--;
                    }
                }else if(n-a>0){
                    int j = n-a;
                    while(j>0){
                        str.append("U");
                        j--;
                    }
                }
                str.append("!");
                n = a;
                m = b;

            }else{
                int a = (c-97)/5;//行
                int b = (c-97) %5;//列
                if(a - n>0){
                    int j = a-n;
                    while(j>0){
                        str.append("D");
                        j--;
                    }
                }else if(n-a>0){
                    int j = n-a;
                    while(j>0){
                        str.append("U");
                        j--;
                    }
                }

                if(b - m>0){
                    int j = b-m;
                    while(j>0){
                        str.append("R");
                        j--;
                    }
                }else if(m-b>0){
                    int j = m-b;
                    while(j>0){
                        str.append("L");
                        j--;
                    }
                }

                str.append("!");
                n = a;
                m = b;
            }

        }
        return str.toString();
    }
}