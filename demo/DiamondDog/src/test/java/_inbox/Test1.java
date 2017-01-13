package _inbox;

public class Test1 {
 
    public static void changeStr(String str){
        str="welcome";
    }
    public static void changeInteger(Integer integer){
    	integer = 2;
    }
    public static void main(String[] args) {
 
        String str="1234";
        changeStr(str);
        System.out.println(str);
        Integer integer = new Integer(11111);
        changeInteger(integer);
        System.err.println(integer == 11111);
        while (true){
        	Test1 i =  new Test1();
        }
    }
}