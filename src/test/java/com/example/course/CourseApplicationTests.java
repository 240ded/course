package com.example.course;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void concatTest() {
		String stringOne = "Hello ";
		String stringTwo = "world";

		assertEquals("Hello world", stringOne + stringTwo);
	}
}
