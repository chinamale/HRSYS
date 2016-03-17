/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
@NamedQuery(name = "Company.findByAbbreviation", query = "SELECT c FROM Company c WHERE c.abbreviation = :abbrev"),
})
@EntityListeners({CompanyListener.class})
public class Company implements Serializable {
@Id
@Column(name = "COMPANYID", nullable = false,length = 2)
private String companyId;

@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="company")
private List<Employee> employees;

@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="company")
private List<Division> divisions;

@Column(name = "COMPANYNAME", nullable = true,length = 50)
private String companyName;
@Column(name = "COMPANYSHORTNAME", nullable = true,length = 35)
private String companyShortname;
@Column(name = "ABBREVIATION", nullable = true,length = 10)
private String abbreviation;
@Column(name = "ADDRESS", nullable = true,length = 35)
private String address;
@Column(name = "ADDRESS1", nullable = true,length = 35)
private String address1;
@Column(name = "ADDRESS2", nullable = true,length = 35)
private String address2;
@Column(name = "ADDRESS3", nullable = true,length = 35)
private String address3;
@Column(name = "ADDRESS4", nullable = true,length = 35)
private String address4;
@Column(name = "FAX", nullable = true,length = 10)
private String fax;
@Column(name = "WEBSITE", nullable = true,length = 40)
private String website;
@Column(name = "PHYSICALADDRESS", nullable = true,length = 35)
private String physicalAddress;
@Column(name = "PHYSICALADDRESS1", nullable = true,length = 35)
private String physicalAddress1;
@Column(name = "EMAILADDRESS", nullable = true,length = 35)
private String emailAddress;
@Column(name = "CURRENTPERIODMONTH", nullable = true,length = 35)
private String currentPeriodMonth;
@Column(name = "CURRENTPERIODYEAR", nullable = true,length = 35)
private String currentPeriodYear;
@Temporal(TemporalType.DATE)
@Column(name = "SYSTEMDATE")
private Date systemDate;
@Temporal(TemporalType.DATE)
@Column(name = "PAYROLLDATE")
private Date payrollDate;
@Column(name = "MEDICALAIDCIRCLEENDDATE", nullable = true,length = 12)
private String medicalaidCircleEndDate;
@Column(name = "PAYFREQUENCY", nullable = true,length = 1)
private String payFrequency;
@Column(name = "PERIODSTARTDATE", nullable = true,length = 35)
private String periodStartdate;
@Column(name = "NUMBEROFPERIODS")
private Double numberOfPeriods;
@Column(name = "LEAVEENTITLCALCMETHOD", nullable = true,length = 1)
private String leaveEntitlCalcMethod;
@Column(name = "LEAVEENTITLCALCBASEDATE", nullable = true,length = 1)
private String leaveEntitlCalcBaseDate;
@Column(name = "PROBATIONPERIODDETERMINEDBY", nullable = true,length = 1)
private String probationPeriodDeterminedBy;
@Column(name = "LEAVEGRANTDETERMINEDBY", nullable = true,length = 1)
private String leaveGrantDeterminedBy;
@Column(name = "LEAVEGRANTAMOUNT")
private Double leaveGrantAmount;
@Column(name = "LEAVEENTITLEMENTSTARTSFROM", nullable = true,length = 35)
private String leaveEntitlementStartsFrom;
@Column(name = "EMPLOYEENUMBERFLDLENGTH")
private Byte employeeNumberFldLength;
@Column(name = "NUMBEROFWORKINGDAYSPERMONTH")
private Double numberOfWorkingDaysPerMonth;
@Column(name = "NUMBEROFWORKINGHOURSPERDAY")
private Double numberOfWorkingHoursPerDay;
@Column(name = "CARRYFWDBALANCES", nullable = true,length = 1)
private String carryFwdBalances;
@Column(name = "PAYEREF", nullable = true,length = 20)
private String payeRef;
@Column(name = "TAXAUTHNAME", nullable = true,length = 35)
private String taxAuthName;
@Column(name = "TAXAUTHSHORTNAME", nullable = true,length = 35)
private String taxAuthShortname;
@Column(name = "TAXAUTHADDRESS", nullable = true,length = 35)
private String taxAuthAddress;
@Column(name = "TAXAUTHADDRESS1", nullable = true,length = 35)
private String taxAuthAddress1;
@Column(name = "TAXAUTHADDRESS2", nullable = true,length = 35)
private String taxAuthAddress2;
@Column(name = "TAXAUTHADDRESS3", nullable = true,length = 35)
private String taxAuthAddress3;
@Column(name = "TAXAUTHADDRESS4", nullable = true,length = 35)
private String taxAuthAddress4;
@Column(name = "TAXAUTHTELEPHONE", nullable = true,length = 20)
private String taxAuthTelephone;
@Column(name = "TAXAUTHFAX", nullable = true,length = 15)
private String taxAuthFax;
@Column(name = "TAXAUTHPHYSICALADDRESS", nullable = true,length = 20)
private String taxAuthPhysicalAddress;
@Column(name = "TAXAUTHPHYSICALADDRESS1", nullable = true,length = 20)
private String taxAuthPhysicalAddress1;
@Column(name = "INSBY", nullable = true, length = 20)
private String insBy;
@Temporal(TemporalType.DATE)
@Column(name = "INSDATE")
private Date insDate;
@Temporal(TemporalType.DATE)
@Column(name = "AMMDATE")
private Date ammDate;
@Column(name = "AMMBY", nullable = true,length = 35)
private String ammBy;
@Column(name = "MAINBANKACCOUNTNUMBER", nullable = true,length = 15)
private String mainAccountnumber;
@Column(name = "PENSIONCONTRIBUTION", nullable = true,length = 15)
private Double pensionContribution;
@Column(name = "ENDOFYEARTAX", nullable = true,length = 12)
private String endOfyearTax;
@Column(name = "ENDOFYEARPERSSYS", nullable = true,length = 12)
private String endOfyearPersSys;
@Column(name = "ENDOFYEARLOANSSYS", nullable = true,length = 12)
private String endOfyearLoansSys;
@Column(name = "ENDOFYEARMEDICALAIDSYS", nullable = true,length = 12)
private String endOfyearMedicalAidSys;
@Column(name = "ENDOFYEARPENSIONSYS", nullable = true,length = 12)
private String endOfyearPensionSys;
@Column(name = "ENDOFYEARPAYROLLSYS", nullable = true,length = 12)
private String endOfyearPayrollSys;
@Column(name = "DEFAULTSALARIESACCOUNT", nullable = true,length = 15)
private String defaultSalariesAccountnumber;
@Column(name = "DEFAULTEMPLOYEESTATUS", nullable = true,length = 3)
private String defaultEmployeeStatus;
@Column(name = "PENSIONADMINCHARGE")
private Double pensionAdminCharge;
@Column(name = "OFFENCEVALIDFOR")
private Double offenceValidFor;
@Column(name = "PASSFORINSERTNEWEMP", nullable = true,length = 100)
private String passInsertNewEmp;
@Column(name = "PASSFORDELEMPL", nullable = true,length = 100)
private String passForDelEmpl;
@Column(name = "PASSFORPAYROLL", nullable = true,length = 100)
private String passForPayroll;
@Column(name = "PASSFOREOMP", nullable = true,length = 100)
private String passForEOMP;
@Column(name = "PASSFORCHANGESAL", nullable = true,length = 100)
private String passForChangeSal;
@Column(name = "PASSFORTAXYEAREND", nullable = true,length = 100)
private String passForTaxYearend;
@Column(name = "PASSFORPERSYEAREND", nullable = true,length = 100)
private String passForPersYearEnd;
@Column(name = "PASSFORRESETTRANSHIST", nullable = true,length = 100)
private String passForResetTranshist;
@Column(name = "TAXRECONFLAG", nullable = true,length = 1)
private String taxreconFlag;
@Column(name = "PROBATIONPERIOD")
private Double probationPeriod;
@Column(name = "PAYSLIPMESSAGE", nullable = true,length = 35)
private String payslipMessage;
@Column(name = "PAYSLIPMESSAGE1", nullable = true,length = 35)
private String payslipMessage1;
@Column(name = "PAYSLIPMESSAGE2", nullable = true,length = 35)
private String payslipMessage2;
@Column(name = "PAYSLIPMESSAGE3", nullable = true,length = 35)
private String payslipMessage3;
@Column(name = "MINIMUMMONTHLYGROSSSALARY")
private Double minimumMonthlyGrossSalary;
@Column(name = "MINIMUMMONTHLYNETSALARY")
private Double minimumMonthlyNetSalary;
@Column(name = "ACTIONTAKENNETSALARYLOW", nullable = true,length = 1)
private String actionTakenNetsalaryLow;
@Column(name = "SALARYFILEENCRYPTIONKEY", nullable = true,length = 35)
private String salaryFileEncryptionKey;
@Column(name = "TEVETLEVY")
private Double tevetLevy;

//@OneToMany(cascade={CascadeType.ALL},targetEntity=Employee.class,mappedBy="company",fetch=FetchType.EAGER)
//private Collection<Employee> employee;

    public Company() {
    }

 //   public Collection<Employee> getEmployee() {
 //       return employee;
 //   }

 //   public void setEmployee(Collection<Employee> employee) {
 //       this.employee = employee;
 //   }
    
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyShortname() {
        return companyShortname;
    }

    public void setCompanyShortname(String companyShortname) {
        this.companyShortname = companyShortname;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public String getPhysicalAddress1() {
        return physicalAddress1;
    }

    public void setPhysicalAddress1(String physicalAddress1) {
        this.physicalAddress1 = physicalAddress1;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCurrentPeriodMonth() {
        return currentPeriodMonth;
    }

    public void setCurrentPeriodMonth(String currentPeriodMonth) {
        this.currentPeriodMonth = currentPeriodMonth;
    }

    public String getCurrentPeriodYear() {
        return currentPeriodYear;
    }

    public void setCurrentPeriodYear(String currentPeriodYear) {
        this.currentPeriodYear = currentPeriodYear;
    }

    public Date getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(Date systemDate) {
        this.systemDate = systemDate;
    }

    public Date getPayrollDate() {
        return payrollDate;
    }

    public void setPayrollDate(Date payrollDate) {
        this.payrollDate = payrollDate;
    }

    public String getMedicalaidCircleEndDate() {
        return medicalaidCircleEndDate;
    }

    public void setMedicalaidCircleEndDate(String medicalaidCircleEndDate) {
        this.medicalaidCircleEndDate = medicalaidCircleEndDate;
    }

    public String getPayFrequency() {
        return payFrequency;
    }

    public void setPayFrequency(String payFrequency) {
        this.payFrequency = payFrequency;
    }

    public String getPeriodStartdate() {
        return periodStartdate;
    }

    public void setPeriodStartdate(String periodStartdate) {
        this.periodStartdate = periodStartdate;
    }

    public Double getNumberOfPeriods() {
        return numberOfPeriods;
    }

    public void setNumberOfPeriods(Double numberOfPeriods) {
        this.numberOfPeriods = numberOfPeriods;
    }

    public String getLeaveEntitlCalcMethod() {
        return leaveEntitlCalcMethod;
    }

    public void setLeaveEntitlCalcMethod(String leaveEntitlCalcMethod) {
        this.leaveEntitlCalcMethod = leaveEntitlCalcMethod;
    }

    public String getLeaveEntitlCalcBaseDate() {
        return leaveEntitlCalcBaseDate;
    }

    public void setLeaveEntitlCalcBaseDate(String leaveEntitlCalcBaseDate) {
        this.leaveEntitlCalcBaseDate = leaveEntitlCalcBaseDate;
    }

    public String getProbationPeriodDeterminedBy() {
        return probationPeriodDeterminedBy;
    }

    public void setProbationPeriodDeterminedBy(String probationPeriodDeterminedBy) {
        this.probationPeriodDeterminedBy = probationPeriodDeterminedBy;
    }

    public String getLeaveGrantDeterminedBy() {
        return leaveGrantDeterminedBy;
    }

    public void setLeaveGrantDeterminedBy(String leaveGrantDeterminedBy) {
        this.leaveGrantDeterminedBy = leaveGrantDeterminedBy;
    }

    public Double getLeaveGrantAmount() {
        return leaveGrantAmount;
    }

    public void setLeaveGrantAmount(Double leaveGrantAmount) {
        this.leaveGrantAmount = leaveGrantAmount;
    }

    public String getLeaveEntitlementStartsFrom() {
        return leaveEntitlementStartsFrom;
    }

    public void setLeaveEntitlementStartsFrom(String leaveEntitlementStartsFrom) {
        this.leaveEntitlementStartsFrom = leaveEntitlementStartsFrom;
    }

    public Byte getEmployeeNumberFldLength() {
        return employeeNumberFldLength;
    }

    public void setEmployeeNumberFldLength(Byte employeeNumberFldLength) {
        this.employeeNumberFldLength = employeeNumberFldLength;
    }

    public Double getNumberOfWorkingDaysPerMonth() {
        return numberOfWorkingDaysPerMonth;
    }

    public void setNumberOfWorkingDaysPerMonth(Double numberOfWorkingDaysPerMonth) {
        this.numberOfWorkingDaysPerMonth = numberOfWorkingDaysPerMonth;
    }

    public Double getNumberOfWorkingHoursPerDay() {
        return numberOfWorkingHoursPerDay;
    }

    public void setNumberOfWorkingHoursPerDay(Double numberOfWorkingHoursPerDay) {
        this.numberOfWorkingHoursPerDay = numberOfWorkingHoursPerDay;
    }

    public String getCarryFwdBalances() {
        return carryFwdBalances;
    }

    public void setCarryFwdBalances(String carryFwdBalances) {
        this.carryFwdBalances = carryFwdBalances;
    }

    public String getPayeRef() {
        return payeRef;
    }

    public void setPayeRef(String payeRef) {
        this.payeRef = payeRef;
    }

    public String getTaxAuthName() {
        return taxAuthName;
    }

    public void setTaxAuthName(String taxAuthName) {
        this.taxAuthName = taxAuthName;
    }

    public String getTaxAuthShortname() {
        return taxAuthShortname;
    }

    public void setTaxAuthShortname(String taxAuthShortname) {
        this.taxAuthShortname = taxAuthShortname;
    }

    public String getTaxAuthAddress() {
        return taxAuthAddress;
    }

    public void setTaxAuthAddress(String taxAuthAddress) {
        this.taxAuthAddress = taxAuthAddress;
    }

    public String getTaxAuthAddress1() {
        return taxAuthAddress1;
    }

    public void setTaxAuthAddress1(String taxAuthAddress1) {
        this.taxAuthAddress1 = taxAuthAddress1;
    }

    public String getTaxAuthAddress2() {
        return taxAuthAddress2;
    }

    public void setTaxAuthAddress2(String taxAuthAddress2) {
        this.taxAuthAddress2 = taxAuthAddress2;
    }

    public String getTaxAuthAddress3() {
        return taxAuthAddress3;
    }

    public void setTaxAuthAddress3(String taxAuthAddress3) {
        this.taxAuthAddress3 = taxAuthAddress3;
    }

    public String getTaxAuthAddress4() {
        return taxAuthAddress4;
    }

    public void setTaxAuthAddress4(String taxAuthAddress4) {
        this.taxAuthAddress4 = taxAuthAddress4;
    }

    public String getTaxAuthTelephone() {
        return taxAuthTelephone;
    }

    public void setTaxAuthTelephone(String taxAuthTelephone) {
        this.taxAuthTelephone = taxAuthTelephone;
    }

    public String getTaxAuthFax() {
        return taxAuthFax;
    }

    public void setTaxAuthFax(String taxAuthFax) {
        this.taxAuthFax = taxAuthFax;
    }

    public String getTaxAuthPhysicalAddress() {
        return taxAuthPhysicalAddress;
    }

    public void setTaxAuthPhysicalAddress(String taxAuthPhysicalAddress) {
        this.taxAuthPhysicalAddress = taxAuthPhysicalAddress;
    }

    public String getTaxAuthPhysicalAddress1() {
        return taxAuthPhysicalAddress1;
    }

    public void setTaxAuthPhysicalAddress1(String taxAuthPhysicalAddress1) {
        this.taxAuthPhysicalAddress1 = taxAuthPhysicalAddress1;
    }

    public Date getInsDate() {
        return insDate;
    }

    public void setInsDate(Date insDate) {
        this.insDate = insDate;
    }

    public Date getAmmDate() {
        return ammDate;
    }

    public void setAmmDate(Date ammDate) {
        this.ammDate = ammDate;
    }

    public String getAmmBy() {
        return ammBy;
    }

    public void setAmmBy(String ammBy) {
        this.ammBy = ammBy;
    }

    public String getMainAccountnumber() {
        return mainAccountnumber;
    }

    public void setMainAccountnumber(String mainAccountnumber) {
        this.mainAccountnumber = mainAccountnumber;
    }

    public String getEndOfyearTax() {
        return endOfyearTax;
    }

    public void setEndOfyearTax(String endOfyearTax) {
        this.endOfyearTax = endOfyearTax;
    }

    public String getEndOfyearPersSys() {
        return endOfyearPersSys;
    }

    public void setEndOfyearPersSys(String endOfyearPersSys) {
        this.endOfyearPersSys = endOfyearPersSys;
    }

    public String getEndOfyearLoansSys() {
        return endOfyearLoansSys;
    }

    public void setEndOfyearLoansSys(String endOfyearLoansSys) {
        this.endOfyearLoansSys = endOfyearLoansSys;
    }

    public String getEndOfyearMedicalAidSys() {
        return endOfyearMedicalAidSys;
    }

    public void setEndOfyearMedicalAidSys(String endOfyearMedicalAidSys) {
        this.endOfyearMedicalAidSys = endOfyearMedicalAidSys;
    }

    public String getEndOfyearPensionSys() {
        return endOfyearPensionSys;
    }

    public void setEndOfyearPensionSys(String endOfyearPensionSys) {
        this.endOfyearPensionSys = endOfyearPensionSys;
    }

    public String getEndOfyearPayrollSys() {
        return endOfyearPayrollSys;
    }

    public void setEndOfyearPayrollSys(String endOfyearPayrollSys) {
        this.endOfyearPayrollSys = endOfyearPayrollSys;
    }


     public String getDefaultEmployeeStatus() {
        return defaultEmployeeStatus;
    }

    public void setDefaultEmployeeStatus(String defaultEmployeeStatus) {
        this.defaultEmployeeStatus = defaultEmployeeStatus;
    }

     public Double getOffenceValidFor() {
        return offenceValidFor;
    }

    public void setOffenceValidFor(Double offenceValidFor) {
        this.offenceValidFor = offenceValidFor;
    }


    public String getTaxreconFlag() {
        return taxreconFlag;
    }

    public void setTaxreconFlag(String taxreconFlag) {
        this.taxreconFlag = taxreconFlag;
    }

    public Double getProbationPeriod() {
        return probationPeriod;
    }

    public void setProbationPeriod(Double probationPeriod) {
        this.probationPeriod = probationPeriod;
    }

    public String getPayslipMessage() {
        return payslipMessage;
    }

    public void setPayslipMessage(String payslipMessage) {
        this.payslipMessage = payslipMessage;
    }

    public String getPayslipMessage2() {
        return payslipMessage2;
    }

    public void setPayslipMessage2(String payslipMessage2) {
        this.payslipMessage2 = payslipMessage2;
    }

    public String getPayslipMessage3() {
        return payslipMessage3;
    }

    public void setPayslipMessage3(String payslipMessage3) {
        this.payslipMessage3 = payslipMessage3;
    }

     public Double getMinimumMonthlyGrossSalary() {
        return minimumMonthlyGrossSalary;
    }

    public void setMinimumMonthlyGrossSalary(Double minimumMonthlyGrossSalary) {
        this.minimumMonthlyGrossSalary = minimumMonthlyGrossSalary;
    }

    public String getActionTakenNetsalaryLow() {
        return actionTakenNetsalaryLow;
    }

    public void setActionTakenNetsalaryLow(String actionTakenNetsalaryLow) {
        this.actionTakenNetsalaryLow = actionTakenNetsalaryLow;
    }

    public String getSalaryFileEncryptionKey() {
        return salaryFileEncryptionKey;
    }

    public void setSalaryFileEncryptionKey(String salaryFileEncryptionKey) {
        this.salaryFileEncryptionKey = salaryFileEncryptionKey;
    }

    public Double getTevetLevy() {
        return tevetLevy;
    }

    public void setTevetLevy(Double tevetLevy) {
        this.tevetLevy = tevetLevy;
    }

    public String getInsBy() {
        return insBy;
    }

    public void setInsBy(String insBy) {
        this.insBy = insBy;
    }

    public Double getPensionContribution() {
        return pensionContribution;
    }

    public void setPensionContribution(Double pensionContribution) {
        this.pensionContribution = pensionContribution;
    }

    public String getDefaultSalariesAccountnumber() {
        return defaultSalariesAccountnumber;
    }

    public void setDefaultSalariesAccountnumber(String defaultSalariesAccountnumber) {
        this.defaultSalariesAccountnumber = defaultSalariesAccountnumber;
    }

    public Double getPensionAdminCharge() {
        return pensionAdminCharge;
    }

    public void setPensionAdminCharge(Double pensionAdminCharge) {
        this.pensionAdminCharge = pensionAdminCharge;
    }

    public String getPassInsertNewEmp() {
        return passInsertNewEmp;
    }

    public void setPassInsertNewEmp(String passInsertNewEmp) {
        this.passInsertNewEmp = passInsertNewEmp;
    }

    public String getPassForDelEmpl() {
        return passForDelEmpl;
    }

    public void setPassForDelEmpl(String passForDelEmpl) {
        this.passForDelEmpl = passForDelEmpl;
    }

    public String getPassForPayroll() {
        return passForPayroll;
    }

    public void setPassForPayroll(String passForPayroll) {
        this.passForPayroll = passForPayroll;
    }

    public String getPassForEOMP() {
        return passForEOMP;
    }

    public void setPassForEOMP(String passForEOMP) {
        this.passForEOMP = passForEOMP;
    }

    public String getPassForChangeSal() {
        return passForChangeSal;
    }

    public void setPassForChangeSal(String passForChangeSal) {
        this.passForChangeSal = passForChangeSal;
    }

    public String getPassForTaxYearend() {
        return passForTaxYearend;
    }

    public void setPassForTaxYearend(String passForTaxYearend) {
        this.passForTaxYearend = passForTaxYearend;
    }

    public String getPassForPersYearEnd() {
        return passForPersYearEnd;
    }

    public void setPassForPersYearEnd(String passForPersYearEnd) {
        this.passForPersYearEnd = passForPersYearEnd;
    }

    public String getPassForResetTranshist() {
        return passForResetTranshist;
    }

    public void setPassForResetTranshist(String passForResetTranshist) {
        this.passForResetTranshist = passForResetTranshist;
    }

    public String getPayslipMessage1() {
        return payslipMessage1;
    }

    public void setPayslipMessage1(String payslipMessage1) {
        this.payslipMessage1 = payslipMessage1;
    }

    public Double getMinimumMonthlyNetSalary() {
        return minimumMonthlyNetSalary;
    }

    public void setMinimumMonthlyNetSalary(Double minimumMonthlyNetSalary) {
        this.minimumMonthlyNetSalary = minimumMonthlyNetSalary;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Division> getDivisions() {
        return divisions;
    }

    public void setDivisions(List<Division> divisions) {
        this.divisions = divisions;
    }
    
    
      

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.companyId);
        hash = 43 * hash + Objects.hashCode(this.companyName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Company other = (Company) obj;
        if (!Objects.equals(this.companyId, other.companyId)) {
            return false;
        }
        if (!Objects.equals(this.companyName, other.companyName)) {
            return false;
        }
        return true;
    }

}
