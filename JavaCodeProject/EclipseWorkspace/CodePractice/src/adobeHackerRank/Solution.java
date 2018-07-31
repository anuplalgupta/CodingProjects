package adobeHackerRank;
//print all single and multiline comments for an multiline c,c++,java source code
/*example input*/

/*This is a program to calculate area of a circle after getting the radius as input from the user  
#include <stdio.h>
int main()  
{  
   double radius,area;//variables for storing radius and area  
   printf("Enter the radius of the circle whose area is to be calculated\n");  
   scanf("%lf",&radius);//entering the value for radius of the circle as float data type  
   area=(22.0/7.0)*pow(radius,2);//Mathematical function pow is used to calculate square of radius  
   printf("The area of the circle is %lf",area);//displaying the results  
}  
A test run for the program was carried out and following output was observed  
If 50 is the radius of the circle whose area is to be calculated
The area of the circle is 7857.1429*/


import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		boolean continuePrinting = false;
		while(true) {
			String line = input.nextLine();
			line.trim();
			if(line == null || line.equals(""))
				break;
			
			if(continuePrinting == true)
				System.out.println(line);
			
			int startCommentMultiline = line.indexOf("/*");
			if(startCommentMultiline != -1) {
				continuePrinting = true;
				System.out.println(line);
			}
			int endCommentMultiLine = line.indexOf("*/");
			if(endCommentMultiLine != -1) {
				continuePrinting = false;
			}
			
			String[] codeLine = line.split("//");
			if(codeLine.length > 1)
				System.out.println("//"+codeLine[1]);
			
		}
	}

}
