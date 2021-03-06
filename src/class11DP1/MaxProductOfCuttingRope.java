package class11DP1;

/**
 * 
 * @author guoyifeng
 * Given a rope with positive integer-length n, how to cut the rope into m integer-length
 *  parts with length p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? m 
 *  is determined by you and must be greater than 0 (at least one cut must be made). 
 *  Return the max product you can have.

	Assumptions
	
	n >= 2
	Examples
	
	n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).

 */
/*
 * basic idea: grow left size and enumerate right size 
 */
public class MaxProductOfCuttingRope {
	public int maxProduct(int length) {
		int[] M = new int[length + 1];
		M[1] = 1;
		for (int i = 2; i <= length; i++) {// current rope length
			for (int j = 1; j < i; j++) { // left part size
				M[i] = Math.max(M[i], Math.max(M[j], j) * (i - j));//compare last time product with current
			}
		}
		return M[length];
	}
}
