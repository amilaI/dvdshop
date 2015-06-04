package com.dvdshop.portello.domain.event;

public class ObjectDeletedEvent
extends StateChangeEvent
{
	public ObjectDeletedEvent(Object data)
	{
		super(StateChange.DELETED, data);
	}
}
