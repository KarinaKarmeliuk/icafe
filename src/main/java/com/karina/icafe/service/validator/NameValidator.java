package com.karina.icafe.service.validator;

import org.springframework.web.context.annotation.SessionScope;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("nameValidator")
@SessionScope
public class NameValidator implements Validator {
    @Override
    public void validate(final FacesContext facesContext, final UIComponent uiComponent, final Object o) throws ValidatorException
    {

    }
}
