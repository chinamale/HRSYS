/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import javax.ejb.Local;
import mw.co.sysassociates.hrsys.entity.AppraisalScore;
import mw.co.sysassociates.hrsys.entity.Company;
import mw.co.sysassociates.hrsys.entity.Division;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Local
public interface IDivision {
int addDivision(String company, String code, String name, String longname, String abbreviation, String headedby);
Division findDivisionByCompAndCode(Company comp,String divcode);    
}
