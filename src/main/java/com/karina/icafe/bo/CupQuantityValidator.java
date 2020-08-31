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
@FacesValidator("cupQuantityValidator")
@SessionScoped
public class CupQuantityValidator implements Validator {

    private static final String CUP_QUANTITY_PATTERN = "[1-9]{1,3}"; // numbers [1...9] at least 1 and at most 3 times

    private Pattern pattern;

    public CupQuantityValidator() {
        pattern = Pattern.compile(CUP_QUANTITY_PATTERN);
    }

    @Override
    public void validate(final FacesContext facesContext, final UIComponent uiComponent, final Object o) throws ValidatorException
    {
        String quantity = (String) o;
        Matcher matcher = pattern.matcher(quantity);
        if(!matcher.matches()) {
            FacesMessage msg = new FacesMessage("Invalid number format. Input value from 1 to 999");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
