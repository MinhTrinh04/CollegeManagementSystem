package Management;

import java.util.Scanner;

import Database.Database;

public interface Operation {
	
	abstract void oper(Database database, Scanner scanner,int ID);

}
