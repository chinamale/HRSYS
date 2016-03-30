/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.jsf;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mw.co.sysassociates.hrsys.ejb.ICompany;
import mw.co.sysassociates.hrsys.ejb.IDisciplinary;
import mw.co.sysassociates.hrsys.ejb.IEmployee;
import mw.co.sysassociates.hrsys.entity.Disciplinary;
import mw.co.sysassociates.hrsys.entity.Employee;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Named
@RequestScoped
public class DisciplinaryBean {
    private Disciplinary disciplinary = new Disciplinary();
    private String emplono;
    @Inject
    IDisciplinary disciplanarySrvc;
    @Inject
    ICompany compSrvc;
    @Inject
    IEmployee employeeSrvc;

    public String getEmplono() {
        return emplono;
    }

    public void setEmplono(String emplono) {
        this.emplono = emplono;
    }

  

    public DisciplinaryBean() {
    }

    public Disciplinary getDisciplinary() {
        return disciplinary;
    }

    public void setDisciplinary(Disciplinary disciplinary) {
        this.disciplinary = disciplinary;
    }
        public String addDisciplinary(){
                
        Employee employee = employeeSrvc.findByCompAndEmplono("01", emplono);
        disciplinary.setEmployee(employee);
        int result = disciplanarySrvc.insertDisciplinaryCase(disciplinary);
  
        return "index?faces-redirect=true";
    }
 
    @PostConstruct
    public void postConstruct() {               
        System.out.println("Disciplinary Service: PostConstruct");
        //Employee employee = employeeSrvc.findByCompAndEmplono("01", disciplinary.);
        //disciplinary.setEmployee(employee);
    }
}
