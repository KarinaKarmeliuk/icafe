package com.karina.icafe.service.validator;

import org.springframework.web.context.annotation.RequestScope;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NameValidator implements Validator {

    private static final String ANTI_NAME_PATTERN = "(\\S+)?(\\S*\\d)"; // empty, digit

    private Pattern pattern;

    @Override
    public void validate(final FacesContext facesContext, final UIComponent uiComponent, final Object o) throws ValidatorException
    {
        Matcher matcher = pattern.matcher(o.toString());
        if(matcher.matches()) {
            FacesMessage msg = new FacesMessage("Invalid name format.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
