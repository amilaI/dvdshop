package com.dvdshop.portello.handler;

import com.dvdshop.portello.domain.event.ObjectCreatedEvent;

/**
 * @author toddf
 * @since Feb 4, 2013
 */
public class ObjectCreatedPublisher
extends StateChangePublisher
{
	@Override
	public void handle(Object event) throws Exception
	{
		// TODO Auto-generated method stub
	}

	@Override
	public boolean handles(Class<?> type)
	{
		return ObjectCreatedEvent.class.isAssignableFrom(type);
	}
}
