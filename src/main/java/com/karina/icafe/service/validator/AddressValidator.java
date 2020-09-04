package com.karina.icafe.service.validator;

import org.springframework.web.context.annotation.RequestScope;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@FacesValidator("addressValidator")

public class AddressValidator implements Validator {
    private static final String ANTI_ADDRESS_PATTERN = "(\\S+)?(\\S*)"; // null, empty

    private Pattern pattern;

    public AddressValidator() {
        pattern = Pattern.compile(ANTI_ADDRESS_PATTERN);
    }

    @Override
    public void validate(final FacesContext facesContext, final UIComponent uiComponent, final Object o) throws ValidatorException
    {
        Matcher matcher = pattern.matcher(o.toString());
        if(matcher.matches()) {
            FacesMessage msg = new FacesMessage("Invalid address format.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
