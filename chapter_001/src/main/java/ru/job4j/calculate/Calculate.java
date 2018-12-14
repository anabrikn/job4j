package ru.job4j.calculate;

/**
 * Класс для вывода приветствия в консоль
 * @author anna brik
 * @since 29.09.18
 * @version 1
 */

public class Calculate {
	/**
	* Main
	* @param args - args.
	*/
	
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	
	/**
     * Method echo.
     * @param name Your name.
     * @return Echo plus your name.
     */
	 
    public String echo(String name) {
        return "Echo, echo, echo : " + name;
    }
}