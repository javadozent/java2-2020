package application;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import javafx.scene.control.TreeItem;

//<CATALOG>
//<CD>
//	<TITLE>Empire Burlesque</TITLE>
//	<ARTIST>Bob Dylan</ARTIST>
//	<COUNTRY>USA</COUNTRY>
//	<COMPANY>Columbia</COMPANY>
//	<PRICE>10.90</PRICE>
//	<YEAR>1985</YEAR>
//</CD>
public class CDTreeCreator {

	public static TreeItem<String> createTree(String path) {
		TreeItem<String> rootItem = new TreeItem<>();
		try {
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(new File(path));
			Element rootElement = doc.getRootElement();// <CATALOG>
			rootItem.setValue(rootElement.getName());
			
			List<Element> cdElements = rootElement.getChildren();// <CD>..<CD><CD>..<CD><CD>..<CD>
			for (Element cdElement : cdElements) {
				TreeItem<String> cdItem = new TreeItem<>();
				cdItem.setValue(cdElement.getChildText("TITLE"));//<TITLE>Empire Burlesque</TITLE>
				
				List<Element> cdDataElements =cdElement.getChildren();//TITLE;ARTIST
				for (Element cdDataElement : cdDataElements) {
					TreeItem<String> cdDataItem = new TreeItem<>();
					cdDataItem.setValue(cdDataElement.getName()+": "+cdDataElement.getText());
					cdItem.getChildren().add(cdDataItem);
				}
				rootItem.getChildren().add(cdItem);
				cdItem.setExpanded(true);
			}
			
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}

		rootItem.setExpanded(true);
		return rootItem;
	}

}
