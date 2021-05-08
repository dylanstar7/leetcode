package leetcode.answer.impl.middle;

import java.util.Arrays;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author lijiakun
 * @date 2020/07/02 11:15
 */
public class kthSmallest {

    public int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length;
        int number = 1;
        int i = 0;
        int j = 0;
        int j1= 0;
        int i1 = 0;
        while (number<k){
            if(j<length-1){
                j1 = j+1;
            }else {
                j1 = j;
            }

            if(i<length-1){
                i1 = i+1;
            }else {
                i1 = i;
            }
            if(matrix[i][j1] < matrix[i1][j]){
                i = i1;
            }else {
                j = j1;
            }
            number++;
        }

        return matrix[i][j];
    }



    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }


    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr,0,k-1);
    }
}
