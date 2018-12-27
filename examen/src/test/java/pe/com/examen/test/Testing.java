package pe.com.examen.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



public class Testing {

	public static void main(String[] args) {
		
		
		int[] a={1,2,3};
		int[] b={2,3};
		for(int i=0;i<a.length;i++){
			for(int j=0;j<b.length;j++){
				if(a[i]==b[j]){
					System.out.println(a[i]);
				}
			}
		}
		
		List<HashMap<String,String>> list=new ArrayList<>();
		List<Categoria> cat=new ArrayList<>();
		cat.add(new Categoria("categoria 1"));
		cat.add(new Categoria("categoria 2"));
		cat.add(new Categoria("categoria 3"));
		
		HashMap<String, String> hm;		
		for(int i=0;i<cat.size();i++){
			Categoria c=(Categoria) cat.get(i);
			String id=String.valueOf(c.getIdcategoria());
			String descripcion=c.getDescripcion();
			hm=new HashMap<>();
			hm.put("id", id);
			hm.put("descripcion", descripcion);
			list.add(hm);
		}
		System.out.println();
		for(HashMap<String,String> h: list){
			System.out.println(h.get("id")+" "+h.get("descripcion"));
		}
		
		
	}

}
class Categoria{
	private final int idcategoria;
	private static int acum;
	private String descripcion;
	
	private Categoria(){
		this.idcategoria=++acum;
	}
	
	public Categoria(String descripcion){
		this();
		this.descripcion=descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdcategoria() {
		return idcategoria;
	}
	
	
}