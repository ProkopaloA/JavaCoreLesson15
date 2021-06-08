package ua.lviv.lgs;

import java.util.Scanner;

public class Aplication {
	static void menu() {
		System.out.println("Press 1 to Add a club member");
		System.out.println("Press 2 to Add a pet to a club member");
		System.out.println("Press 3 to Remove the pet from the club member");
		System.out.println("Press 4 to Remove a member from the club");
		System.out.println("Press 5 to Remove a specific pet from all owners");
		System.out.println("Press 6 to Display a zoo club");
		System.out.println("Press 6 to Exit the program");
	}
public static void main(String[] args) {
	Zooclub zooclub = new Zooclub();
	Scanner scanner = new Scanner(System.in);

	while (true) {
		menu();

		switch (scanner.nextInt()) {

		case 1: {
			zooclub.addMember();;
			break;
		}

		case 2: {
			zooclub.addPet();
			break;
		}

		case 3: {
			zooclub.removePet();
			break;
		}

		case 4: {
			zooclub.removeMember();
			break;
		}

		case 5: {
			zooclub.removeAnimalFromAllMembers();
			break;
		}

		case 6: {
			zooclub.getZooclub();;
			break;
		}

		case 0: {
			System.exit(0);
			break;
		}

		default: {
			System.out.println("Something is wrong with the data being entered");
			break;
		}
		}
	}		
}
}
