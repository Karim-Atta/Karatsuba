/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.lang.Math;

public class Main
{
	public static void main(String[] args) {
	    
	    System.out.println("multiple : "+ karatsuba(98, 567));
	}
	
	
	public static long karatsuba(int num1, int num2){
	    
	    if (num1 < 10 || num2 < 10) {
			return num1 * num2;
		}else{
		        
    	    int a, b, c, d;
    	    
    	    int num1Length = getNumLength(num1);
    	    int num2Length = getNumLength(num2);
    	    int minNumsLength = num1Length;
    	    int maxNumsLength = num2Length;
    	    
    	    if(num1Length >= num2Length){
    	        maxNumsLength = num1Length;
    	        minNumsLength = num2Length;
    	    }
    	  
            a = num1 / powerNum(10, (maxNumsLength / 2)); 
    	    b = num1 % powerNum(10, (maxNumsLength / 2));
    	    c = num2 / powerNum(10, (maxNumsLength / 2)); 
            d = num2 % powerNum(10, (maxNumsLength / 2));

    	    long x = karatsuba(a, c);
    	    long y = karatsuba(b, d);
    	    long z = karatsuba((a + b), (c + d)) - x - y;
    	
    	    return ((powerNum(10, minNumsLength) * x) + y + (powerNum(10, (minNumsLength / 2)) * z)); 
		}
	}
	

	public static boolean isNumEven(int num2Length){
	    boolean isNumEven = false;
	    if (num2Length  == (num2Length / 2) * 2)
	        isNumEven = true;
	  
	    return isNumEven;
	}
	
	public static int getNumLength(int num){
	    int length = 0;
	    while(num != 0){
	        num = num / 10; 
	        length++;
	    }
	    return length;
	}
	
    public static int powerNum(int num, int power){
        int result = num; 
        while(power != 1){
            result = result * num;
            power--;
        }
        return result;
    }
}


