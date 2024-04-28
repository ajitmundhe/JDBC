package jdbc_library_management_system;

import java.util.Scanner;

public class libraryMain {

	public static void main(String args[]) throws Exception {
		while (true) {
			boolean exit = false;
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome!!!\n1.Sign Up\n2.Log In\n3.Exiti");
			int choice = scanner.nextInt();
			libraryCRUD libraryCRUD = new libraryCRUD();
			switch (choice) {
			case 1: {
				System.out.println("Enter the id of user");
				int id = scanner.nextInt();
				System.out.println("Enter the name of user");
				String name = scanner.next();

				System.out.println("Enter the phone of user");
				long phone = scanner.nextLong();

				System.out.println("Enter the email of user");
				String email = scanner.next();

				System.out.println("Enter the password of user");
				String password = scanner.next();

				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setPhone(phone);
				user.setEmail(email);
				user.setPassword(password);

				int result = libraryCRUD.signUp(user);
				if (result != 0) {
					System.out.println("Registered Sucessfully");
				} else {
					System.out.println("Not Registered Sucessfully");
				}
				break;
			}

			case 2: {

				System.out.println("Enter the email of user");
				String email = scanner.next();

				System.out.println("Enter the password of user");
				String password = scanner.next();

				String dbPassword = libraryCRUD.login(email);

				if (dbPassword != null) {
					if (dbPassword.equals(password)) {
						System.out.println("Login sucessfully");
						System.out.println(
								"Select the option\n1.Add Book\n2.Find book by id \n3.Find book by name \n4.Find book by author \n5.Find book gener \n6.Delete book  by Id \n7.Delete book by name \n8.Update book by id \n9.Log Out ");

						int choice3 = scanner.nextInt();
						switch (choice3) {
						case 1: {
							System.out.println("Enter the id of book");
							int id = scanner.nextInt();

							System.out.println("Enter the name of book");
							String name = scanner.next();

							System.out.println("Enter the author of book");
							String author = scanner.next();

							System.out.println("Enter the gener of book");
							String gener = scanner.next();

							Book book = new Book();
							book.setId(id);
							book.setName(name);
							book.setAuthor(author);
							book.setGener(gener);

							int res = libraryCRUD.addBook(book);
							if (res != 0) {
								System.out.println("Book added sucessfully");
							} else {
								System.out.println("Something went wrong");
							}

							break;
						}

						default:
							break;
						}

					} else {
						System.out.println("Password Incorrect.Reset Now");

						System.out.println("Enter the email of user");
						String email1 = scanner.next();

						System.out.println("Enter the email of user");
						String password1 = scanner.next();

						int result = libraryCRUD.updatePassword(email1, password1);
						if (result != 0) {
							System.out.println("Pasword updated");
						} else {
							System.out.println("Something went wrong");
						}

					}
				} else {
					System.out.println("User not Registered");
				}
				break;
			}

			case 3: {
				exit = true;
				break;
			}

			default: {
				System.out.println("Invalid option");
				break;
			}

			}
			if (exit) {
				break;
			}
		}
	}
}
