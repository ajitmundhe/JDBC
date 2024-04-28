package jdbc_person;

import java.sql.ResultSet;
import java.util.Scanner;

public class PersonMain {

	public static void main(String[] args) throws Exception {

		while (true) {
              boolean exit=false;
			System.out.println("Welcome!!! \n1.SignUp\n2.Login\n3.Exit");
			PersonCRUD personCRUD = new PersonCRUD();
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the id of person");
				int id = scanner.nextInt();

				System.out.println("Enter the name of person");
				String name = scanner.next();

				System.out.println("Enter the phone of person");
				long phone = scanner.nextLong();

				System.out.println("Enter the email of person");
				String email = scanner.next();

				System.out.println("Enter the password of person");
				String password = scanner.next();

				Person person = new Person();
				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				person.setEmail(email);
				person.setPassword(password);

				int result = personCRUD.signUpPerson(person);
				if (result != 0) {
					System.out.println("Registered Sucessfully");
				} else {
					System.out.println("Not Registered Sucessfully");
				}
			}

				break;

			case 2: {
				// validation of user
				System.out.println("Enter the email of person");
				String email = scanner.next();

				System.out.println("Enter the password of person");
				String password = scanner.next();

				String dbPassword = personCRUD.loginPerson(email);

				if (dbPassword != null) {

					if (dbPassword.equals(password)) {
						System.out.println("Login sucessful");

						while (true) {
							boolean logout=false;
							System.out.println("Select\n1.Display Data\n2.Change Password\n3.Delete Account\n4.Logout");
							int choice1 = scanner.nextInt();
							switch (choice1) {
							case 1:{
								
								Person person=personCRUD.showData(email);
								System.out.println("ID :"+person.getId());
								System.out.println("Name :"+person.getName());
								System.out.println("Phone :"+person.getPhone());
								System.out.println("Email :"+person.getEmail());
								System.out.println("Password :"+person.getPassword());
								break;
							}
								
							case 2:
							{
								System.out.println("Enter the new password");
								String newPassword=scanner.next();
								
							    int result=	personCRUD.changePassword(newPassword, email);
							    if(result!=0)
							    {
							    	System.out.println("Password change sucessfully");
							    }
							    else
							    {
							    	System.out.println("Something went wrong");
							    }
							    break;
							}
							case 3:
							{
								int result=personCRUD.deleteAccount(email);
								if(result!=0)
								{
									System.out.println("Account Deleted");
								}
								else
								{
									System.out.println("Something went wrong");
								}
								break;
							}
							
							case 4:{
								   logout=true;
								   break;
							}
							
							default:
								break;
							}
							if(logout) {
								break;
							}
						}

					} else {
						System.out.println("Incorrect Password");
					}
				} else {
					System.out.println("User not Registered");
				}

			}
				break;
			case 3: {
                    exit=true;
			}
				break;
			default: {
				System.out.println("Invalid Option");
			}
				break;
			}
			if(exit)
			{
				break;
			}
       
		}
	}
}
