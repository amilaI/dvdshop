package com.dvdshop.portello;

import java.util.Properties;

public class Constants {
	/**
	 * These define the URL parmaeters used in the route definition strings
	 * (e.g. '{userId}').
	 */

	public static Properties PROPERTIES;

	public class Url {
		public static final String BLOG_ID = "blogId";
		public static final String BLOG_ENTRY_ID = "entryId";
		public static final String COMMENT_ID = "commentId";
		public static final String SAMPLE_ID = "sampleId";

	}

	/**
	 * These define the route names used in naming each route definitions. These
	 * names are used to retrieve URL patterns within the controllers by name to
	 * create links in responses.
	 */
	public class Routes {
		public static final String BLOG = "blog.route";
		public static final String BLOGS = "blog.collection.route";
		public static final String BLOG_ENTRY = "blog-entry.route";
		public static final String BLOG_ENTRIES = "blog-entry.collection.route";
		public static final String COMMENT = "comment.route";
		public static final String COMMENTS = "comment.collection.route";
		public static final String SINGLE_SAMPLE = "sample.single.route";
		public static final String SAMPLE_COLLECTION = "sample.collection.route";

	}

}
