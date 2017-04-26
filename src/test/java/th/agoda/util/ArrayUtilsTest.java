package th.agoda.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayUtilsTest {

	private ArrayUtils arrayUtils;

	@Before
	public void setUp() {
		arrayUtils = new ArrayUtils();
	}

	@Test
	public void testForNullInput() {
		Integer[] flattenedArray = arrayUtils.flattenArray(null);
		Assert.assertEquals(0, flattenedArray.length);
	}

	@Test
	public void testForEmptyArray() {
		Integer[] flattenedArray = arrayUtils.flattenArray(new Integer[0]);
		Assert.assertEquals(0, flattenedArray.length);
	}

	@Test
	public void testForValidIntegerArray() {
		Object[] inputArray = {21, 22, 33, 12};
		Integer[] flattenedArray = arrayUtils.flattenArray(inputArray);

		Assert.assertEquals(inputArray.length, flattenedArray.length);
		Assert.assertArrayEquals(inputArray, flattenedArray);
	}

	@Test
	public void testForIntegerArraysAndNestedArrayAtTheEnd() {
		Object[] nestedArray = {44, 66, 55, 77};
		Object[] inputArray = {21, 22, 33, 12, nestedArray};
		Integer[] expectedArray = {21, 22, 33, 12, 44, 66, 55, 77};

		Integer[] flattenedArray = arrayUtils.flattenArray(inputArray);

		Assert.assertEquals(8, flattenedArray.length);
		Assert.assertArrayEquals(expectedArray, flattenedArray);
	}

	@Test
	public void testForIntegerArrayAndNestedArrayInMid() {
		Object[] nestedArray = {44, 66, 55, 77};
		Object[] inputArray = {21, 22, nestedArray, 33, 12};
		Integer[] expectedArray = {21, 22, 44, 66, 55, 77, 33, 12};

		Integer[] flattenedArray = arrayUtils.flattenArray(inputArray);

		Assert.assertEquals(8, flattenedArray.length);
		Assert.assertArrayEquals(expectedArray, flattenedArray);
	}

	@Test
	public void testForIntegerArrayAndNestedArrayAtFirst() {
		Object[] nestedArray = {44, 66, 55, 77};
		Object[] inputArray = {nestedArray, 21, 22, 33, 12};
		Integer[] expectedArray = {44, 66, 55, 77, 21, 22, 33, 12};

		Integer[] flattenedArray = arrayUtils.flattenArray(inputArray);

		Assert.assertEquals(8, flattenedArray.length);
		Assert.assertArrayEquals(expectedArray, flattenedArray);
	}

	@Test
	public void testForMultipleNestedIntegerArrays() {
		Object[] nestedArray1 = {66, 55};
		Object[] nestedArray = {44, nestedArray1, 77};
		Object[] inputArray = {nestedArray, 21, 22, 33, 12};
		Integer[] expectedArray = {44, 66, 55, 77, 21, 22, 33, 12};

		Integer[] flattenedArray = arrayUtils.flattenArray(inputArray);

		Assert.assertEquals(8, flattenedArray.length);
		Assert.assertArrayEquals(expectedArray, flattenedArray);
	}

	@Test
	public void testForMultipleNestedIntegerArrays_1() {
		Object[] nestedArray1 = {66, 55};
		Object[] nestedArray2 = {44, nestedArray1, 77};
		Object[] nestedArray3 = {22, 33};
		Object[] nestedArray4 = {21, nestedArray3, 12};
		Object[] inputArray = {nestedArray2, nestedArray4};
		Integer[] expectedArray = {44, 66, 55, 77, 21, 22, 33, 12};

		Integer[] flattenedArray = arrayUtils.flattenArray(inputArray);

		Assert.assertEquals(8, flattenedArray.length);
		Assert.assertArrayEquals(expectedArray, flattenedArray);
	}

	@Test
	public void testForInvalidType() {
		Object[] nestedArray1 = {"SD", "66"};
		Object[] nestedArray2 = {44, nestedArray1, 77};
		Object[] nestedArray3 = {22, 33};
		Object[] nestedArray4 = {21, nestedArray3, 12};
		Object[] inputArray = {nestedArray2, nestedArray4};

		try {
			arrayUtils.flattenArray(inputArray);
			Assert.fail("RuntimeException is expected");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

	}
}
