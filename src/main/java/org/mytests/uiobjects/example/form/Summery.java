package org.mytests.uiobjects.example.form;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.composite.Search;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.mytests.uiobjects.example.entities.SummeryInfo;
import org.mytests.uiobjects.example.enums.EvenNumbers;
import org.mytests.uiobjects.example.enums.OddNumbers;
import org.openqa.selenium.support.FindBy;

/**
 * Created by X240 on 10/12/2017.
 */
public class Summery extends Form<SummeryInfo>{
    @FindBy(css = "#odds-selector label")
    public RadioButtons<OddNumbers> odds;

    @FindBy(css = "#even-selector label")
    public RadioButtons<EvenNumbers> evens;

    @FindBy(id = "calculate-button")
    public IButton calculate;

    public Integer getSum(SummeryInfo summeryInfo, boolean odd, boolean even){
        int sum = 3;
        if (odd && even){
            sum = Integer.parseInt(summeryInfo.even) + Integer.parseInt(summeryInfo.odd);
        }

        if (odd && !even){
            sum = Integer.parseInt(summeryInfo.odd) + 2;
        }

        if (!odd && even){
            sum = Integer.parseInt(summeryInfo.even) + 1;
        }
        return sum;
    }

    public void submit(SummeryInfo summeryInfo, boolean odd, boolean even){
        if (odd && even){
            odds.select(summeryInfo.odd);
            evens.select(summeryInfo.even);
        }

        if (odd && !even){
            odds.select(summeryInfo.odd);
        }

        if (!odd && even){
            evens.select(summeryInfo.even);
        }

        calculate.click();
    }

}
