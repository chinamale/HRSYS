/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import javax.ejb.Local;
import mw.co.sysassociates.hrsys.entity.Certificate;
import mw.co.sysassociates.hrsys.exceptions.EntityNotFoundException;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Local
public interface ICertificate {
int addCertificate(String company, String code, String name, String longname, String abbreviation);
int amendCertificate(String company, String code, String name, String longname, String abbreviation);
int deleteCertificate(String company, String code);
Certificate findCertificateByPrimaryKey(String certKey) throws EntityNotFoundException;
Certificate findCertificateByCompanyAndCode(String comp, String certCode);
Certificate findCertificateByCompanyAndAbbrev(String comp, String certAbbr);
Certificate findCertificateByCompanyAndName(String comp, String certName); 
}
