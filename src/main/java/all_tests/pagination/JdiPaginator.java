package all_tests.pagination;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.web.selenium.elements.composite.Pagination;
import org.openqa.selenium.support.FindBy;

/**
 * Created by X240 on 10/13/2017.
 */
public class JdiPaginator extends Pagination{
    @FindBy(css = "li.next a")
    public IButton next;

    @FindBy(css =  "li.prev a")
    public IButton prev;

    @FindBy(css = "li.first a")
    public IButton first;

    @FindBy(css = "li.last a")
    public IButton last;
}
