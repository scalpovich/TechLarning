package MIIssuing.com.mastercard.bdd.mpts;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.mastercard.pts.integrated.issuing.pages.BasePage;
import com.mastercard.pts.integrated.issuing.soap.XMLUtilities;

public class MockitoTests {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	BasePage basePage;

	@Test
	public void readXmlTest() {

		XMLUtilities xmlUtl = mock(XMLUtilities.class);

		// when(xmlUtl.readXml("xmlFile")).thenReturn("");

		// XMLUtilities xmlUtilities = new XMLUtilities();

		String cmlContents = xmlUtl.readXml("test.xml");
		assertNotNull(cmlContents);
		String cmlContent = xmlUtl.readXml("tes.xml");

	}

	@Test
	public void basePageTest() {

		basePage.fnSwitchFrame("name");
	}
}
