package com.ly.study.thinkjava.java8future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Employee {
	private Integer id;
	private Integer age;
	private String gender;
	private String firstName;
	private String lastName;

	public Employee(Integer id, Integer age, String gender, String fName, String lName) {
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.firstName = fName;
		this.lastName = lName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return this.id.toString() + " - " + this.age.toString();
	}
}

public class PredicateTest {
	public static void main(String[] args) {
		Predicate<Employee> emp = (p) -> p.getAge() > 20;

		Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
		Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
		Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
		List<Employee> employees = new ArrayList<Employee>();
		employees.addAll(Arrays.asList(new Employee[] { e1, e2, e3 }));
		
		employees.stream().filter(emp).collect(Collectors.toList());
		
		List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features.forEach(x->System.out.println(x));
		

		List<String> lst = Arrays.asList("123", "abc", "xyz");
		int[] a = {1, 20, 63, 58, 185, 60, 59, 20};
		Arrays.stream(a).filter(x->x > 50).forEach(n->System.out.print(n + " "));
		Arrays.stream(a).allMatch(p->p > 50);
		
		String[] s1 = {"qwer", "asdf", "zxcv", "fgh", "jum", "rfv"};
        String[] s2 = {"edc", "zse", "asdf", "zxcv", "yhnj"};
        Arrays.stream(s1).forEach(x->Arrays.stream(s2).filter(y->x.equals(y)).forEach(z->System.out.println(z)));
        
        Integer[] nums = {1, 20, 63, 58, 185, 60, 59, 20};
        Integer[] num2 = Arrays.stream(nums).map(n->n * 10).toArray(Integer[]::new);
        
	}
}
