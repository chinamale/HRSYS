/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import mw.co.sysassociates.hrsys.entity.Appraisal;
import mw.co.sysassociates.hrsys.entity.AppraisalScore;
import mw.co.sysassociates.hrsys.entity.Company;
import mw.co.sysassociates.hrsys.entity.Employee;
import mw.co.sysassociates.hrsys.entity.EmployeePK;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Stateless
@Local(IAppraisal.class)
public class AppraisalService implements IAppraisal {
    
    @PersistenceContext
    EntityManager em;
    
    @EJB
    IAppraisalScore appScoreSrv;
    
    @Override
    public int inputAppraisal(String emplono, String company, Date appr_date, String appr_quarter, String appr_period, String appra_score) {
        try {
        AppraisalScore appscore;
        EmployeePK emplopk;
        
        Company comp = em.find(Company.class, company);
        
        emplopk = new EmployeePK();
        emplopk.setCompany(company);
        emplopk.setEmployeenumber(emplono);
        
        Employee employee = em.find(Employee.class, emplopk);
        
        Appraisal appraisal = new Appraisal();
        appraisal.setEmployee(employee);
        appraisal.setApprPeriod(appr_period);
        appraisal.setApprQuarter(appr_quarter);
        appraisal.setApprdate(appr_date);
        appscore = appScoreSrv.findAppraisalScoreByCompAndCode(comp, appra_score);
        appraisal.setAppraisalscore(appscore);
        em.persist(appraisal);
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
    
}
