package designpattern.mediator;

import java.util.ArrayList;
import java.util.List;

public class JavaQQqun implements QQqun {
	private List<Person> users = new ArrayList<>();

	public void addPerson(Person person) {
		users.add(person);
	}
	
	@Override
	public void exchange(Person person, String message) {
		person.talk(person.name + ": " + message);
	}
	
}
