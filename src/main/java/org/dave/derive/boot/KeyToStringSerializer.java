package org.dave.derive.boot;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.googlecode.objectify.Key;

public class KeyToStringSerializer extends JsonSerializer<Key<Object>> {


	@Override
	public void serialize(Key<Object> key, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
		jsonGenerator.writeObject(key.getClass().getName()+"("+key.getId()+")");
	}
}
