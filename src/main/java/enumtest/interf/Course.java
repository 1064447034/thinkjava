package enumtest.interf;

import enumtest.Enums;

public enum Course {
	APPETIZER(Food.Appetizer.class),
	MAINCOURSE(Food.MainCourse.class),
	DESSERT(Food.Dessert.class),
	COFFEE(Food.Coffee.class);
	
	private Food[] values;
	private Course(Class<? extends Food> kind) {
		values = kind.getEnumConstants();
	}
	
	public Food randSelect() {
		return Enums.random(values);
	}
	
	public static void main(String[] args) {

		for (int i = 0; i < 5; ++i) {
			for (Course course : Course.values()) {
				Food food = course.randSelect();
				System.out.println(food);
			}
			System.out.println("===================");
		}
	}
}
