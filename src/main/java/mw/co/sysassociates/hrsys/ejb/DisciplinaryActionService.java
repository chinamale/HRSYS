/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mw.co.sysassociates.hrsys.entity.AppraisalScore;
import mw.co.sysassociates.hrsys.entity.DisciplinaryAction;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Stateless
@Local(IDisciplinaryAction.class)
public class DisciplinaryActionService implements IDisciplinaryAction {
    @PersistenceContext
    EntityManager em;
    @Override
    public int addDisciplinaryAction(DisciplinaryAction disciplinaryaction) {
            em.persist(disciplinaryaction);
            return 1;
    }

    @Override
    public int removeDisciplinaryAction(DisciplinaryAction disciplinaryaction) {
            em.remove(disciplinaryaction);
            return 1;
    }

    @Override
    public DisciplinaryAction findDisciplinaryActionByCompAndCode(String comp, int code) {
        List<DisciplinaryAction> elementList = em.createNamedQuery("DisciplinaryAction.findByCompAndCode").setParameter("comp", comp).setParameter("code", code).getResultList();
        return elementList.isEmpty() ? null : elementList.get(0);
    }

    @Override
    public DisciplinaryAction findDisciplinaryActionByCompAndDescr(String comp, String description) {
        List<DisciplinaryAction> elementList = em.createNamedQuery("DisciplinaryAction.findByCompAndName").setParameter("comp", comp).setParameter("name", description).getResultList();
        return elementList.isEmpty() ? null : elementList.get(0);
    }
    
}
