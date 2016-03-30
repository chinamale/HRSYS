/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Local
public interface IAppraisal {
int inputAppraisal(String emplono, String company, Date appra_date, String appr_quarter, String appr_period, String appra_score);    
}
