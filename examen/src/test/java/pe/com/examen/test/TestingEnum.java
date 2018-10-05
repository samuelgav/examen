package pe.com.examen.test;

public class TestingEnum {
	
	public static void main(String args[]){
		for(SexoEnum s:SexoEnum.values()){
			System.out.println("Key: "+s.getKey()+" Values: "+s.getValue());
		}
		System.out.println(SexoEnum.FEMENINO.getKey());
	}
}
