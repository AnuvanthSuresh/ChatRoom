package com.dao.database;



public class Authenticate {

	// Authentication
	public Boolean Auth(String uname, String pass) {

		if (uname.equalsIgnoreCase("TU1") && pass.equalsIgnoreCase("pass123")) {
			System.out.println("TU1 logged");
			return true;
			
		} else if (uname.equalsIgnoreCase("TU2") && pass.equalsIgnoreCase("pass321")) {
			System.out.println("TU2 logged");
			return true;
		} else {
			System.out.println("logger failed");
			return false;
		}

	}

}
