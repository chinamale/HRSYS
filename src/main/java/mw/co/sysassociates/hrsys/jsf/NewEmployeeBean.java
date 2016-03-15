/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.jsf;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Madalitso Chinamale
 */
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import mw.co.sysassociates.hrsys.ejb.ICompany;
import mw.co.sysassociates.hrsys.ejb.IEmployee;
import mw.co.sysassociates.hrsys.ejb.IUserService;

/**
 *
 * @author parisis
 */
@Named
@RequestScoped
public class NewEmployeeBean {

    @EJB
    IEmployee employeeSrv;
    @EJB
    ICompany compSrv;
    String employeeNo;
    String company;
    String firstname;
    String surname;
    String title;
    String sex;
    public NewEmployeeBean() {

    }

    //call the injected EJB
    public String register() {
        String role = "users";
        int result = compSrv.insertEmployee(employeeNo, firstname,surname,sex,title);
  
        return "index";
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public IEmployee getEmployeeSrv() {
        return employeeSrv;
    }

    public void setEmployeeSrv(IEmployee employeeSrv) {
        this.employeeSrv = employeeSrv;
    }

    public ICompany getCompSrv() {
        return compSrv;
    }

    public void setCompSrv(ICompany compSrv) {
        this.compSrv = compSrv;
    }
    
    
}

