package createOriginalDimens;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XMLConstructor {
	private Document document = null;
	private Element rootNodeElement = null;
	private Map<String, String> valuesList;

	XMLConstructor() {
		valuesList = new HashMap<String, String>();
		for (int i = 1; i <= Main.sizeX; i++) {
			valuesList.put("x" + i, i + "dp");
		}
		for (int j = 1; j < Main.sizeY; j++) {
			valuesList.put("y" + j, j + "dp");
		}
	}

	public void build() {
		Iterator<String> iterator = valuesList.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String value = valuesList.get(key);
			addElement("dimen", key, value);
			System.out.println(key + " " + value);
		}

		saveToFile(new File(Main.ORI_DIMENS));
		System.out.println("写入" + Main.ORI_DIMENS + "完成");
	}

	/**
	 * Create XML document
	 */
	private void createXmlDocument() {
		this.document = DocumentHelper.createDocument();
		this.document.setXMLEncoding("utf-8");
		this.rootNodeElement = this.document.addElement("resources");
	}

	/**
	 * Add an child node to root node. @param tagName The name of the
	 * tag. @param attr The value of attribute. @param text The value of
	 * text. @return The element of the new created node.
	 */
	private Element addElement(String tagName, String attr, String text) {
		if (this.document == null)
			this.createXmlDocument();

		Element element = this.rootNodeElement.addElement(tagName);
		element.addAttribute("name", attr);
		element.setText(text);
		return element;
	}

	/**
	 * Save the XML document to <code>storedFile</code> using UTF-8
	 * encoding. @param storedFile The stored file path.
	 */
	private void saveToFile(File storedFile) {
		if (storedFile.exists())
			storedFile.delete();

		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		XMLWriter writer = null;
		try {
			storedFile.createNewFile();
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");
			fos = new FileOutputStream(storedFile);
			osw = new OutputStreamWriter(fos, Charset.forName("utf-8"));
			writer = new XMLWriter(osw, format);
			writer.write(this.document);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
				if (osw != null)
					osw.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
