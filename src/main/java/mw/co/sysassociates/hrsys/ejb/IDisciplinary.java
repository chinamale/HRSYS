/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import javax.ejb.Local;
import mw.co.sysassociates.hrsys.entity.Disciplinary;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Local
public interface IDisciplinary {
    public int insertDisciplinaryCase(Disciplinary disciplinary);
}
