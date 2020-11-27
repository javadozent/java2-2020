package app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XMLWriter {

	public static void main(String[] args) {
		try {

			Element root = new Element("root");
			Document doc = new Document(root);

			Element child1a = new Element("child1a");
			Element child2a = new Element("child2a");

			child1a.addContent(new Element("child1b"));

			child1a.setAttribute(new Attribute("id", "123"));
			child2a.setText("Text");

			root.addContent(child1a);

			root.addContent(child2a);

			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
			FileOutputStream out = new FileOutputStream("out.xml");
			outputter.output(doc, out);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
