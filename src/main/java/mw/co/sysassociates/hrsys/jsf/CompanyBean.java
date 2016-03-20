/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.jsf;

import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJBException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mw.co.sysassociates.hrsys.ejb.ICompany;
import mw.co.sysassociates.hrsys.entity.Company;
import mw.co.sysassociates.hrsys.exceptions.EntityFoundException;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Named("companyBean")
@ViewScoped
public class CompanyBean implements Serializable {

    @Inject
    private ICompany companySrvc;
    private Company company = new Company();
    private String companyId;
    private String companyName;
    private String companyShortname;
    private String taxAuthAddress1;
    private String taxAuthFax;
    private String taxAuthAddress;
    private String taxAuthPhysicalAddress;
    private String taxAuthShortname;
    private String taxAuthPhysicalAddress1;
    private String taxAuthName;
    private String taxAuthTelephone;
    private String payeRef;
    private String taxAuthAddress2;
    private String carryFwdBalances;
    private Double numberOfWorkingHoursPerDay;
    private Double numberOfWorkingDaysPerMonth;
    private String mainAccountnumber;
    private Byte employeeNumberFldLength;
    private String taxAuthAddress4;
    private String leaveEntitlementStartsFrom;
    private String endOfyearTax;
    private Double leaveGrantAmount;
    private String endOfyearPersSys;
    private String leaveGrantDeterminedBy;
    private String endOfyearLoansSys;
    private String probationPeriodDeterminedBy;
    private String endOfyearMedicalAidSys;
    private String leaveEntitlCalcBaseDate;
    private String endOfyearPensionSys;
    private String leaveEntitlCalcMethod;
    private String endOfyearPayrollSys;
    private Double numberOfPeriods;
    private String defaultSalariesAccountnumber;
    private String periodStartdate;
    private String defaultEmployeeStatus;
    private String payFrequency;
    private Double pensionAdminCharge;
    private String medicalaidCircleEndDate;
    private Double offenceValidFor;
    private Date payrollDate;
    private String passInsertNewEmp;
    private String passForDelEmpl;
    private String passForPayroll;
    private String passForEOMP;
    private String passForChangeSal;
    private String passForTaxYearend;
    private String passForResetTranshist;
    private String passForPersYearEnd;
    private Double pensionContribution;
    private Date systemDate;
    private String taxAuthAddress3;
    private String currentPeriodYear;
    private String currentPeriodMonth;
    private String taxreconFlag;
    private Double probationPeriod;
    private String abbreviation;
    private String address;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String fax;
    private String website;
    private String emailAddress;
    private String physicalAddress;
    private String physicalAddress1;
    private String payslipMessage;
    private String payslipMessage1;
    private String payslipMessage2;
    private String payslipMessage3;
    private Double minimumMonthlyGrossSalary;
    private Double minimumMonthlyNetSalary;
    private String actionTakenNetsalaryLow;
    private String salaryFileEncryptionKey;
    private Double tevetLevy;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    
    public CompanyBean() {
    }

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

    public String getTaxAuthAddress1() {
        return taxAuthAddress1;
    }

    public void setTaxAuthAddress1(String taxAuthAddress1) {
        this.taxAuthAddress1 = taxAuthAddress1;
    }

    public String getTaxAuthFax() {
        return taxAuthFax;
    }

    public void setTaxAuthFax(String taxAuthFax) {
        this.taxAuthFax = taxAuthFax;
    }

    public String getTaxAuthAddress() {
        return taxAuthAddress;
    }

    public void setTaxAuthAddress(String taxAuthAddress) {
        this.taxAuthAddress = taxAuthAddress;
    }

    public String getTaxAuthPhysicalAddress() {
        return taxAuthPhysicalAddress;
    }

    public void setTaxAuthPhysicalAddress(String taxAuthPhysicalAddress) {
        this.taxAuthPhysicalAddress = taxAuthPhysicalAddress;
    }

    public String getTaxAuthShortname() {
        return taxAuthShortname;
    }

    public void setTaxAuthShortname(String taxAuthShortname) {
        this.taxAuthShortname = taxAuthShortname;
    }

    public String getTaxAuthPhysicalAddress1() {
        return taxAuthPhysicalAddress1;
    }

    public void setTaxAuthPhysicalAddress1(String taxAuthPhysicalAddress1) {
        this.taxAuthPhysicalAddress1 = taxAuthPhysicalAddress1;
    }

    public String getTaxAuthName() {
        return taxAuthName;
    }

    public void setTaxAuthName(String taxAuthName) {
        this.taxAuthName = taxAuthName;
    }

    public String getTaxAuthTelephone() {
        return taxAuthTelephone;
    }

    public void setTaxAuthTelephone(String taxAuthTelephone) {
        this.taxAuthTelephone = taxAuthTelephone;
    }

    public String getPayeRef() {
        return payeRef;
    }

    public void setPayeRef(String payeRef) {
        this.payeRef = payeRef;
    }

    public String getTaxAuthAddress2() {
        return taxAuthAddress2;
    }

    public void setTaxAuthAddress2(String taxAuthAddress2) {
        this.taxAuthAddress2 = taxAuthAddress2;
    }

    public String getCarryFwdBalances() {
        return carryFwdBalances;
    }

    public void setCarryFwdBalances(String carryFwdBalances) {
        this.carryFwdBalances = carryFwdBalances;
    }

    public Double getNumberOfWorkingHoursPerDay() {
        return numberOfWorkingHoursPerDay;
    }

    public void setNumberOfWorkingHoursPerDay(Double numberOfWorkingHoursPerDay) {
        this.numberOfWorkingHoursPerDay = numberOfWorkingHoursPerDay;
    }

    public Double getNumberOfWorkingDaysPerMonth() {
        return numberOfWorkingDaysPerMonth;
    }

    public void setNumberOfWorkingDaysPerMonth(Double numberOfWorkingDaysPerMonth) {
        this.numberOfWorkingDaysPerMonth = numberOfWorkingDaysPerMonth;
    }

    public String getMainAccountnumber() {
        return mainAccountnumber;
    }

    public void setMainAccountnumber(String mainAccountnumber) {
        this.mainAccountnumber = mainAccountnumber;
    }

    public Byte getEmployeeNumberFldLength() {
        return employeeNumberFldLength;
    }

    public void setEmployeeNumberFldLength(Byte employeeNumberFldLength) {
        this.employeeNumberFldLength = employeeNumberFldLength;
    }

    public String getTaxAuthAddress4() {
        return taxAuthAddress4;
    }

    public void setTaxAuthAddress4(String taxAuthAddress4) {
        this.taxAuthAddress4 = taxAuthAddress4;
    }

    public String getLeaveEntitlementStartsFrom() {
        return leaveEntitlementStartsFrom;
    }

    public void setLeaveEntitlementStartsFrom(String leaveEntitlementStartsFrom) {
        this.leaveEntitlementStartsFrom = leaveEntitlementStartsFrom;
    }

    public String getEndOfyearTax() {
        return endOfyearTax;
    }

    public void setEndOfyearTax(String endOfyearTax) {
        this.endOfyearTax = endOfyearTax;
    }

    public Double getLeaveGrantAmount() {
        return leaveGrantAmount;
    }

    public void setLeaveGrantAmount(Double leaveGrantAmount) {
        this.leaveGrantAmount = leaveGrantAmount;
    }

    public String getEndOfyearPersSys() {
        return endOfyearPersSys;
    }

    public void setEndOfyearPersSys(String endOfyearPersSys) {
        this.endOfyearPersSys = endOfyearPersSys;
    }

    public String getLeaveGrantDeterminedBy() {
        return leaveGrantDeterminedBy;
    }

    public void setLeaveGrantDeterminedBy(String leaveGrantDeterminedBy) {
        this.leaveGrantDeterminedBy = leaveGrantDeterminedBy;
    }

    public String getEndOfyearLoansSys() {
        return endOfyearLoansSys;
    }

    public void setEndOfyearLoansSys(String endOfyearLoansSys) {
        this.endOfyearLoansSys = endOfyearLoansSys;
    }

    public String getProbationPeriodDeterminedBy() {
        return probationPeriodDeterminedBy;
    }

    public void setProbationPeriodDeterminedBy(String probationPeriodDeterminedBy) {
        this.probationPeriodDeterminedBy = probationPeriodDeterminedBy;
    }

    public String getEndOfyearMedicalAidSys() {
        return endOfyearMedicalAidSys;
    }

    public void setEndOfyearMedicalAidSys(String endOfyearMedicalAidSys) {
        this.endOfyearMedicalAidSys = endOfyearMedicalAidSys;
    }

    public String getLeaveEntitlCalcBaseDate() {
        return leaveEntitlCalcBaseDate;
    }

    public void setLeaveEntitlCalcBaseDate(String leaveEntitlCalcBaseDate) {
        this.leaveEntitlCalcBaseDate = leaveEntitlCalcBaseDate;
    }

    public String getEndOfyearPensionSys() {
        return endOfyearPensionSys;
    }

    public void setEndOfyearPensionSys(String endOfyearPensionSys) {
        this.endOfyearPensionSys = endOfyearPensionSys;
    }

    public String getLeaveEntitlCalcMethod() {
        return leaveEntitlCalcMethod;
    }

    public void setLeaveEntitlCalcMethod(String leaveEntitlCalcMethod) {
        this.leaveEntitlCalcMethod = leaveEntitlCalcMethod;
    }

    public String getEndOfyearPayrollSys() {
        return endOfyearPayrollSys;
    }

    public void setEndOfyearPayrollSys(String endOfyearPayrollSys) {
        this.endOfyearPayrollSys = endOfyearPayrollSys;
    }

    public Double getNumberOfPeriods() {
        return numberOfPeriods;
    }

    public void setNumberOfPeriods(Double numberOfPeriods) {
        this.numberOfPeriods = numberOfPeriods;
    }

    public String getDefaultSalariesAccountnumber() {
        return defaultSalariesAccountnumber;
    }

    public void setDefaultSalariesAccountnumber(String defaultSalariesAccountnumber) {
        this.defaultSalariesAccountnumber = defaultSalariesAccountnumber;
    }

    public String getPeriodStartdate() {
        return periodStartdate;
    }

    public void setPeriodStartdate(String periodStartdate) {
        this.periodStartdate = periodStartdate;
    }

    public String getDefaultEmployeeStatus() {
        return defaultEmployeeStatus;
    }

    public void setDefaultEmployeeStatus(String defaultEmployeeStatus) {
        this.defaultEmployeeStatus = defaultEmployeeStatus;
    }

    public String getPayFrequency() {
        return payFrequency;
    }

    public void setPayFrequency(String payFrequency) {
        this.payFrequency = payFrequency;
    }

    public Double getPensionAdminCharge() {
        return pensionAdminCharge;
    }

    public void setPensionAdminCharge(Double pensionAdminCharge) {
        this.pensionAdminCharge = pensionAdminCharge;
    }

    public String getMedicalaidCircleEndDate() {
        return medicalaidCircleEndDate;
    }

    public void setMedicalaidCircleEndDate(String medicalaidCircleEndDate) {
        this.medicalaidCircleEndDate = medicalaidCircleEndDate;
    }

    public Double getOffenceValidFor() {
        return offenceValidFor;
    }

    public void setOffenceValidFor(Double offenceValidFor) {
        this.offenceValidFor = offenceValidFor;
    }

    public Date getPayrollDate() {
        return payrollDate;
    }

    public void setPayrollDate(Date payrollDate) {
        this.payrollDate = payrollDate;
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

    public String getPassForResetTranshist() {
        return passForResetTranshist;
    }

    public void setPassForResetTranshist(String passForResetTranshist) {
        this.passForResetTranshist = passForResetTranshist;
    }

    public String getPassForPersYearEnd() {
        return passForPersYearEnd;
    }

    public void setPassForPersYearEnd(String passForPersYearEnd) {
        this.passForPersYearEnd = passForPersYearEnd;
    }

    public Double getPensionContribution() {
        return pensionContribution;
    }

    public void setPensionContribution(Double pensionContribution) {
        this.pensionContribution = pensionContribution;
    }

    public Date getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(Date systemDate) {
        this.systemDate = systemDate;
    }

    public String getTaxAuthAddress3() {
        return taxAuthAddress3;
    }

    public void setTaxAuthAddress3(String taxAuthAddress3) {
        this.taxAuthAddress3 = taxAuthAddress3;
    }

    public String getCurrentPeriodYear() {
        return currentPeriodYear;
    }

    public void setCurrentPeriodYear(String currentPeriodYear) {
        this.currentPeriodYear = currentPeriodYear;
    }

    public String getCurrentPeriodMonth() {
        return currentPeriodMonth;
    }

    public void setCurrentPeriodMonth(String currentPeriodMonth) {
        this.currentPeriodMonth = currentPeriodMonth;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public String getPayslipMessage() {
        return payslipMessage;
    }

    public void setPayslipMessage(String payslipMessage) {
        this.payslipMessage = payslipMessage;
    }

    public String getPayslipMessage1() {
        return payslipMessage1;
    }

    public void setPayslipMessage1(String payslipMessage1) {
        this.payslipMessage1 = payslipMessage1;
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

    public Double getMinimumMonthlyNetSalary() {
        return minimumMonthlyNetSalary;
    }

    public void setMinimumMonthlyNetSalary(Double minimumMonthlyNetSalary) {
        this.minimumMonthlyNetSalary = minimumMonthlyNetSalary;
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

    public String addCompany() throws EntityFoundException, EJBException {
        //String comp = "01";
        //CompanyBean comp = new CompanyBean.CompanyBeanBuilder(companyId, companyName).build();
        int result1 = companySrvc.insertCompany(company);
        //int result = companySrvc.insertCompany(companyId, companyName, companyShortname);
        return "index";
    }
}
