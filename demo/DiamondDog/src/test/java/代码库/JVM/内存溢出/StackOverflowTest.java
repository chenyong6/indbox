package 代码库.JVM.内存溢出;

/**
* 线程操作栈溢出
*
* 参数：-Xms5m -Xmx5m -Xmn2m -XX:NewSize=1m -Xss64k
*
*/
public class StackOverflowTest {
   
    public static void main(String[] args) {
        int i =0;
        recursion(i);
    }
   
    private static void recursion(int i){
        System.out.println(i++);
       // String[] s = new String[Integer.MAX_VALUE];
        recursion(i);
    }

}
