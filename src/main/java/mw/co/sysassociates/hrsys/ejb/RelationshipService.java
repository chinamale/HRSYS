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
import mw.co.sysassociates.hrsys.entity.Company;
import mw.co.sysassociates.hrsys.entity.Relationship;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Stateless
@Local(IRelationship.class)
public class RelationshipService implements IRelationship {
    @PersistenceContext
    EntityManager em;
    @Override
    public int addRelationship(String company, String description, String validfor, int agelimit) {
     try {
        Relationship rltionship;
        Company comp = em.find(Company.class, company);
        rltionship = new Relationship();
        rltionship.setDescription(description);
        rltionship.setCompany(comp);
        rltionship.setAgelimit(agelimit);
        rltionship.setValidfor(validfor);
        em.persist(rltionship);
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
            System.out.println(e.getMessage());
            return 4;
        } finally {
            //System.out.println("Goodbye!");
            return 5;
        }
    }

    @Override
    public int removeRelationship(String company, int code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Relationship findRelationshipByCompAndCode(String comp, int code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Relationship findRelationshipByCompAndDescr(String comp, String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
