package com.bank.quote.caluclations.model;

import java.math.BigDecimal;
import java.util.Date;

public class AnnuityPayment {
    
    private BigDecimal borrowerPaymentAmount;
    private Date annuityPaymentDate;
    private BigDecimal initailOutstandingPrincipal ;
    private BigDecimal interest ;
    private BigDecimal principal ;
    private BigDecimal remianingOutstandingPrincipal ;
   
    
    public AnnuityPayment(BigDecimal borrowerPaymentAmount, Date annuityPaymentDate, 
                          BigDecimal initailOutstandingPrincipal, BigDecimal interest, 
                          BigDecimal principal, BigDecimal remianingOutstandingPrincipal) {
        
        this.borrowerPaymentAmount = borrowerPaymentAmount ;
        this.annuityPaymentDate = annuityPaymentDate ;
        this.initailOutstandingPrincipal = initailOutstandingPrincipal ;
        this.interest = interest ;
        this.principal = principal ;
        this.remianingOutstandingPrincipal = remianingOutstandingPrincipal ;
    }
    
    public BigDecimal getBorrowerPaymentAmount() {
        return borrowerPaymentAmount;
    }
    
    public void setBorrowerPaymentAmount(BigDecimal borrowerPaymentAmount) {
        this.borrowerPaymentAmount = borrowerPaymentAmount;
    }
    
    public Date getAnnuityPaymentDate() {
        return annuityPaymentDate;
    }
    
    public void setAnnuityPaymentDate(Date annuityPaymentDate) {
        this.annuityPaymentDate = annuityPaymentDate;
    }
    
    public BigDecimal getInitailOutstandingPrincipal() {
        return initailOutstandingPrincipal;
    }
    
    public void setInitailOutstandingPrincipal(
            BigDecimal initailOutstandingPrincipal) {
        this.initailOutstandingPrincipal = initailOutstandingPrincipal;
    }
    
    public BigDecimal getInterest() {
        return interest;
    }
    
    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }
    
    public BigDecimal getPrincipal() {
        return principal;
    }
    
    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }
    
    public BigDecimal getRemianingOutstandingPrincipal() {
        return remianingOutstandingPrincipal;
    }
    
    public void setRemianingOutstandingPrincipal(
            BigDecimal remianingOutstandingPrincipal) {
        this.remianingOutstandingPrincipal = remianingOutstandingPrincipal;
    }

    @Override
    public String toString() {
        return "AnnuityPayment [borrowerPaymentAmount=" + borrowerPaymentAmount
                + ", annuityPaymentDate=" + annuityPaymentDate
                + ", initailOutstandingPrincipal=" + initailOutstandingPrincipal
                + ", interest=" + interest + ", principal=" + principal
                + ", remianingOutstandingPrincipal="
                + remianingOutstandingPrincipal + "]";
    }
    

}
