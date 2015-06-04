/*
 * Copyright 2013, eCollege, Inc.  All rights reserved.
 */
package com.dvdshop.portello.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bson.types.ObjectId;

import java.io.IOException;

/**
 * @author fredta2
 * @since Feb 7, 2013
 */
public class ObjectIdSerializer
extends JsonSerializer<ObjectId>
{
	@Override
	public void serialize(ObjectId objectId, JsonGenerator json, SerializerProvider provider)
	throws IOException, JsonProcessingException
	{
		json.writeString(objectId.toString());
	}
}
