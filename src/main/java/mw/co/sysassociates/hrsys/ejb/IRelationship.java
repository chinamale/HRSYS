/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import javax.ejb.Local;
import mw.co.sysassociates.hrsys.entity.Relationship;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Local
public interface IRelationship {
int addRelationship(String company, String description, String validfor, int agelimit);
int removeRelationship(String company, int code);
Relationship findRelationshipByCompAndCode(String comp,int code);
Relationship findRelationshipByCompAndDescr(String comp,String description);
}
