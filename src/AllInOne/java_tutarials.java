package AllInOne;
import java.util.*;
  

public class java_tutarials {
	public static void main(String [] args) {
		
	Scanner s=new Scanner(System.in);
System.out.println("enter month");
		int a=s.nextInt();
		switch(a) {
		case 1:
		case 12:
		case 2:
			System.out.println("Season : winter");
			break;
		case 3:
		case 4:
		case 5:
		
			System.out.println("Season : spring");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("Season : rainy");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("Season : autumn");
			break;
		default :
			System.out.println("Invalid Season");
			break;
		}
		
		
	}
	

}
