/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.jsf;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import mw.co.sysassociates.hrsys.ejb.ICertificate;
import mw.co.sysassociates.hrsys.entity.Certificate;
import mw.co.sysassociates.hrsys.exceptions.EntityNotFoundException;

/**
 *
 * @author Clifton T. Mtengezo
 */
@FacesValidator("mw.co.sysassociates.hrsys.jsf.CompanyIdPatternValidator")
public class CompanyIdPatternValidator implements Validator {

    private static final String companyIdPattern = "[0-9][0-9]";
    private Pattern pattern;
    private Matcher matcher;

    public CompanyIdPatternValidator() {
        pattern = Pattern.compile(companyIdPattern);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            FacesMessage msg = new FacesMessage("The company id: "+ value.toString()+" is not in the correct format. The correct id should be a number between 0 and 99 in the form : 00 - 99");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}
