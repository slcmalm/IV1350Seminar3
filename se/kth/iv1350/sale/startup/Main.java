package se.kth.iv1350.sale.startup;

import se.kth.iv1350.sale.integration.ExternalSystemCreator;
import se.kth.iv1350.sale.controller.Controller;
import se.kth.iv1350.sale.view.View;

/**
 * Contains the main method which starts the application and initializes...
 *
 */

public class Main {


	/**
	 * The main method which starts the application 
	 * and initializes...
	 * @param args The program does not take in any command line parameters.
	 */
	public static void main(String[] args) {
		ExternalSystemCreator externalSystems = new ExternalSystemCreator();
		Controller contr =  new Controller(externalSystems);
		View view = new View(contr);
		view.SaleProcessExample();
	}

}
