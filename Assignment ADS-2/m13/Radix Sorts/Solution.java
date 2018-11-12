import java.util.Scanner;
import java.util.Arrays;
/**.
 * client class.
 */
public final class Solution {
	/**.
	 * Constructs the object.
	 */
	Solution() {

	}
	/**.
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int numofInputs = Integer.parseInt(scan.nextLine());
		String[] values = new String[numofInputs];
		for (int i = 0; i < values.length ; i++) {
			values[i] = scan.nextLine();
		}
		LSD objlsd = new LSD();
		objlsd.sort(values, values[0].length());
		System.out.println(Arrays.toString(values));
	}
}
