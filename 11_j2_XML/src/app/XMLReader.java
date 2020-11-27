package app;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XMLReader {

	public static void main(String[] args) {
		try {

			SAXBuilder builder = new SAXBuilder();

			Document doc = builder.build(new File("users.xml"));

			Element userlistElement = doc.getRootElement();// <userlist>
			System.out.println(userlistElement.getName());
			List<Element> userElemente = userlistElement.getChildren();// <user>...</user> <user>...</user>

			for (Element userElement : userElemente) {
				System.out.println(userElement.getName() + " id:" + userElement.getAttributeValue("id"));// <user>...</user>
				List<Element> userDataElemente = userElement.getChildren();// <vorname>, <nachname>,<email>
				for (Element userdataElement : userDataElemente) {
					System.out.println(userdataElement.getName() + " " + userdataElement.getText());
				}
			}

		} catch (JDOMException | IOException e) {

			e.printStackTrace();
		}
	}

}
