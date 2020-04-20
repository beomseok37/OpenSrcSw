package gugudan;

import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("출력하고 싶은 단 입력: ");
		int dan = scan.nextInt();
		for(int i=1;i<=9;i++) {
			System.out.println(dan + " * " + i + " = " + (dan*i));
		}
	}

}
