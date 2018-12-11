import java.util.Random;

public class Main {

	public static Database database;

	public static void main(String[] args) {

		database = new Database();

		for (int i = 0; i < 100000000; i++) {
			String uuid = getUUID(i, 32);
			if (database.isFolderExist(uuid)) {
				System.out.println("same uuid found for " + i);
			} else {
				database.createFolder(uuid);
			}

			if (i % 100000 == 0) {
				System.out.println("working with value " + i);
			}
		}

	}

	public static String getUUID(long value, int len) {

		String characters = "ABCDEFGHIJKLMNOPQRSTVUXYZ123456789";
		String longValue = String.valueOf(value);

		StringBuilder answer = new StringBuilder();
		int lengthAnser = 0, currentKeyPosition = 0, currentValuePosition = 0;

		while (lengthAnser < len) {
			if (currentKeyPosition == longValue.length()) {
				answer.append('0');
				lengthAnser++;

				currentKeyPosition = (currentKeyPosition) % longValue.length();
			}

			int x = longValue.charAt(currentKeyPosition) - '0';
			currentValuePosition = (x + currentValuePosition) % characters.length();
			answer.append(characters.charAt(currentValuePosition));

			lengthAnser++;
			currentKeyPosition++;
		}

		if (lengthAnser == len) {
			return answer.toString();
		}
		return answer.substring(0, len);
	}

}
