package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MPTSBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class MCGPage extends MPTSBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addMCG;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mcgHeadPanel:mcgCode:input:inputTextField")
	private MCWebElement MCGCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mcgHeadPanel:description:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	public void addmcg() {
		addMCG.click();
		switchToIframe(Constants.ADD_MCG_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(MCGCode, CustomUtils.randomNumbers(3));
		enterText(Description, CustomUtils.randomNumbers(3));
		enterText(Description, "MCG Additional auth hold plan");
		ClickButton(save);
		SwitchToDefaultFrame();

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
