package pe.com.examen.test;

import java.util.Scanner;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		/*int acumMayor=0;
		int acumMenor=0;
		
		System.out.println("Ingrese cantidad de personas:");
		int cant=sc.nextInt();
		for(int i=0;i<cant;i++){
			System.out.print("Ingrese edad: ");
			int edad=sc.nextInt();
				if(edad>=18){
					acumMayor=acumMayor+1;
				}else{
					acumMenor=acumMenor+1;
				}
		}
		
		if(acumMayor>0){
			System.out.println("La cantidad de personas mayores de edad son: "+acumMayor);
		}else{
			System.out.println("No hay personas mayores de edad");
		}
		
		if(acumMenor>0){
			System.out.println("La cantidad de personas menores de edad son: "+acumMenor);
		}else{
			System.out.println("No hay personas menores de edad");
		}*/
	/*	System.out.println("Ingrese numero: ");
		int numero=sc.nextInt();
		int result=1;
		for(int i=1;i<=numero;i++){
			result=result*i;			
		}
		System.out.println("El resulado es: "+result);*/
		
		System.out.println("Ingrese palabra: ");
		String palabra=sc.nextLine();
		int longitud=palabra.length();
		String str=palabra.substring(1,4);
		System.out.println(str);
		System.out.println(longitud);
		
	}

}
