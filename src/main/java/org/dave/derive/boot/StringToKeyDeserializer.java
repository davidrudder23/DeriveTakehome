package org.dave.derive.boot;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class StringToKeyDeserializer extends StdDeserializer<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4125682947941595142L;


	public StringToKeyDeserializer() { 
        this(null); 
    } 
 
    public StringToKeyDeserializer(Class<?> vc) { 
        super(vc); 
    }
    

	@Override
	public String deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
