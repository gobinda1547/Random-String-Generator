import java.io.File;

public class Database {

	private final static String folderPath = "E:/check/";

	public void createFolder(String name) {
		File file = new File(folderPath + name);
		file.mkdirs();
	}

	public boolean isFolderExist(String name) {
		return new File(folderPath + name).exists();
	}
}
