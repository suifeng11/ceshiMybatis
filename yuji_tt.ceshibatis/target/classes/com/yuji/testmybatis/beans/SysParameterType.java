package com.yuji.testmybatis.beans;

import java.util.List;

public class SysParameterType {


	private int id;

	private String typeName;

	private String typeDescribe;
	
	private List<SysParameter> pas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeDescribe() {
		return typeDescribe;
	}

	public void setTypeDescribe(String typeDescribe) {
		this.typeDescribe = typeDescribe;
	}

	public List<SysParameter> getPas() {
		return pas;
	}

	public void setPas(List<SysParameter> pas) {
		this.pas = pas;
	}
	
	
}