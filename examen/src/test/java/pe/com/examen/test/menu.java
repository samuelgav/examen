package pe.com.examen.test;

import java.util.Scanner;

public class menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Ingrese cantidad de numero: ");
		int numero=sc.nextInt();
		String[] num=new String[numero];
		for(int i=0;i<num.length;i++){
			if(i%2==0){
				num[i]=i+" par";
			}else{
				num[i]=i+" impar";
			}
		}
		
		for(int i=0;i<num.length;i++){
			System.out.println(num[i]);
		}
		
	}

}
