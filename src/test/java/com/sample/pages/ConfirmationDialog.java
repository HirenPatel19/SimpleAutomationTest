package com.sample.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationDialog {

    private static final Logger logger = LogManager.getLogger(ConfirmationDialog.class);

    public ConfirmationDialog(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how=How.ID, using="dialog")
    public WebElement dialog;

    @FindBy(how=How.XPATH, using="//div[@id='dialog']/p")
    public WebElement dialogText;
    
    @FindBy(xpath = "//button[@title='Close']")
    public WebElement closeBtn;

    public String getConfirmationText(){
        String text =dialogText.getText();
        logger.info("getConfirmationText "+ text);
        return text;
    }
    /* This method will close the opened dialog box using "closeBtn" xpath.
     */
    public void closeDialogBox(){
    	closeBtn.click();
        logger.info("Closing the Dialog box.");
    }


}