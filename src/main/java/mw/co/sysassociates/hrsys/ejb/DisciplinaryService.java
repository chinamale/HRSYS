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
import mw.co.sysassociates.hrsys.entity.Disciplinary;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Stateless
@Local(IDisciplinary.class)
public class DisciplinaryService implements IDisciplinary{
    @PersistenceContext
    EntityManager em;
    @Override
    public int insertDisciplinaryCase(Disciplinary disciplinary) {
        em.persist(disciplinary);
        return 1;
    }
    
}
