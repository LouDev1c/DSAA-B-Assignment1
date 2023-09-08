import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//行
        int m=sc.nextInt();//列
        int r=sc.nextInt();//第几行，不是指行下标
        int c=sc.nextInt();//第几列，不是指列下标
        sc.close();
        int[][] arr=new int[n][m];
        int left=0;//左方向
        int right=arr[0].length-1;//右方向
        int top=0;//上方向
        int bottom=arr.length-1;//下方向

        String direction="right";//要遍历的方向
        int temp=1;
        while(left<=right&&top<=bottom){
            if(direction.equals("right")){
                for(int i=left;i<=right;i++){
                    arr[top][i]=temp++;
                }
                //从左遍历到右边界，准备向下遍历，上面已经遍历完一行了，所以top++
                top++;
                direction="bottom";
            }else if(direction.equals("bottom")){
                for(int i=top;i<=bottom;i++){
                    arr[i][right]=temp++;
                }
                //从上遍历到下边界，准备向左遍历，右边已经遍历完一列了，所以right--
                right--;
                direction="left";
            }else if(direction.equals("left")){
                for(int i=right;i>=left;i--){
                    arr[bottom][i]=temp++;
                }
                //从右遍历到左边界，准备向上遍历，下面已经遍历完一行了，所以bottom--
                bottom--;
                direction="top";
            }else if(direction.equals("top")){
                for(int i=bottom;i>=top;i--){
                    arr[i][left]=temp++;
                }
                //从下遍历到上边界，准备向右遍历，左边已经遍历完一列了，所以left++
                left++;
                direction="right";
            }
        }
        System.out.println(arr[r-1][c-1]);
    }
}
