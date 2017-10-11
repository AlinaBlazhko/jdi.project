package org.mytests.uiobjects.example.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Image;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Roman_Iovlev on 10/22/2015.
 */
@JPage(url = "/index.htm", title = "Index Page")
public class HomePage extends WebPage {

    @FindBy(css = ".main-title")
    public Text mainTitle;

    @FindBy(css = ".main-txt")
    public Text mainText;

    @FindBy(css = ".icons-benefit")
    public Elements<Image> icons;

    @FindBy(css = ".benefit-txt")
    public Elements<Text> texts;



}

