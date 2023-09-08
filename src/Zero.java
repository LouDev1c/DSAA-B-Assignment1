import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.*;

public class Zero {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        String file = "src/TestData.txt";
        String str = null;
        //读取文件
        try {
            //文件读取
            FileReader fr = new FileReader(file);
            //行读取
            LineNumberReader r = new LineNumberReader(fr);
            int number = 2;
            int lines = 0;
            String txt = "";
            //取得第二行一整行字符串
            while (txt != null) {
                lines++;
                txt = r.readLine();
                if (lines == number) {
                    str = txt;
                }
            }
            //将第二行按空格分开存到字符串数组strings中
            String[] strings = new String[0];
            if (str != null) {
                strings = str.split(" ");
            }
            //遍历strings，将其中元素改变数据类型后存入numbers
            for(String num : strings){
                numbers.add(Integer.parseInt(num));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //进行运算
        int count = 0;
        while(!numbers.isEmpty()){
            //判断0项并从numbers中移除
            for(int i = 0 ; i < numbers.size() ; i++){
                if(numbers.get(i)==0)    numbers.remove(numbers.get(i));
            }
            //若移除后数组为空则循环结束
            if(numbers.isEmpty())    break;
            //获取最小值
            int min = Collections.min(numbers);
            //原元素减去最小值后的结果替代原元素组成新的numbers
            for(int j = 0; j < numbers.size(); j++){
                if(numbers.get(j) == min){
                    numbers.remove(numbers.get(j));
                    j--;
                } else{
                    numbers.set(j, numbers.get(j) - min);
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
