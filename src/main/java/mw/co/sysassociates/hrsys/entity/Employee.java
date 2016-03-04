package mw.co.sysassociates.hrsys.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Clifton T. Mtengezo
 */

    @Entity
        @NamedQueries({
	@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
        @NamedQuery(name = "Employee.findByFirstname", query = "SELECT e FROM Employee e WHERE e.firstname = :firstname"),
    })
    @EntityListeners({EmployeeListener.class})
    public class Employee extends AuditFields implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    
    @OneToMany(cascade=CascadeType.ALL,mappedBy="")
    private List<Education> education;

    @OneToMany(cascade=CascadeType.ALL,mappedBy="")
    private List<LeaveDetails> leaveDetails;
    
    @OneToMany(cascade=CascadeType.ALL,mappedBy="")
    private List<Dependant> dependant;

    //@OneToMany(cascade=CascadeType.ALL,mappedBy="employee",fetch = FetchType.EAGER)
//    @ElementCollection
//    @CollectionTable(name="PrevEmployer",joinColumns ={
//    @JoinColumn(name="COMPANY", referencedColumnName="COMPANY"),
//    @JoinColumn(name="EMPLOYEE", referencedColumnName="EMPLOYEENUMBER")})
    @OneToMany(mappedBy="employee",targetEntity=PrevEmployer.class,fetch=FetchType.EAGER)
    private Collection prevEmployer;

    public Collection getPrevEmployer() {
        return prevEmployer;
    }

    public void setPrevEmployer(Collection prevEmployer) {
        this.prevEmployer = prevEmployer;
    }
       
    public List<Dependant> getDependant() {
        return dependant;
    }

    public void setDependant(List<Dependant> dependant) {
        this.dependant = dependant;
    }
        
    public List<Education> getEducation() {
        return education;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }
    
    @EmbeddedId
    private EmployeePK emploPK;

    public EmployeePK getEmploPK() {
        return emploPK;
    }

    public void setEmploPK(EmployeePK emploPK) {
        this.emploPK = emploPK;
    }
    
    //@Column(name="corp_fk")
    //private Integer Corp_fk; // Foreign key to table corporation
    
    @ManyToOne
    @JoinColumn(name="company",nullable=false, insertable=false, updatable=false)
    private Company company;  // Added to support joined query
    public Company getCompany() {
        return company;
    }
          
    @Column(name = "ADDRESSOFNEXTOFKIN4", nullable = true,length = 35)
    private String addressofnextofkin4;
    @Column(name = "ADDRESSOFNEXTOFKIN", nullable = true,length = 35)
    private String addressofnextofkin;
    @Column(name = "ADDRESSOFNEXTOFKIN1", nullable = true,length = 35)
    private String addressofnextofkin1;
    @Column(name = "ADDRESSOFNEXTOFKIN2", nullable = true,length = 35)
    private String addressofnextofkin2;
    @Column(name = "ADDRESSOFNEXTOFKIN3", nullable = true,length = 35)
    private String addressofnextofkin3;
    @Column(name = "ADDRESSOFSPOUSE", nullable = true,length = 35)
    private String addressofspouse;
    @Column(name = "ADDRESSOFSPOUSE1", nullable = true,length = 35)
    private String addressofspouse1;
    @Column(name = "ADDRESSOFSPOUSE2", nullable = true,length = 35)
    private String addressofspouse2;
    @Column(name = "ADDRESSOFSPOUSE3", nullable = true,length = 35)
    private String addressofspouse3;
    @Column(name = "ADDRESSOFSPOUSE4", nullable = true,length = 35)
    private String addressofspouse4;
//    @Column(name = "AMMBY", nullable = true,length = 35)
//    private String ammby;
//    @Temporal(TemporalType.DATE)
//    @Column(name = "AMMDATE")
//    private Date ammdate;
    @Column(name = "ANNUALLEAVEDAYSTAKEN")
    private double annualleavedaystaken;
    @Column(name = "ANNUALLEAVEENTITLEMENT")
    private double annualleaveentitlement;
    @Column(name = "ANNUALLEAVEINDICATOR", nullable = true,length = 1)
    private String annualleaveindicator;
    @Column(name = "BANKACCOUNTNUMBER", nullable = true,length = 20)
    private String bankaccountnumber;
    @Column(name = "BASICPAYDETERMINATIONMETHOD", nullable = true,length = 1)
    private String basicdeterminationmethod;
    @Column(name = "COMPANYCONTRIBUTION")
    private double companycontributions;
    //@Column(name = "COMPANYID", nullable = true,length = 2)
    //private String companyid;
    @Column(name = "CPSLEAVEDAYSTAKEN")
    private double cpsleavedaystaken;
    @Column(name = "CPSLEAVEENTITLEMENT")
    private double cpsleaveentitlement;
    @Column(name = "CURRENTGRADE", nullable = true,length = 5)
    private String currentgrade;
    @Column(name = "CURRENTPOSITION", nullable = true,length = 35)
    private String currentposition;
    @Column(name = "CURRENTSALARY")
    private BigDecimal currentsalary;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATECONFIRMED")
    private Date dateconfirmed;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATEJOINED")
    private Date datejoined;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATELASTCONTRIBUTEDPENSION")
    private Date datelastcontributepension;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATELASTRECEIVEDSALARY")
    private Date datelastreceivedsalary;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATELASTSALARYCHANGE")
    private Date datelastsalarychange;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATELEAVEGRANTTAKEN")
    private Date dateleavegranttaken;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATELEFT")
    private Date dateleft;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATEOFBIRTH")
    private Date dateofbirth;
    @Column(name = "DEPENDANTSUNDERMEDAID")
    private byte dependantsundermedicalscheme;
    @Temporal(TemporalType.DATE)
    @Column(name = "DESIGDATE")
    private Date desigdate;
    @Column(name = "DESIGWHENJOINING", nullable = true,length = 35)
    private String desigwhenjoining;
    @Column(name = "DISCIPLSTATUS", nullable = true,length = 3)
    private String disciplstatus;
    @Column(name = "DISTRICT", nullable = true,length = 35)
    private String district;
    @Column(name = "DIVISION", nullable = true,length = 20)
    private String division;
    @Column(name = "DEPARTMENT", nullable = true,length = 20)
    private String department;
    @Column(name = "SECTION", nullable = true,length = 20)
    private String SECT;
    @Column(name = "EMPLOYEECONTRIBUTION")
    private double employeecontributions;
    //@Id
    //@Basic(optional = false)
    //@Column(name = "EMPLOYEENUMBER", length = 10)
    //private String employeenumber;
    @Column(name = "EMPLOYMENTSTATUS", nullable = true,length = 1)
    private String employmentstatus;
    @Column(name = "ETIN", nullable = true,length = 20)
    private String etin;
    @ManyToOne
    @JoinColumn(name="establishedposition",nullable=true, insertable=false, updatable=false)
    private EstablishedPosition establishedposition;
    @Column(name = "FIRSTNAME", nullable = true,length = 35)
    private String firstname;
    @Column(name = "GRADEWHENJOINING", nullable = true,length = 3)
    private String gradewhenjoining;
    @Column(name = "HIGHESTEDUQUALIF", nullable = true,length = 5)
    private String highesteducationqualifi;
    @Column(name = "HIGHESTPROFQUALIF", nullable = true,length = 5)
    private String highestproffessionalqualifi;
    @Column(name = "HOUSEINDICATOR", nullable = true,length = 1)
    private String housedindicator;
    private double hourlyrate;
    @Column(name = "HOUSEALLOCATED", nullable = true,length = 15)
    private String houseallocated;
    @Column(name = "INITIALS", nullable = true,length = 3)
    private String initials;
//    @Column(name = "INSBY", nullable = true,length = 20)
//    private String insby;
//    @Temporal(TemporalType.DATE)
//    @Column(name = "INSDATE")
//    private Date insdate;
    @Column(name = "LARGESTCONTSICKLEAVETAKEN")
    private double largestcontsickleavetaken;
    @Column(name = "LOANSINDICATOR", nullable = true,length = 1)
    private String loansindicator;
    @Column(name = "WORKSTATION", nullable = true,length = 20)
    private String workstation;
    @Column(name = "MARITALSTATUS", nullable = true,length = 1)
    private String maritalstatus;
    @Column(name = "MEDICALAIDINDICATOR", nullable = true,length = 1)
    private String medicalaidindicator;
    @Column(name = "MEDICALAIDPROVIDER", nullable = true,length = 20)
    private String medicalaidprovider;
    @Column(name = "MEDICALSCHEMENUMBER", nullable = true,length = 20)
    private String medicalschemenumber;
    @Column(name = "MEDICALSCHEMETYPE", nullable = true,length = 15)
    private String medicalschemetype;
    @Column(name = "NATIONALITY", nullable = true,length = 20)
    private String nationality;
    @Column(name = "SALARYNOTCH", nullable = true,length = 20)
    private String salarynoth;
    @Column(name = "NEXTOFKIN", nullable = true,length = 5)
    private String nextofkin;
    @Column(name = "NUMBEROFDEPENDANTS")
    private byte numberofdependants;
    @Column(name = "OLDSALARY")
    private BigDecimal oldsalary;
    @Column(name = "PAYEREGISTEREDINDICATOR", nullable = true,length = 1)
    private String payeregisteredindicator;
    @Temporal(TemporalType.DATE)
    @Column(name = "PAYEREGISTRATIONDATE")
    private Date payeregistrationdate;
    @Column(name = "PAYROLLINDICATOR", nullable = true,length = 1)
    private String payrollindicator;
    @Column(name = "PENSIONCOMPANY", nullable = true,length = 15)
    private String pensioncompany;
    @Column(name = "PENSIONINDICATOR", nullable = true,length = 1)
    private String pensionindicator;
    @Column(name = "PENSIONNUMBER", nullable = true,length = 15)
    private String pensionnumber;
    @Temporal(TemporalType.DATE)
    @Column(name = "PENSIONSTARTDATE")
    private Date pensionstartdate;
    @Column(name = "PERFORMANCERATING", nullable = true,length = 5)
    private String performancerating;
    @Column(name = "PICTURE", nullable = true,length = 20)
    private String picture;
    @Column(name = "POLICYTYPE", nullable = true,length = 20)
    private String policytype;
    @Column(name = "PREVYEARANNUALLEAVEDAYSBAL")
    private double prevyearannualleavedaysbalance;
    @Column(name = "PREVYEARANNUALLEAVEENTITLEMENT")
    private double prevyearannualleaveentitlement;
    @Column(name = "RELATIONSHIPWITHNEXTOFKIN", nullable = true,length = 2)
    private String relationshipwithnextofkin;
    @Column(name = "SALARYBANK", nullable = true,length = 20)
    private String salarybank;
    @Column(name = "SALARYBRANCH", nullable = true,length = 20)
    private String salarybranch;
    @Column(name = "SALARYPAYMENTFREQUENCY", nullable = true,length = 20)
    private String salarypaymentfrequency;
    @Column(name = "SALARYPAYMENTMETHOD", nullable = true,length = 2)
    private String salarypaymentmethod;
    @Column(name = "SALARYSTATUS", nullable = true,length = 1)
    private String salarystatus;
    @Column(name = "SCKLEAVEENTITLEMENT")
    private double sckleaveentitlement;
    @Column(name = "SEX", nullable = true,length = 1)
    private String sex;
    @Column(name = "SICKLEAVEDAYSTAKEN")
    private double sickleavedaystaken;
    @Column(name = "SPOUSE", nullable = true,length = 20)
    private String spouse;
    @Column(name = "STARTINGSALARY")
    private BigDecimal startingsalary;
    @Column(name = "SURNAME", nullable = true,length = 35)
    private String surname;
    @Column(name = "TAKENLEAVEGRANT", nullable = true,length = 1)
    private String takenleavegrant;
    @Column(name = "PAYACCOUNTNUMBER", nullable = true,length = 20)
    private String payaccountnumber;
    @Column(name = "TITLE", nullable = true,length = 5)
    private String title;
    @Column(name = "TRADITIONALAUTHORITY", nullable = true,length = 35)
    private String traditionalauthority;
    @Column(name = "VILLAGE", nullable = true,length = 35)
    private String village;

    public Employee() {
    }

public Employee(String employeeNo, String company, String firstname, String surname, String sex, String title){

}
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public void setCompany(Company company) {
        this.company = company;
    }

    
    
    public String getAddressofnextofkin4() {
        return addressofnextofkin4;
    }
    public void setAddressofnextofkin4(String addressofnextofkin4) {
        this.addressofnextofkin4 = addressofnextofkin4;
    }

    public String getAddressofnextofkin() {
        return addressofnextofkin;
    }

    public void setAddressofnextofkin(String addressofnextofkin) {
        this.addressofnextofkin = addressofnextofkin;
    }

    public String getAddressofnextofkin1() {
        return addressofnextofkin1;
    }

    public void setAddressofnextofkin1(String addressofnextofkin1) {
        this.addressofnextofkin1 = addressofnextofkin1;
    }

    public String getAddressofnextofkin3() {
        return addressofnextofkin3;
    }

    public void setAddressofnextofkin3(String addressofnextofkin3) {
        this.addressofnextofkin3 = addressofnextofkin3;
    }

    public String getAddressofnextofkin2() {
        return addressofnextofkin2;
    }

    public void setAddressofnextofkin2(String addressofnextofkin2) {
        this.addressofnextofkin2 = addressofnextofkin2;
    }

    public String getAddressofspouse() {
        return addressofspouse;
    }

    public void setAddressofspouse(String addressofspouse) {
        this.addressofspouse = addressofspouse;
    }

    public String getAddressofspouse1() {
        return addressofspouse1;
    }

    public void setAddressofspouse1(String addressofspouse1) {
        this.addressofspouse1 = addressofspouse1;
    }

    public String getAddressofspouse2() {
        return addressofspouse2;
    }

    public void setAddressofspouse2(String addressofspouse2) {
        this.addressofspouse2 = addressofspouse2;
    }

    public String getAddressofspouse3() {
        return addressofspouse3;
    }

    public void setAddressofspouse3(String addressofspouse3) {
        this.addressofspouse3 = addressofspouse3;
    }

    public String getAddressofspouse4() {
        return addressofspouse4;
    }

    public void setAddressofspouse4(String addressofspouse4) {
        this.addressofspouse4 = addressofspouse4;
    }

    public String getAnnualleaveindicator() {
        return annualleaveindicator;
    }

    public void setAnnualleaveindicator(String annualleaveindicator) {
        this.annualleaveindicator = annualleaveindicator;
    }

    public String getBankaccountnumber() {
        return bankaccountnumber;
    }

    public void setBankaccountnumber(String bankaccountnumber) {
        this.bankaccountnumber = bankaccountnumber;
    }

    public String getBasicdeterminationmethod() {
        return basicdeterminationmethod;
    }

    public void setBasicdeterminationmethod(String basicdeterminationmethod) {
        this.basicdeterminationmethod = basicdeterminationmethod;
    }

  //  public String getCompanyid() {
  //      return companyid;
  //  }

  //  public void setCompanyid(String companyid) {
  //      this.companyid = companyid;
  //  }

    public String getCurrentgrade() {
        return currentgrade;
    }

    public void setCurrentgrade(String currentgrade) {
        this.currentgrade = currentgrade;
    }

    public String getCurrentposition() {
        return currentposition;
    }

    public void setCurrentposition(String currentposition) {
        this.currentposition = currentposition;
    }

    public BigDecimal getCurrentsalary() {
        return currentsalary;
    }

    public void setCurrentsalary(BigDecimal currentsalary) {
        this.currentsalary = currentsalary;
    }

    public Date getDateconfirmed() {
        return dateconfirmed;
    }

    public void setDateconfirmed(Date dateconfirmed) {
        this.dateconfirmed = dateconfirmed;
    }

    public Date getDatejoined() {
        return datejoined;
    }

    public void setDatejoined(Date datejoined) {
        this.datejoined = datejoined;
    }

    public Date getDatelastcontributepension() {
        return datelastcontributepension;
    }

    public void setDatelastcontributepension(Date datelastcontributepension) {
        this.datelastcontributepension = datelastcontributepension;
    }

    public Date getDatelastreceivedsalary() {
        return datelastreceivedsalary;
    }

    public void setDatelastreceivedsalary(Date datelastreceivedsalary) {
        this.datelastreceivedsalary = datelastreceivedsalary;
    }

    public Date getDatelastsalarychange() {
        return datelastsalarychange;
    }

    public void setDatelastsalarychange(Date datelastsalarychange) {
        this.datelastsalarychange = datelastsalarychange;
    }

    public Date getDateleavegranttaken() {
        return dateleavegranttaken;
    }

    public void setDateleavegranttaken(Date dateleavegranttaken) {
        this.dateleavegranttaken = dateleavegranttaken;
    }

    public Date getDateleft() {
        return dateleft;
    }

    public void setDateleft(Date dateleft) {
        this.dateleft = dateleft;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public Date getDesigdate() {
        return desigdate;
    }

    public void setDesigdate(Date desigdate) {
        this.desigdate = desigdate;
    }

    public String getDesigwhenjoining() {
        return desigwhenjoining;
    }

    public void setDesigwhenjoining(String desigwhenjoining) {
        this.desigwhenjoining = desigwhenjoining;
    }

    public String getDisciplstatus() {
        return disciplstatus;
    }

    public void setDisciplstatus(String disciplstatus) {
        this.disciplstatus = disciplstatus;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

  //  public String getEmployeenumber() {
  //      return employeenumber;
  //  }

  //  public void setEmployeenumber(String employeenumber) {
  //      this.employeenumber = employeenumber;
  //  }

    public String getEmploymentstatus() {
        return employmentstatus;
    }

    public void setEmploymentstatus(String employmentstatus) {
        this.employmentstatus = employmentstatus;
    }

    public String getEtin() {
        return etin;
    }

    public void setEtin(String etin) {
        this.etin = etin;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getGradewhenjoining() {
        return gradewhenjoining;
    }

    public void setGradewhenjoining(String gradewhenjoining) {
        this.gradewhenjoining = gradewhenjoining;
    }

    public String getHighesteducationqualifi() {
        return highesteducationqualifi;
    }

    public void setHighesteducationqualifi(String highesteducationqualifi) {
        this.highesteducationqualifi = highesteducationqualifi;
    }

    public String getHighestproffessionalqualifi() {
        return highestproffessionalqualifi;
    }

    public void setHighestproffessionalqualifi(String highestproffessionalqualifi) {
        this.highestproffessionalqualifi = highestproffessionalqualifi;
    }

    public String getHousedindicator() {
        return housedindicator;
    }

    public void setHousedindicator(String housedindicator) {
        this.housedindicator = housedindicator;
    }

    public String getHouseallocated() {
        return houseallocated;
    }

    public void setHouseallocated(String houseallocated) {
        this.houseallocated = houseallocated;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

//    public String getInsby() {
//        return insby;
//    }
//
//    public void setInsby(String insby) {
//        this.insby = insby;
//    }
//
//    public Date getInsdate() {
//        return insdate;
//    }
//
//    public void setInsdate(Date insdate) {
//        this.insdate = insdate;
//    }

    public String getLoansindicator() {
        return loansindicator;
    }

    public void setLoansindicator(String loansindicator) {
        this.loansindicator = loansindicator;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getMedicalaidindicator() {
        return medicalaidindicator;
    }

    public void setMedicalaidindicator(String medicalaidindicator) {
        this.medicalaidindicator = medicalaidindicator;
    }

    public String getMedicalaidprovider() {
        return medicalaidprovider;
    }

    public void setMedicalaidprovider(String medicalaidprovider) {
        this.medicalaidprovider = medicalaidprovider;
    }

    public String getMedicalschemenumber() {
        return medicalschemenumber;
    }

    public void setMedicalschemenumber(String medicalschemenumber) {
        this.medicalschemenumber = medicalschemenumber;
    }

    public String getMedicalschemetype() {
        return medicalschemetype;
    }

    public void setMedicalschemetype(String medicalschemetype) {
        this.medicalschemetype = medicalschemetype;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNextofkin() {
        return nextofkin;
    }

    public void setNextofkin(String nextofkin) {
        this.nextofkin = nextofkin;
    }

    public BigDecimal getOldsalary() {
        return oldsalary;
    }

    public void setOldsalary(BigDecimal oldsalary) {
        this.oldsalary = oldsalary;
    }

    public String getPayeregisteredindicator() {
        return payeregisteredindicator;
    }

    public void setPayeregisteredindicator(String payeregisteredindicator) {
        this.payeregisteredindicator = payeregisteredindicator;
    }

    public String getPayrollindicator() {
        return payrollindicator;
    }

    public void setPayrollindicator(String payrollindicator) {
        this.payrollindicator = payrollindicator;
    }

    public String getPensioncompany() {
        return pensioncompany;
    }

    public void setPensioncompany(String pensioncompany) {
        this.pensioncompany = pensioncompany;
    }

    public String getPensionindicator() {
        return pensionindicator;
    }

    public void setPensionindicator(String pensionindicator) {
        this.pensionindicator = pensionindicator;
    }

    public String getPensionnumber() {
        return pensionnumber;
    }

    public void setPensionnumber(String pensionnumber) {
        this.pensionnumber = pensionnumber;
    }

    public Date getPensionstartdate() {
        return pensionstartdate;
    }

    public void setPensionstartdate(Date pensionstartdate) {
        this.pensionstartdate = pensionstartdate;
    }

    public String getPerformancerating() {
        return performancerating;
    }

    public void setPerformancerating(String performancerating) {
        this.performancerating = performancerating;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPolicytype() {
        return policytype;
    }

    public void setPolicytype(String policytype) {
        this.policytype = policytype;
    }

    public String getRelationshipwithnextofkin() {
        return relationshipwithnextofkin;
    }

    public void setRelationshipwithnextofkin(String relationshipwithnextofkin) {
        this.relationshipwithnextofkin = relationshipwithnextofkin;
    }

    public String getSalarybank() {
        return salarybank;
    }

    public void setSalarybank(String salarybank) {
        this.salarybank = salarybank;
    }

    public String getSalarybranch() {
        return salarybranch;
    }

    public void setSalarybranch(String salarybranch) {
        this.salarybranch = salarybranch;
    }

    public String getSalarypaymentfrequency() {
        return salarypaymentfrequency;
    }

    public void setSalarypaymentfrequency(String salarypaymentfrequency) {
        this.salarypaymentfrequency = salarypaymentfrequency;
    }

    public String getSalarypaymentmethod() {
        return salarypaymentmethod;
    }

    public void setSalarypaymentmethod(String salarypaymentmethod) {
        this.salarypaymentmethod = salarypaymentmethod;
    }

    public String getSalarystatus() {
        return salarystatus;
    }

    public void setSalarystatus(String salarystatus) {
        this.salarystatus = salarystatus;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public BigDecimal getStartingsalary() {
        return startingsalary;
    }

    public void setStartingsalary(BigDecimal startingsalary) {
        this.startingsalary = startingsalary;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPayaccountnumber() {
        return payaccountnumber;
    }

    public void setPayaccountnumber(String payaccountnumber) {
        this.payaccountnumber = payaccountnumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTraditionalauthority() {
        return traditionalauthority;
    }

    public void setTraditionalauthority(String traditionalauthority) {
        this.traditionalauthority = traditionalauthority;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public double getAnnualleavedaystaken() {
        return annualleavedaystaken;
    }

    public void setAnnualleavedaystaken(double annualleavedaystaken) {
        this.annualleavedaystaken = annualleavedaystaken;
    }

    public double getAnnualleaveentitlement() {
        return annualleaveentitlement;
    }

    public void setAnnualleaveentitlement(double annualleaveentitlement) {
        this.annualleaveentitlement = annualleaveentitlement;
    }

    public double getCompanycontributions() {
        return companycontributions;
    }

    public void setCompanycontributions(double companycontributions) {
        this.companycontributions = companycontributions;
    }

    public double getCpsleavedaystaken() {
        return cpsleavedaystaken;
    }

    public void setCpsleavedaystaken(double cpsleavedaystaken) {
        this.cpsleavedaystaken = cpsleavedaystaken;
    }

    public double getCpsleaveentitlement() {
        return cpsleaveentitlement;
    }

    public void setCpsleaveentitlement(double cpsleaveentitlement) {
        this.cpsleaveentitlement = cpsleaveentitlement;
    }

    public byte getDependantsundermedicalscheme() {
        return dependantsundermedicalscheme;
    }

    public void setDependantsundermedicalscheme(byte dependantsundermedicalscheme) {
        this.dependantsundermedicalscheme = dependantsundermedicalscheme;
    }

    public double getEmployeecontributions() {
        return employeecontributions;
    }

    public void setEmployeecontributions(double employeecontributions) {
        this.employeecontributions = employeecontributions;
    }

    public double getHourlyrate() {
        return hourlyrate;
    }

    public void setHourlyrate(double hourlyrate) {
        this.hourlyrate = hourlyrate;
    }

    public double getLargestcontsickleavetaken() {
        return largestcontsickleavetaken;
    }

    public void setLargestcontsickleavetaken(double largestcontsickleavetaken) {
        this.largestcontsickleavetaken = largestcontsickleavetaken;
    }

    public String getWorkstation() {
        return workstation;
    }

    public void setWorkstation(String workstation) {
        this.workstation = workstation;
    }

    public byte getNumberofdependants() {
        return numberofdependants;
    }

    public void setNumberofdependants(byte numberofdependants) {
        this.numberofdependants = numberofdependants;
    }

    public Date getPayeregistrationdate() {
        return payeregistrationdate;
    }

    public void setPayeregistrationdate(Date payeregistrationdate) {
        this.payeregistrationdate = payeregistrationdate;
    }

    public double getPrevyearannualleavedaysbalance() {
        return prevyearannualleavedaysbalance;
    }

    public void setPrevyearannualleavedaysbalance(double prevyearannualleavedaysbalance) {
        this.prevyearannualleavedaysbalance = prevyearannualleavedaysbalance;
    }

    public double getPrevyearannualleaveentitlement() {
        return prevyearannualleaveentitlement;
    }

    public void setPrevyearannualleaveentitlement(double prevyearannualleaveentitlement) {
        this.prevyearannualleaveentitlement = prevyearannualleaveentitlement;
    }

    public double getSckleaveentitlement() {
        return sckleaveentitlement;
    }

    public void setSckleaveentitlement(double sckleaveentitlement) {
        this.sckleaveentitlement = sckleaveentitlement;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSickleavedaystaken() {
        return sickleavedaystaken;
    }

    public void setSickleavedaystaken(double sickleavedaystaken) {
        this.sickleavedaystaken = sickleavedaystaken;
    }

    public String getSECT() {
        return SECT;
    }

    public void setSECT(String SECT) {
        this.SECT = SECT;
    }

    public String getTakenleavegrant() {
        return takenleavegrant;
    }

    public void setTakenleavegrant(String takenleavegrant) {
        this.takenleavegrant = takenleavegrant;
    }

    public EstablishedPosition getEstablishedposition() {
        return establishedposition;
    }

    public void setEstablishedposition(EstablishedPosition establishedposition) {
        this.establishedposition = establishedposition;
    }

    public String getSalarynoth() {
        return salarynoth;
    }

    public void setSalarynoth(String salarynoth) {
        this.salarynoth = salarynoth;
    }

    public List<LeaveDetails> getLeaveDetails() {
        return leaveDetails;
    }

    public void setLeaveDetails(List<LeaveDetails> leaveDetails) {
        this.leaveDetails = leaveDetails;
    }
    
    
    
    

    //    @Override
	    public int hashCode() {
	        int hash = 5;
	        hash = 89 * hash + Objects.hashCode(this.id);
	   //     hash = 89 * hash + Objects.hashCode(this.employeenumber);
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
	        final Employee other = (Employee) obj;
	        if (!Objects.equals(this.id, other.id)) {
	            return false;
	        }
	   //     if (!Objects.equals(this.companyid, other.companyid)) {
	   //         return false;
	   //     }
	   //     if (!Objects.equals(this.employeenumber, other.employeenumber)) {
	   //        return false;
	   //     }
	        if (!Objects.equals(this.employmentstatus, other.employmentstatus)) {
	            return false;
	        }
	        return true;
    }
}
