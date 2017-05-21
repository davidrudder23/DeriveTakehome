package org.dave.derive.boot;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.googlecode.objectify.Key;

public class StringToKeyDeserializer extends StdDeserializer<Key<Object>> {
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
	public Key<Object> deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
		JsonNode node = jsonParser.getCodec().readTree(jsonParser);
		//String keyString = node.get(")
		// TODO Auto-generated method stub
		return null;
	}
	

}
