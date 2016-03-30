/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import javax.ejb.Local;
import mw.co.sysassociates.hrsys.entity.DisciplinaryAction;
/**
 *
 * @author Clifton T. Mtengezo
 */
@Local
public interface IDisciplinaryAction {
int addDisciplinaryAction(DisciplinaryAction disciplinaryaction);
int removeDisciplinaryAction(DisciplinaryAction disciplinaryaction);
DisciplinaryAction findDisciplinaryActionByCompAndCode(String comp,int code);
DisciplinaryAction findDisciplinaryActionByCompAndDescr(String comp,String description);   
}
