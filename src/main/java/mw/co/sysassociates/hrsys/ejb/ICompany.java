/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.persistence.EntityExistsException;
import mw.co.sysassociates.hrsys.entity.Company;
import mw.co.sysassociates.hrsys.exceptions.EntityFoundException;
import mw.co.sysassociates.hrsys.exceptions.EntityNotFoundException;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Local
public interface ICompany {
int insertEmployee(String employeeNo,String firstname, String surname, String sex, String title) throws EntityExistsException;
int insertCompany(String companyno,String companyname, String companyshortname) throws EntityExistsException;
int insertCompany(Company company) throws EntityExistsException;
Company findCompanyByPrimaryKey(String compKey) throws EntityNotFoundException,EJBException;
Company findDuplicateCompanyByPrimaryKey(String compKey) throws EJBException,EntityFoundException;
Company findCompanyByAbbrev(String compAbbr) throws EntityNotFoundException;
Company findCompanyByName(String compName) throws EntityNotFoundException;
}