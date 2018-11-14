package com.ly.study.thinkjava.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class AnnotationTest {
	public static void main(String[] args) throws Exception {
		Class<?> clazz = FieldBeReflected.class;
		Field fName = clazz.getDeclaredField("name");
		Class<?> clazz2 = fName.getDeclaringClass();
		System.out.println(clazz2);

	}

	public static void func() {

	}
}

class FieldBeReflected {
	private static String name;
	private static String name1;
	private boolean mBoolean = true;
	private final byte mByte = 111;
	private static final short mShort = 22;
	protected static int mInt;
	protected static long mLong;
	protected static float mFloat;
	protected static double mDouble;
	public static char mChar;

}

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.FIELD })
@interface MyAnnotation {

}
