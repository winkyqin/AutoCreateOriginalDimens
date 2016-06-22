package createOriginalDimens;
/**
 * sizeX, sizeY填入最大使用的DIP数值<br>
 */
public class Main {

	public static int sizeX = 500;
	public static int sizeY = 500;

	public static String DIMENS_HOME = "/Users/Nexton/Documents/dev/DimensHome/";
	public static String ORI_DIMENS = "/Users/Nexton/Documents/dev/DimensHome/dimens.xml";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		XMLConstructor xml = new XMLConstructor();
		xml.build();
	}

}
