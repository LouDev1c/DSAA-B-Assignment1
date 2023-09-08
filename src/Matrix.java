import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class Matrix {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int m = StdIn.readInt();
        int[][] arr = new int[n][m];
        arr[0][0] = 1;
        int x = 0 , y = 0;
        int sum = 1;
        while (sum < n*m) {
            //向下
            while (x+1 < n && arr[x+1][y] == 0) {
                arr[++x][y] = ++sum;
            }
            //向右
            while (y+1 < m && arr[x][y+1] == 0) {
                arr[x][++y] = ++sum;
            }
            //向上
            while (y-1 >= 0 && arr[x][y-1] == 0) {
                arr[x][--y] = ++sum;
            }
            //向左
            while (x-1 >= 0 && arr[x-1][y] == 0) {
                arr[--x][y] = ++sum;
            }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                StdOut.print(anInt);
                StdOut.print("\t");
            }
            StdOut.println();
        } //输出
    }
}
