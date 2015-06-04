package com.dvdshop.portello.domain.event;

public class ObjectCreatedEvent
extends StateChangeEvent
{
	public ObjectCreatedEvent(Object data)
	{
		super(StateChange.CREATED, data);
	}
}
