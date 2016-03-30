/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.jsf;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mw.co.sysassociates.hrsys.cdi.IDepartment;
import mw.co.sysassociates.hrsys.ejb.ICompany;
import mw.co.sysassociates.hrsys.entity.Company;
import mw.co.sysassociates.hrsys.entity.Department;
import mw.co.sysassociates.hrsys.exceptions.EntityFoundException;
import mw.co.sysassociates.hrsys.exceptions.EntityNotFoundException;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Named
@RequestScoped
public class DepartmentBean {
    private Department department = new Department();
    @Inject
    IDepartment departmentSrvc;
    @Inject
    ICompany compSrvc;
    
    public DepartmentBean() {
    }

    public String addDepartment()throws EntityFoundException, EJBException, EntityNotFoundException{
        //String role = "users";
        //company = "01";
        
        //Company company = compSrvc.findCompanyByPrimaryKey("01");
        //department.setCompany(company);
        int result = departmentSrvc.insertDepartment(department);
  
        return "index?faces-redirect=true";
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
 
    @PostConstruct
    public void postConstruct() {
               
        System.out.println("DepartmentBean: PostConstruct");
        Company company;
        try {
            company = compSrvc.findCompanyByPrimaryKey("01");
            department.setCompany(company);
        } catch (EntityNotFoundException ex) {
            Logger.getLogger(DepartmentBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EJBException ex) {
            Logger.getLogger(DepartmentBean.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("DepartmentBean: PreDestroy");
    }
 
}