package MainApplication;
import java.io.IOException;
import java.util.Scanner;

import ToDoList.To_do_list;
import UserManagement.userManagement;


public class ApplicationMain {

	public static void main(String args[]) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		boolean CanIKeepRunTheProgram = true;
		
        System.out.println("** WELCOME TO APPLICATION MANAGMENT **");
		
		System.out.println(" Enter the login name : ");
		String login = scan.nextLine();
		System.out.println(" Enter the Password : ");
		String password = scan.nextLine();
		
		if(!userManagement.validateUserandPassword(login, password))
		{
			System.out.println(" !!! Login Failed !!! Close The Application ");
			return;
		}

		while (CanIKeepRunTheProgram == true ){
			
		    System.out.println(" ** WELCOME TO Shop MANAGMENT ** ");
			System.out.println(" 1.User Managment ");
			System.out.println(" 2.List Managment ");
			System.out.println(" 3.Quit ");
			
			int optionselectedbyuser = scan.nextInt();
			
			if(optionselectedbyuser == 1)
			{
			userManagement.UserManagment();
			}
			else if(optionselectedbyuser == 2)
			{
				To_do_list.To_Do_List();
			}
			else if(optionselectedbyuser == 3)
			{
				break;
			}
		}
	}

	
}










