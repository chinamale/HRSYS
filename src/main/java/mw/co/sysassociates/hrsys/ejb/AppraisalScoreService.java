/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import mw.co.sysassociates.hrsys.entity.AppraisalScore;
import mw.co.sysassociates.hrsys.entity.Company;
import mw.co.sysassociates.hrsys.entity.SystemUser;
import mw.co.sysassociates.hrsys.entity.SystemUserGroup;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Stateless
@Local(IAppraisalScore.class)
public class AppraisalScoreService implements IAppraisalScore {
    @PersistenceContext
    EntityManager em;
    @Override
    public int registerApprScore(String company, String code, String name, String longname, String abbreviation) {
        try {
        AppraisalScore appscore;
        Company comp = em.find(Company.class, company);
        appscore = new AppraisalScore();
        appscore.setAbbreviation(abbreviation);
        appscore.setCompany(comp);
        appscore.setLongname(longname);
        appscore.setCode(code);
        appscore.setName(name);
        em.persist(appscore);
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
    public AppraisalScore findAppraisalScoreByCompAndCode(Company comp, String score) {
        //System.out.println("AdminEJB----Searching for user:" + loginname);
        List<AppraisalScore> elementList = em.createNamedQuery("AppraisalScore.findByCompAndCode").setParameter("comp", comp).setParameter("code", score).getResultList();
        // Collection listOfActivities = elementList.get(0).getActivity();
        return elementList.isEmpty() ? null : elementList.get(0);
    }
}
