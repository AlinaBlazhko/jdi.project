package org.mytests.uiobjects.example.form;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import org.mytests.uiobjects.example.entities.ContactInfo;

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

    @JFindBy(text = "Submit")
    public Button submit;


}
