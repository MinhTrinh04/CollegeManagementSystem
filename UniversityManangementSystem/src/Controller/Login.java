package Controller;

import Model.Database;
import java.util.Scanner;

public class Login {

		public static void main(String[] args) {
			new UpdateClass().oper(new Database(), new Scanner(System.in));
		}
}
