/*
Some balloons are placed around x-axis , find minimum number of arrows needed to burst balloon.
1. coordinates for each Balloon will be given as input. 
2. coordinates[i] = [starting point of ith Balloon , ending point of ith Balloon]
3. Some Balloons may overlap each other.
4. An arrow will burst a balloon only if arrow passes through / touches the balloon.

Task is to "find minimum number of arrows required to burst all Balloons".
NOTE: Each arrow can be shot from any x-coordinate(vertically upwards).

Example 1 : 
    coordinates[] : [[1,3],[4,5]]
    output : 2
    explanation : Two seperate arrows will be needed to burst each balloon.

Example 2 : 
    coordinates[] : [[1,3],[3,5]]
    output : 1
    explanation : One arrow can burst both , if arrow is fired from x = 3(vertically upwards).

Example 3 :
    coordinates[] : [[10,13],[3,5],[5,7],[1,5],[2,6],[12,14]]
    output : 2
    explanation : First arrow will burst 4 balloons i.e. [3,5],[5,7],[1,5] & [2,6] , if arrow is shot from x = 5(vertically upwards). Second arrow will burst 2 baloons i.e. [10,13] & [12,14] , if arrow is shot from x = 12(vertically upwards); 

Example 4 : 
    coordinates[] : [[1,3],[5,7],[9,10]]
    output : 3
*/

import java.util.Arrays;
import java.util.Scanner;

public class findMinimumNumberOfArrowsNeededToBurstBalloon {

    public static int minArrows(int coordinates[][]) {
        // write your code here
        if (coordinates.length == 0)
            return 0;
        Arrays.sort(coordinates, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        int ans = 1;
        for (int i = 1; i < coordinates.length; i++) {
            if (coordinates[i][0] <= coordinates[i - 1][1]) {
                coordinates[i][0] = Math.max(coordinates[i][0], coordinates[i - 1][0]);
                coordinates[i][1] = Math.min(coordinates[i][1], coordinates[i - 1][1]);
            } else
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // number of balloons
        int coordinates[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            coordinates[i][0] = scn.nextInt();
            coordinates[i][1] = scn.nextInt();
        }
        scn.close();
        System.out.println(minArrows(coordinates));
    }
}