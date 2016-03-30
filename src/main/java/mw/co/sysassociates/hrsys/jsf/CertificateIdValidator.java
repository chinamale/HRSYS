/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.jsf;

import java.util.logging.Level;
import java.util.logging.Logger;
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


@FacesValidator("mw.co.sysassociates.hrsys.jsf.CertificateIdValidator")
public class CertificateIdValidator implements Validator {
    
    @Resource
    private UserTransaction userTransaction;

    @EJB
    ICertificate certificateSrv;
   // @Inject        
   // IndividualCRUDService IndivSvr;
        
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        try {
        userTransaction.begin();
        Certificate cert = certificateSrv.findCertificateByPrimaryKey(value.toString());
        userTransaction.commit();
        } catch (javax.transaction.RollbackException | NotSupportedException | SystemException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException | EntityNotFoundException ex) {
        Logger.getLogger(CertificateIdValidator.class.getName()).log(Level.SEVERE, null, ex);
            throw new ValidatorException(new FacesMessage(ex.getMessage()));
        } 

    }
    
}
