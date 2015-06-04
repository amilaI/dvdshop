package com.dvd.prop;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropReader {

	//will return the property of connection
	public boolean getConnectionProp() {

		Properties prop = new Properties();
		InputStream input = null;
		boolean isservicecon = false;

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			System.out.println(prop.getProperty("serviceconnection"));

			if (prop.getProperty("serviceconnection").equals("on")) {

				isservicecon = true;

			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return isservicecon;
	}

}
