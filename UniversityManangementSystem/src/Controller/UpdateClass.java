package Controller;

import java.util.Scanner;

import Database.Database;
import Management.Operation;

public class UpdateClass implements Operation {

	@Override
	public void oper(Database database, Scanner scanner,int id) {
		System.out.println("Enter Class ID (-1 to show all classes):");
		int ID = scanner.nextInt();
		while (ID<0) {
			new ReadClasses().oper(database, scanner,id);
			System.out.println("Enter Class ID (-1 to show all classes):");
			ID = scanner.nextInt();
		}
		
		Management.Class c = new Management.Class(ID, database);
		
		scanner.nextLine();
		
		System.out.println("Enter Class Name (-1 to keep "+c.GetName()+"):");
		String name = scanner.nextLine();
		if (!name.equals("-1")) c.SetName(name);
		
		c.update(database);
	}

}
