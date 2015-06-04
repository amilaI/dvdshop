package com.dvdshop.portello.serialization;

import com.strategicgains.restexpress.serialization.xml.DefaultXmlProcessor;

public class XmlSerializationProcessor
extends DefaultXmlProcessor
{
	public XmlSerializationProcessor()
    {
	    super();
	   /* alias("blog", Blog.class);
	    alias("blog_entry", BlogEntry.class);
	    alias("comment", Comment.class);
		*/registerConverter(new XstreamObjectIdConverter());
    }
}
