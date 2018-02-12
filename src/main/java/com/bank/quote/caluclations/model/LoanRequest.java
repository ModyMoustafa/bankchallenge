package com.bank.quote.caluclations.model;

import java.math.BigDecimal;
import java.util.Date;

public class LoanRequest {
    
    private BigDecimal requestedAmount;
    private Double nominateRate ;
    private int duration ;
    private Date  startLoanDate ;
    
    public LoanRequest(BigDecimal requestedAmount, Double nominateRate, int duration, Date  startLoanDate) {
        this.requestedAmount = requestedAmount;
        this.nominateRate = nominateRate ;
        this.duration = duration ;
        this.startLoanDate = startLoanDate ;
    }
    
    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }
    
    public void setRequestedAmount(BigDecimal requestedAmount) {
        this.requestedAmount = requestedAmount;
    }
    
    public Double getNominateRate() {
        return nominateRate;
    }
    
    public void setNominateRate(Double nominateRate) {
        this.nominateRate = nominateRate;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public Date getStartLoanDate() {
        return startLoanDate;
    }
    
    public void setStartLoanDate(Date startLoanDate) {
        this.startLoanDate = startLoanDate;
    }
    
    
    @Override
    public String toString() {
        return "LoanRequest [requestedAmount=" + requestedAmount
                + ", nominateRate=" + nominateRate + ", duration=" + duration
                + ", startLoanDate=" + startLoanDate + "]";
    }
    
    

}
