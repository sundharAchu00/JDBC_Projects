package edu.jsp.vaishuUpcasting;//package Name
//Driver Class
public class Driver {
	public static void main(String[] args) {
		Upcasting u1 = new Upcasting1();  //!upcasting reference variable u1 is parent class variable
		System.out.println(u1.name); //!we cannot access child class members with the help of parent reference
		Upcasting1 u2 = (Upcasting1) u1; //!so, we go for Downcasting (Upcasting1) --> act as a typecasting operator
		System.out.println(u2.a);
		
	}
}

//upcasting classes

package edu.jsp.vaishuUpcasting;//package Name

//Parent Class
public class Upcasting {
	
	String name = "vaishu";
}
//Child Class
class Upcasting1 extends Upcasting{
	int a = 5;
}
