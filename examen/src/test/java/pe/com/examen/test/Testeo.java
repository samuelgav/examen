package pe.com.examen.test;

import java.util.Scanner;

public class Testeo {

	private static final Scanner sc=new Scanner(System.in);
	private static int opcion=-1;
	private static int numero;
	private static String respuesta="";
	
	public static void main(String[] args) {
		while(opcion !=0){
			try {
				System.out.println("-----MENU------");
				System.out.println("1. Dar numero");
				System.out.println("0. Salir");
				System.out.println("Ingrese una opcion: ");
				opcion=Integer.parseInt(sc.nextLine());
				switch (opcion) {
				case 1:
					System.out.println("Ingrese un numero: ");
					numero=Integer.parseInt(sc.nextLine());
					if(numero==1){
						System.out.println("es una linea");
					}else if(numero ==3){
						System.out.println("es un triangulo");
					}else if(numero ==4){
						System.out.println("es un cuadrado");
					}else{
						System.out.println("es otro tipo de figura");
					}
					break;
				case 0:
					System.out.println("Usted ha salido!!");
					break;
				default:
					System.out.println("Opcion Erronea!!");
					break;
				}
				
			} catch (Exception e) {
				System.out.println("Error!!");
			}
		}		
	}

}
