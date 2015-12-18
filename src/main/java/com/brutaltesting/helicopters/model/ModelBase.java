package com.brutaltesting.helicopters.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class ModelBase implements IModel{
	public String toJson(){
		ObjectMapper mapper = new ObjectMapper();
		String str;
		try {
			str = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException("Couldn't convert toString to Json. "); 
		}
		return str;
	}


	@Override
	public String toString(){
		String str = toJson();
		return str;
		
	}
}
