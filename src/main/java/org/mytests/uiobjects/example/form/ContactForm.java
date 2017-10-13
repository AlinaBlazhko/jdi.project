package org.mytests.uiobjects.example.form;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import org.mytests.uiobjects.example.entities.ContactInfo;
import org.mytests.uiobjects.example.enums.Numbers;

import static org.mytests.uiobjects.example.site.JDIExampleSite.contactForm;

/**
 * Created by X240 on 9/28/2017.
 */

public class ContactForm extends Form<ContactInfo> {

    @JFindBy(id = "Name")
    public TextField name;

    @JFindBy(id = "LastName")
    public TextField lastName;

    @JFindBy(id = "Description")
    public TextField description;

    @JFindBy(css = "section.horizontal-group label")
    public RadioButtons<Numbers> numbers;

//    @JFindBy(css = "section.horizontal-group input[name = 'custom_radio_odd']")
//    public RadioButtons<EvenNumbers> evens;

    @JFindBy(text = "Submit")
    public Button submit;

    @Override
    public void submit(ContactInfo info){
        if (!info.odd.isEmpty()){
            contactForm.numbers.select(info.odd);
        }
        if (!info.even.isEmpty()) {
            contactForm.numbers.select(info.even);
        }
        super.submit(info);
    }
}
