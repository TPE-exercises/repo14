package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe1;

public class Livelock {

	private class Person extends Thread {

		private String name;
		private boolean goThroughtDoor;

		public Person(String name, boolean goThroughtDoor) {
			this.name = name;
			this.goThroughtDoor = goThroughtDoor;
		}

		public void openDoor(Door door, Person otherPerson) {

			while (wantToGoThroughtDoor()) {
				// Wenn jemand anderes durch die Tür möchte wartet die Person
				// solange.
				if (door.wantToGoThrought() != this) {

					System.out.println(
							"waiting for " + door.wantToGoThrought().getPersonName() + " to go throught the door");

					try {
						sleep(10);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
						return;
					}
				}

				// Wenn jemand anderes durch die Tür möchte lässt man ihm den
				// Vortritt.
				if (otherPerson.wantToGoThroughtDoor()) {
					System.out
							.println("let " + door.wantToGoThrought().getPersonName() + " first go throught the door");

					door.setWantToGoThrought(otherPerson);
				} else {
					// Will niemand anderes durch die Tür geht die Person durch,
					// ein Zustand der nie betreten wird, da beide Personen immer
					// dem anderen den Vortritt lassen.
					goThroughtDoor = false;
				}
			}
		}

		public boolean wantToGoThroughtDoor() {
			return goThroughtDoor;
		}

		public String getPersonName() {
			return name;
		}
	}

	private class Door {

		private Person wantToGoThrought;

		public Door(Person wantToGoThrought) {
			this.wantToGoThrought = wantToGoThrought;
		}

		public Person wantToGoThrought() {
			return wantToGoThrought;
		}

		public synchronized void setWantToGoThrought(Person wantToGoThrought) {
			this.wantToGoThrought = wantToGoThrought;
		}
	}

	public static void main(String[] args) {

		Person p1 = new Livelock().new Person("Person1", true);
		Person p2 = new Livelock().new Person("Person2", true);
		Door door = new Livelock().new Door(p1);

		new Thread() {
			@Override
			public void run() {
				p1.openDoor(door, p2);
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				p2.openDoor(door, p1);
			}
		}.start();
	}
}
