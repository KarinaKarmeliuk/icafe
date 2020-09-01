package com.karina.icafe.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ManagedBean
@FacesValidator("addressValidator")
@SessionScoped
public class AddressValidator implements Validator {
    private static final String ADDRESS_PATTERN = "^(?!\\s*$).+"; // Not empty

    private Pattern pattern;

    public AddressValidator() {
        pattern = Pattern.compile(ADDRESS_PATTERN);
    }

    @Override
    public void validate(final FacesContext facesContext, final UIComponent uiComponent, final Object o) throws ValidatorException
    {
        Matcher matcher = pattern.matcher(o.toString());
        if(!matcher.matches()) {
            FacesMessage msg = new FacesMessage("Address validation failed.", "Invalid address format.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
