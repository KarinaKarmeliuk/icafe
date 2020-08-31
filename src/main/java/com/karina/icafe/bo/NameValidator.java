package com.karina.icafe.bo;

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
@FacesValidator("nameValidator")
@SessionScoped
public class NameValidator implements Validator {
    private static final String NAME_PATTERN = "\\D\\B\\b{1,2}"; // NON-digit character, NON-word boundary, 1 or 2 backspaces

    private Pattern pattern;

    public NameValidator() {
        pattern = Pattern.compile(NAME_PATTERN);
    }

    @Override
    public void validate(final FacesContext facesContext, final UIComponent uiComponent, final Object o) throws ValidatorException
    {
        Matcher matcher = pattern.matcher(o.toString());
        if(!matcher.matches()) {
            FacesMessage msg = new FacesMessage("Name validation failed.", "Invalid string format.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
