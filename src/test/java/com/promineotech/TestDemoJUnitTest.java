package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;



class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectExcpetion) {
		if(!expectExcpetion) {			
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
		
	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(arguments(2, 4, 6, false), arguments(1, 5, 6, false), 
				arguments(0, 0, 0, true), arguments(-6, 8, 3, true));
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	}
	
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForMultiplyPositive")
	
	void assertThatTwoPositiveNumbersAreMultipliedCorrectly(double a, double b, double expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.multiplyPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.multiplyPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForMultiplyPositive(){
		return Stream.of(arguments(2, 4, 8, false), arguments(1, 5, 5, false), 
				arguments(1, 1, 1, false), arguments(-6, 8, 3, true));
	}
	
	
	@Test
	void assertThatPairsOfPositiveNumbersAreMultipiedCorrectly(){
		assertThat(testDemo.multiplyPositive(4,5)).isEqualTo(20);
		assertThat(testDemo.multiplyPositive(10, 50)).isEqualTo(500);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}
	
}