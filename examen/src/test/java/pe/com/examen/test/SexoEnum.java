package pe.com.examen.test;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;

public enum SexoEnum {
	MASCULINO("M","Masculino"),
	FEMENINO("F","Femenino");
	
	private final String key;
	private final String value;
	
	private static List<SexoEnum> list=new ArrayList<>();
	private static HashMap<String,SexoEnum> lookup=new HashMap<>();
	
	static{
		for(SexoEnum s:EnumSet.allOf(SexoEnum.class)){
			list.add(s);
			lookup.put(s.getKey(),s);
		}		
	}
			
	private SexoEnum(String key,String value){
		this.key=key;
		this.value=value;
	}
	
	public String getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
	
	public static SexoEnum get(String key){
		SexoEnum s=lookup.get(key);
		return s;
	}
}
