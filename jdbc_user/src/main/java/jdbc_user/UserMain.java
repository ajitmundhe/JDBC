package jdbc_user;

import java.util.Scanner;

//import jdbc_person.Person;

public class UserMain {
    
	public static void main(String args[]) throws Exception
	{
		while(true)
		{
			boolean exit=false;
			System.out.println("Welcome!!!\n1.Sign Up\n2.Log In\n3.Exit");
			
			userCRUD userCrud=new userCRUD();
			Scanner scanner=new Scanner(System.in);
			int option=scanner.nextInt();
			switch (option) {
			case 1:
			{
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

				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setPhone(phone);
				user.setEmail(email);
				user.setPassword(password);
				
				int result = userCrud.signUp(user);
				if (result != 0) {
					System.out.println("Registered Sucessfully");
				} else {
					System.out.println("Not Registered Sucessfully");
				}
			
				break;
			}

			case 2:{
				System.out.println("Enter the email of person");
				String email = scanner.next();

				System.out.println("Enter the password of person");
				String password = scanner.next();
				
				String dbPassword = userCrud.login(email);

				if (dbPassword != null) {

					if (dbPassword.equals(password)) {
						System.out.println("Login sucessful");

						while (true) {
						     boolean logout=false;
							System.out.println("Select ther below option\n1.Show Password\n2.Update Password\n3.Log out");
							int ch=scanner.nextInt();
							
							switch (ch) {
							case 1:{
								   
								 User user=userCrud.showPassword(email);
								 
								 System.out.println("Facebook password :"+user.getFacebook());
								 System.out.println("Instagram password :"+user.getInstagram());
								 System.out.println("Snapchat password :"+user.getSnapchat());
								 System.out.println("Twitter password :"+user.getTwitter());
							}
								
								break;

							case 2:
							{
								System.out.println("which password want to update\n1.Facebook\n2.Instagram\n3.Snapchat\n4.Twitter");
								
								int ch1=scanner.nextInt();
								 
								switch(ch1)
								{
								case 1:{
									System.out.println("Enter the Facebook Password");
									String password1=scanner.next();
								  int result=userCrud.updateFacebook(email, password1);
								  
								  if(result!=0)
								  {
									  System.out.println("Password Updated");
								  }
								  else
								  {
									  System.out.println("Something went wrong");
								  }
								  break;
								}
								
								case 2:{
									System.out.println("Enter the Instagram Password");
									String password1=scanner.next();
								  int result=userCrud.updateInstagram(email, password1);
								  
								  if(result!=0)
								  {
									  System.out.println("Password Updated");
								  }
								  else
								  {
									  System.out.println("Something went wrong");
								  }
								  break;
								}
								
								
								case 3:{
									System.out.println("Enter the Snapchat Password");
									String password1=scanner.next();
								  int result=userCrud.updateSnapchat(email, password1);
								  
								  if(result!=0)
								  {
									  System.out.println("Password Updated");
								  }
								  else
								  {
									  System.out.println("Something went wrong");
								  }
								  break;
								}
								
								case 4:{
									System.out.println("Enter the Twitter Password");
									String password1=scanner.next();
								  int result=userCrud.updateTwitter(email, password1);
								  
								  if(result!=0)
								  {
									  System.out.println("Password Updated");
								  }
								  else
								  {
									  System.out.println("Something went wrong");
								  }
								  break;
								}
								
								
								default :{
									System.out.println("Invalid option");
								}
								}
								break;
							}
							
							case 3:{
								logout=true;
							}
							break;
							default:
								System.out.println("Invalid option");
								
								break;
							}
							
							if(logout)
							{
								break;
							}
							
						}

					} else {
						System.out.println("Incorrect Password want to reset");
						System.out.println("Enter the email of person");
										
						String email1 = scanner.next();
						
						System.out.println("Enter the new password");
						String newPassword=scanner.next();
						
					 int result=userCrud.updatePassword( email1,newPassword);
						
						if(result!=0)
						{
							System.out.println("Password Updated");
						}
						else {
							System.out.println("Something went wrong");
						}
						
					}
				} else {
					System.out.println("User not Registered");
				}
				break;
			}
			
			
				case 3:{
					exit=true;
					break;
				}
			
			default:{
	               System.out.println("Invalid option");
	               break;
			}
				
			}
			
			if(exit)
			{
				break;
			}
			
		}
	}
}
