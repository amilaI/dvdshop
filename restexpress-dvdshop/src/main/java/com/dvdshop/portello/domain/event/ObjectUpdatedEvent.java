package com.dvdshop.portello.domain.event;

public class ObjectUpdatedEvent
extends StateChangeEvent
{
	public ObjectUpdatedEvent(Object after)
	{
		super(StateChange.UPDATED, after);
	}
}
