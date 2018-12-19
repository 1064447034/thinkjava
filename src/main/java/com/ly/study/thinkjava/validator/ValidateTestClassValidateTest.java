package com.ly.study.thinkjava.validator;

public class ValidateTestClassValidateTest {
	public static void main(String[] args) {
		ValidateTestClass validateTestClass = new ValidateTestClass();
		validateTestClass.setReason("12");

		validateTestClass.validateParams(); // 调用验证的方法
	}
}
