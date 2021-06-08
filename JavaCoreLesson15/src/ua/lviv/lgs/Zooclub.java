package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Zooclub {
	Map<Person, ArrayList<Animal>> zooclub = new HashMap<Person, ArrayList<Animal>>();

	public void addMember() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the participant:");
		String name = scanner.next();
		System.out.println("Enter the age of the participant:");
		int age = scanner.nextInt();

		Person zooclubMember = new Person(name, age);
		System.out.println(zooclubMember.toString() + " successfully added");
	}

	public void addPet() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the participant:");
		String name = scanner.next();
		System.out.println("Enter the age of the participant:");
		int age = scanner.nextInt();

		boolean typeCorrect = isZooClubMemberExists(zooclub, name, age);
		if (typeCorrect) {
			scanner = new Scanner(System.in);
			System.out.println("Enter the pet type(cat/dog/...):");
			String type = scanner.next();
			System.out.println("Enter the pet's name:");
			String nameOfAnimal = scanner.next();

			Animal newAnimal = new Animal(type, nameOfAnimal);
			Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooclub.entrySet().iterator();

			while (iterator.hasNext()) {
				Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

				if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
					ArrayList<Animal> animalList = nextMember.getValue();

					animalList.add(newAnimal);
					System.out.println(newAnimal.toString() + " successfully added to " + nextMember.getKey());
				}
			}
		} else {
			System.out.println("Entered incorrectly");
		}

	}

	public void removePet() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the pet type(cat/dog/...):");
		String type = scanner.next();
		System.out.println("Enter the pet's name:");
		String nameOfAnimal = scanner.next();
		System.out.println("Enter the name of the participant:");
		String name = scanner.next();
		System.out.println("Enter the age of the participant:");
		int age = scanner.nextInt();
		boolean typeCorrect = isZooClubMemberAnimalExists(zooclub, name, age, type, nameOfAnimal);
		if (typeCorrect) {

			Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooclub.entrySet().iterator();

			while (iterator.hasNext()) {
				Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

				if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
					ArrayList<Animal> animalList = nextMember.getValue();

					Iterator<Animal> iterator2 = animalList.iterator();

					while (iterator2.hasNext()) {
						Animal next2 = iterator2.next();

						if (next2.getType().equalsIgnoreCase(type)
								&& next2.getNameOfAnimal().equalsIgnoreCase(nameOfAnimal)) {
							iterator2.remove();
							System.out.println("Member " + next2.toString() + " succsessfuly removed an animal "
									+ nextMember.getKey() + "!");
						}
					}
				} else {
					System.out.println("Its Empty");
				}
			}

		} else {
			System.out.println("Somthing vrong in the data thats entring");
		}

	}

	public void removeMember() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the participant:");
		String name = scanner.next();
		System.out.println("Enter the age of the participant:");
		int age = scanner.nextInt();
		boolean typeCorrect = isZooClubMemberExists(zooclub, name, age);
		if (typeCorrect) {
			Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooclub.entrySet().iterator();

			while (iterator.hasNext()) {
				Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

				if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
					iterator.remove();
					System.out.println(nextMember.getKey().toString() + " successfuly removed!");
				}
			}
		} else {
			System.out.println("Something is wrong with the data being entered !");
		}
	}

	public void removeAnimalFromAllMembers() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the type of pet");
		String type = scanner.next();
		Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooclub.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

			ArrayList<Animal> animalList = nextMember.getValue();

			Iterator<Animal> iterator2 = animalList.iterator();

			while (iterator2.hasNext()) {
				Animal next2 = iterator2.next();

				if (next2.getType().equalsIgnoreCase(type)) {
					iterator2.remove();
					System.out.println(
							"Pet " + next2.toString() + " successfully removed from " + nextMember.getKey() + "!");
				}
			}
		}

	}

	public void getZooclub() {
		Set<Entry<Person, ArrayList<Animal>>> zooclubMembers = zooclub.entrySet();

		System.out.println(" sdf:");
		for (Entry<Person, ArrayList<Animal>> entry : zooclubMembers) {
			System.out.println("Person " + entry.getKey() + " has pet(s) " + entry.getValue());
		}
	}

	static boolean isZooClubMemberExists(Map<Person, ArrayList<Animal>> zooclub, String name, int age) {
		boolean flag = false;

		Set<Entry<Person, ArrayList<Animal>>> zooclubMembers = zooclub.entrySet();

		for (Entry<Person, ArrayList<Animal>> entry : zooclubMembers) {
			if (entry.getKey().getName().equalsIgnoreCase(name) && entry.getKey().getAge() == age) {
				flag = true;
			}
		}

		return flag;
	}

	static boolean isZooClubMemberAnimalExists(Map<Person, ArrayList<Animal>> zooclub, String name, int age,
			String type, String nameOfAnimal) {
		boolean flag = false;

		Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooclub.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

			if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
				ArrayList<Animal> animalList = nextMember.getValue();

				Iterator<Animal> iterator2 = animalList.iterator();

				while (iterator2.hasNext()) {
					Animal next2 = iterator2.next();

					if (next2.getType().equalsIgnoreCase(type)
							&& next2.getNameOfAnimal().equalsIgnoreCase(nameOfAnimal)) {
						flag = true;
					}
				}
			}
		}

		return flag;
	}

}
