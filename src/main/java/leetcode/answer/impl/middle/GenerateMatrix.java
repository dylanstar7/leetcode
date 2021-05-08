package leetcode.answer.impl.middle;

/**
 * 思考四种走的宗旨
 * 向右->向下->向左->向上，判断条件，如果值不为空或者到达边界即可转弯
 *
 * @author lijiakun
 * @date 2021/03/16 17:44
 */
public class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int row = 0;
        int column = 0;
        int curNum = 1;
        int maxNum = n*n;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        while (curNum<=maxNum){
            res[row][column] = curNum;
            curNum++;
            int nextRow = row+directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            if(nextRow<0 || nextRow>=n ||nextColumn<0 ||nextColumn >=n ||res[nextRow][nextColumn] !=0){
                directionIndex = (directionIndex+1) %4;
            }

            row = row+directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }

        return res;

    }


    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        int[][] matrix = generateMatrix.generateMatrix(4);
        System.out.println(matrix);
    }
}
