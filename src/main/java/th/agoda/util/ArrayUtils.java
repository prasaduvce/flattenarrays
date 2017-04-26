package th.agoda.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {

	private List<Integer> finalOutputList = new ArrayList<Integer>();

	public Integer[] flattenArray(Object[] inputArray) {
		if (inputArray == null) {
			return new Integer[0];
		}
		for (int i=0; i<inputArray.length; i++) {
			Object obj = inputArray[i];
			if (Integer.class.equals(obj.getClass())) {
				finalOutputList.add((Integer) obj);
			} else if (Object[].class.equals(obj.getClass())) {
				flattenArray((Object[])obj);
			} else {
				throw new RuntimeException("Not able to flatten the array, due to not matching type");
			}
		}
		return finalOutputList.toArray(new Integer[0]);
	}
}
