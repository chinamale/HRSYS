/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import mw.co.sysassociates.hrsys.entity.AppraisalScore;
import mw.co.sysassociates.hrsys.entity.Certificate;
import mw.co.sysassociates.hrsys.entity.Company;
import mw.co.sysassociates.hrsys.exceptions.EntityNotFoundException;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Stateless
@Local(ICertificate.class)
public class CertificateService implements ICertificate {
    @PersistenceContext
    EntityManager em;
    @Override
    
    public int addCertificate(String company, String code, String name, String longname, String abbreviation) {
      try {
        Certificate certificate;
        //int compId = Integer.parseInt(company);
        // System.out.println("searching company :" + compId);
        Company comp = em.find(Company.class, company);
        
        certificate = new Certificate();
        
        certificate.setAbbreviation(abbreviation);
        certificate.setCompany(comp);
        certificate.setLongname(longname);
        certificate.setCode(code);
        certificate.setName(name);
        em.persist(certificate);
        return 0;         
        } catch (DatabaseException ex) {
            //Handle errors for JDBC
            System.out.println(ex.getMessage());
            return 3;            
        } catch (PersistenceException ex) {
            //Handle errors for JDBC
            System.out.println(ex.getMessage());
            return 3;
        } catch (Exception e) {
	    //Handle errors for Class.forName
            //e.printStackTrace();
            System.out.println(e.getMessage());
            return 4;
        } finally {
            //System.out.println("Goodbye!");
            return 5;
        }
    }

    @Override
    public int amendCertificate(String company, String code, String name, String longname, String abbreviation) {
        try {
            Certificate certificate;
            certificate = findCertificateByCompanyAndCode(company, code);
            certificate.setAbbreviation(abbreviation);
            certificate.setLongname(longname);
            certificate.setCode(code);
            certificate.setName(name);
            em.merge(certificate);
            em.flush();
            return 0;
        } catch (DatabaseException ex) {
            //Handle errors for JDBC
            System.out.println(ex.getMessage());
            return 3;
        } catch (PersistenceException ex) {
            //Handle errors for JDBC
            System.out.println(ex.getMessage());
            return 3;
        } catch (Exception e) {
            //Handle errors for Class.forName
            //e.printStackTrace();
            System.out.println(e.getMessage());
            return 4;
        } finally {
            //System.out.println("Goodbye!");
            return 5;
        }
    }

    public int deleteCertificate(String company, String code) {
        try {
            Certificate certificate;
            certificate = findCertificateByCompanyAndCode(company, code);
            em.merge(certificate);
            em.flush();
            return 0;
        } catch (DatabaseException ex) {
            //Handle errors for JDBC
            System.out.println(ex.getMessage());
            return 3;
        } catch (PersistenceException ex) {
            //Handle errors for JDBC
            System.out.println(ex.getMessage());
            return 3;
        } catch (Exception e) {
            //Handle errors for Class.forName
            //e.printStackTrace();
            System.out.println(e.getMessage());
            return 4;
        } finally {
            //System.out.println("Goodbye!");
            return 5;
        }
    }
    
    public int deleteCertificate(String certId) {
        try {
            Certificate certificate;
            int certPK = Integer.parseInt(certId);
            certificate = em.find(Certificate.class, certPK);
            em.remove(certificate);
            em.flush();
            return 0;
        } catch (DatabaseException ex) {
            //Handle errors for JDBC
            System.out.println(ex.getMessage());
            return 3;
        } catch (PersistenceException ex) {
            //Handle errors for JDBC
            System.out.println(ex.getMessage());
            return 3;
        } catch (Exception e) {
            //Handle errors for Class.forName
            //e.printStackTrace();
            System.out.println(e.getMessage());
            return 4;
        } finally {
            //System.out.println("Goodbye!");
            return 5;
        }
    }
    
    @Override
    public Certificate findCertificateByPrimaryKey(String certKey) throws EntityNotFoundException {
        Certificate certificate;
        try {
            int certPK = Integer.parseInt(certKey);
            certificate = em.find(Certificate.class, certPK);
        } catch (DatabaseException ex) {
            //Handle errors for JDBC
            //System.out.println(ex.getMessage());
            certificate = null;
        } catch (PersistenceException ex) {
            //Handle errors for JDBC
            //System.out.println(ex.getMessage());
            //return 3;
            certificate = null;
        }

        if (certificate == null) {
            throw new EntityNotFoundException("A certificate with primary key : " + certKey + " couldnot be found");
        } else {
            return certificate;
        }
    }

    @Override
    public Certificate findCertificateByCompanyAndCode(String comp, String certCode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Certificate findCertificateByCompanyAndAbbrev(String comp, String certAbbr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Certificate findCertificateByCompanyAndName(String comp, String certName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
