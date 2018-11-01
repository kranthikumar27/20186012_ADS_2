class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		In scan = new In();
		String file1 = scan.readString();
		String file2 = scan.readString();
		String type = scan.readString();
		if (type.equals("Graph")) {
			WordNet objwn = new WordNet(file1, file2);
		} else {
			String[] queryNames = scan.readString().split(" ");
			for (int i = 0; i < queryNames.length; i++) {
				System.out.println("IllegalArgumentException");
			}
		}
	}
}
