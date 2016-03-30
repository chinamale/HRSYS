/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.cdi;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import mw.co.sysassociates.hrsys.entity.Company;
import mw.co.sysassociates.hrsys.entity.Department;
import mw.co.sysassociates.hrsys.exceptions.EntityFoundException;
import mw.co.sysassociates.hrsys.exceptions.EntityNotFoundException;

/**
 *
 * @author Clifton T. Mtengezo
 */
@RequestScoped
@Default
public class DepartmentService implements IDepartment {
    @PersistenceContext
    EntityManager em;
    @Resource
    private UserTransaction userTransaction;

    @Override
    public Department findDepartmentByPrimaryKey(Integer deprtKey) throws EntityNotFoundException, EJBException {
        Department department;
        try {
            department = em.find(Department.class, deprtKey);
        } catch (EJBException e) {
            department = null;
        }
        if (department == null) {
            throw new EntityNotFoundException("A Department with ID : " + deprtKey + " does not exists");
        } else {
            return department;
        }
    }

    @Override
    public Department findDuplicateDepartmentByPrimaryKey(Integer departKey) throws EJBException, EntityFoundException {
Department department;
        try {
            department = em.find(Department.class,departKey);
        } catch (EJBException e) {
            department = null;
        }
        if (department == null) {
            return department;  
        } else {
            throw new EntityFoundException("A department with ID : " + departKey + " already exists");
        }
    }

    @Override
    public Department findDepartmentByAbbrev(String comp, String departAbbr) throws EntityNotFoundException {
        List<Department> elementList = em.createNamedQuery("Department.findByCompAndAbbr").setParameter("comp", comp).setParameter("abbr", departAbbr).getResultList();
        return elementList.isEmpty() ? null : elementList.get(0);
    }
    
    @Override
    public List<Department> findAllDepartmentByComp(String comp) throws EntityNotFoundException {
        List<Department> elementList = em.createNamedQuery("Department.findAllByCompany").setParameter("comp", comp).getResultList();
        return elementList.isEmpty() ? null : elementList;
    }

    @Override
    public Department findDepartmentByName(String comp, String departName) throws EntityNotFoundException {
        List<Department> elementList = em.createNamedQuery("Department.findByCompAndName").setParameter("comp", comp).setParameter("name", departName).getResultList();
        return elementList.isEmpty() ? null : elementList.get(0);
    }

    @Override
    public Department findDepartment(Department department) throws EntityNotFoundException, EJBException {
        Department depart;
        try {
            depart = em.find(Department.class, department.getId());
        } catch (EJBException e) {
            depart = null;
        }
        if (depart == null) {
            throw new EntityNotFoundException("A Department with name : " + department.getName() + " does not exists");
        } else {
            return depart;
        }
    }

    @Override
    public Department findDuplicateDepartment(Department department) throws EJBException, EntityFoundException {
        Department depart;
        try {
            depart = em.find(Department.class,department.getId());
        } catch (EJBException e) {
            depart = null;
        }
        if (depart == null) {
            return depart;  
        } else {
            throw new EntityFoundException("A department with name : " + department.getName() + " already exists");
        }
    }
    
        @Override
    public Department findDuplicateDepartment(String comp, String code) throws EJBException, EntityFoundException {
        Company company = em.find(Company.class, comp);
        Department depart;
        
        List<Department> elementList = em.createNamedQuery("Department.findByCompAndCode").setParameter("comp", company).setParameter("code", code).getResultList();
        depart= elementList.isEmpty() ? null : elementList.get(0);
        
        if (depart == null) {
            return depart;  
        } else {
            throw new EntityFoundException("A department with code : " + depart.getCode() + " already exists");
        }
    }

    @Override
    public int insertDepartment(Department department) throws EntityFoundException {
        try {
            //try {
                userTransaction.begin();
            //} catch (NotSupportedException ex) {
            //    Logger.getLogger(DepartmentService.class.getName()).log(Level.SEVERE, null, ex);
            //}
            em.persist(department);
            userTransaction.commit();
            return 1;
        } catch (NotSupportedException ex) {
            Logger.getLogger(DepartmentService.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (RollbackException ex) {
            Logger.getLogger(DepartmentService.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(DepartmentService.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(DepartmentService.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (SecurityException ex) {
            Logger.getLogger(DepartmentService.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (IllegalStateException ex) {
            Logger.getLogger(DepartmentService.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (SystemException ex) {
            Logger.getLogger(DepartmentService.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    @PostConstruct
    public void postConstruct() {
        System.out.println("DepartmentService: PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("DepartmentService: PreDestroy");
    }
}
