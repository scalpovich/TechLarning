package com.mastercard.pts.integrated.issuing.soap;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jbehave.core.model.ExamplesTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.testing.mtaf.jbehave.web.steps.AbstractSteps;
import com.mastercard.testing.mtaf.soap.implementation.builder.RequestBuilder;
import com.mastercard.testing.mtaf.soap.implementation.driver.MasterCardSoapDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class XMLUtilities.
 */

@Component
public class XMLUtilities extends AbstractSteps {

	@Autowired
	DateUtils dateutils;

	@Autowired
	APITransactions apiTransactions;

	/** The logger. */
	final Logger logger = LoggerFactory.getLogger(XMLUtilities.class);

	/** The Constant SRCPATH for stored XMLs. */
	public static final String SRCPATH = "\\src\\main\\resources\\webServiceRequestXmls\\";

	/**
	 * Read xml. Method will read xml file and return its contents as string
	 *
	 * @param xmlFile
	 *            the xml file
	 * @return fileContains
	 */
	public String readXml(final String xmlFile) {
		String currentDir = System.getProperty("user.dir");
		XML xml = null;
		try {
			xml = new XMLDocument(new File(currentDir + SRCPATH + xmlFile));
		} catch (IOException e) {
			logger.debug(
					"Exception occured while reading xml file :" + xmlFile, e);
		}
		if (xml != null) {
			return xml.toString();
		}
		return null;

	}

	/**
	 * Send request.
	 *
	 * @param xmlFile
	 *            the xml file
	 * @return will return response in string format
	 */
	public String sendRequest(final String xmlFile) {

		String finalString = null;
		try {
			MasterCardSoapDriver soapDriver = new MasterCardSoapDriver();
			RequestBuilder builder = soapDriver.getPostRequestBuilder()
					.withUrl(env.getProperty("api.base.url"))
					// .withResourcePath(env.getProperty("resource.path"))
					.addRequestHeader("Content-Type", "text/xml")
					.withPayload(xmlFile);
			Document doc = soapDriver
					.submitSoapRequest(builder, Document.class);
			assertNotNull(doc);

			finalString = convertDocumentToString(doc).replace("&lt;", "<")
					.replace("&gt;", ">");
			logger.info(finalString);
			if (finalString.contains("Request Timed out")) {
				throw new TimeoutException("Request time out...");
			}
		} catch (Exception e) {
			logger.debug("Exception occured while sending request", e);
		}
		return finalString;
	}

	/**
	 * Gets the tag value from response.
	 *
	 * @param tagName
	 *            the tag name
	 * @param responseString
	 *            the response string
	 * @return the tag value from response
	 */
	public String getTagValueFromResponse(final String tagName,
			final String responseString) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Node node = null;
		try {
			builder = factory.newDocumentBuilder();

			InputSource is = new InputSource(new StringReader(responseString));
			Document doc = builder.parse(is);

			NodeList nodeList = doc.getElementsByTagName(tagName);
			node = nodeList.item(0);
			logger.info(node.getNodeName() + " = " + node.getTextContent());

		} catch (ParserConfigurationException e) {
			logger.debug(
					"ParserConfigurationException occured while reading tag value from xml",
					e);

		} catch (SAXException e) {
			logger.debug(
					"SAXException occured while reading tag value from xml", e);
		} catch (IOException e) {
			logger.debug(
					"IOException occured while reading tag value from xml", e);
		}
		if (node != null) {
			return node.getTextContent();
		} else {
			logger.debug("Node value is null");
		}
		return null;
	}

	/**
	 * Convert document to string.
	 *
	 * @param doc
	 *            the doc
	 * @return the string
	 */
	public String convertDocumentToString(Document doc) {
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = tf.newTransformer();
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(doc), new StreamResult(writer));

			return writer.getBuffer().toString();
		} catch (TransformerException e) {
			logger.debug(
					"TransformerException occured while converting doc to string",
					e);
		}
		return null;
	}

	/**
	 * Update xml for tags.
	 *
	 * @param xmlFile
	 *            the xml file
	 * @param tagTable
	 *            the tag table
	 * @param sessionKey
	 *            the session key
	 * @return the string
	 */
	public String updateXmlForTags(String xmlFile, ExamplesTable tagTable,
			String sessionKey) {
		String updatedXml = xmlFile;
		for (int i = 0; i < tagTable.getRows().size(); i++) {

			String tagName = tagTable.getRow(i).get(
					tagTable.getHeaders().get(0));

			String tagValue = tagTable.getRow(i).get(
					tagTable.getHeaders().get(1));

			switch (tagName) {

			case "sessionKey":
				updatedXml = updateXml(updatedXml, sessionKey, tagName);
				break;
			case "traceAuditNumber":
				updatedXml = updateXml(updatedXml, getRandom(6), tagName);
				break;
			case "rrn":
				updatedXml = updateXml(updatedXml, getRandom(12), tagName);
				break;

			case "transactionCode":
				updatedXml = updateXml(updatedXml,
						apiTransactions.transactionType(tagValue), tagName);
				break;

			case "transactionDateTime":
				updatedXml = updateXml(updatedXml,
						dateutils.getDateYYMMDDFormat(), tagName);
				break;
			case "formFactor":
				updatedXml = updateXml(updatedXml,
						env.getProperty("device.formFactor"), tagName);
				break;
			case "txnCurrency":
				updatedXml = updateXml(updatedXml, tagValue, tagName);
				break;
			case "billingCurrency":
				updatedXml = updateXml(updatedXml, tagValue, tagName);
				break;
			case "billingAmt":
				updatedXml = updateXml(updatedXml, tagValue, tagName);
				break;
			case "txnamount":
				updatedXml = updateXml(updatedXml, tagValue, tagName);
				break;

			default:
				logger.info("No tag to update");
			}

		}
		return updatedXml;
	}

	/**
	 * Update xml for tags.
	 *
	 * @param xmlFile
	 *            the xml file
	 * @param tagTable
	 *            the tag table
	 * @param sessionKey
	 *            the session key
	 * @return the string
	 */
	public String updateXmlForTags(String xmlFile, ExamplesTable tagTable) {
		String updatedXml = xmlFile;
		for (int i = 0; i < tagTable.getRows().size(); i++) {

			String tagName = tagTable.getRow(i).get(
					tagTable.getHeaders().get(0));

			String tagValue = tagTable.getRow(i).get(
					tagTable.getHeaders().get(1));

			switch (tagName) {

			case "componentId":
				updatedXml = updateXml(updatedXml,
						env.getProperty("api.componentId"), tagName);
				break;
			case "componentAuthKey":
				updatedXml = updateXml(updatedXml,
						env.getProperty("api.componentAuthKey"), tagName);
				break;
			case "userId":
				updatedXml = updateXml(updatedXml,
						env.getProperty("api.userId"), tagName);
				break;
			case "password":
				updatedXml = updateXml(updatedXml,
						env.getProperty("api.password"), tagName);
				break;
			case "ip":
				updatedXml = updateXml(updatedXml, env.getProperty("api.ip"),
						tagName);
				break;
			case "bankCode":
				updatedXml = updateXml(updatedXml,
						env.getProperty("api.bankCode"), tagName);
				break;
			case "serviceCode":
				updatedXml = updateXml(updatedXml, tagValue, tagName);
				break;

			default:
				logger.info("No tag to update");
			}

		}
		return updatedXml;
	}

	/**
	 * Gets the random.
	 *
	 * @param length
	 *            the length
	 * @return the random
	 */
	private String getRandom(int length) {
		Random rnd = new Random();
		if (length < 1 && length > 12) {
			throw new IllegalArgumentException(
					"Random number generator length should be between 1 to 12");
		}
		long nextLong = Math.abs(rnd.nextLong());
		return String.valueOf(nextLong).substring(0, length);
	}

	/**
	 * Update xml.
	 *
	 * @param xmlFile
	 *            the xml file
	 * @param sessionKey
	 *            the session key
	 * @param tagName
	 *            the tag name
	 * @return the string
	 */
	private String updateXml(String xmlFile, String sessionKey, String tagName) {
		String tag = "<" + tagName + ">[\\s\\S]*?</" + tagName + ">";
		String newTag = "<" + tagName + ">" + sessionKey + "</" + tagName + ">";

		return xmlFile.replaceAll(tag, newTag);
	}

}
