package com.bank.quote.caluclations.service.impl;

import static com.bank.quote.caluclations.constants.QuoteConstant.DAYs_IN_MONTH;
import static com.bank.quote.caluclations.constants.QuoteConstant.DAYs_IN_YEAR;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bank.quote.caluclations.model.AnnuityPayment;
import com.bank.quote.caluclations.model.LoanRequest;
import com.bank.quote.caluclations.service.api.CalculationService;

/**
 * 
 * @author Ahmed Mostafa
 * 
 * @Description this class will responsible for calculate loan according to available offers
 *
 */
public class QuoteCalculationService implements CalculationService {
    
    List<AnnuityPayment> annuityPaymentList = new ArrayList<>() ;

    /*
     * (non-Javadoc)
     * @see com.bank.quote.caluclations.service.api.CalculationService#getAnnuityPayment(com.bank.quote.caluclations.model.LoanRequest)
     */
    @Override
    public void getAnnuityPayment(LoanRequest loanRequest) {
        
        MathContext mc = new MathContext(2, RoundingMode.HALF_DOWN);
        
        Double getNominateRatePrecentage = loanRequest.getNominateRate() / 100 ;
        
        // get calculation from http://financeformulas.net/Annuity_Payment_Formula.html#calcHeader
        BigDecimal annuity = (loanRequest.getRequestedAmount().multiply(BigDecimal.valueOf(getNominateRatePrecentage)).divide(BigDecimal.valueOf((1 - Math.pow(1 + getNominateRatePrecentage, -loanRequest.getDuration()))), mc)).setScale(2, RoundingMode.UNNECESSARY);
        
        // get calculation from assignment PDF
        BigDecimal interest = (BigDecimal.valueOf(loanRequest.getNominateRate()).multiply(BigDecimal.valueOf(DAYs_IN_MONTH)).multiply(loanRequest.getRequestedAmount()).divide(BigDecimal.valueOf(DAYs_IN_YEAR), mc).divide(BigDecimal.valueOf(100))).setScale(2, RoundingMode.UNNECESSARY);
        
        // get calculation from assignment PDF
        BigDecimal principal = annuity.subtract(interest).setScale(2, RoundingMode.UNNECESSARY) ;
        
        BigDecimal remianingOutstandingPrincipal = loanRequest.getRequestedAmount().subtract(principal) ;
        
        AnnuityPayment annuityPayment = new AnnuityPayment(annuity, loanRequest.getStartLoanDate(), loanRequest.getRequestedAmount(), interest, principal, remianingOutstandingPrincipal) ;
        
        this.annuityPaymentList.add(annuityPayment) ;
        
        // Apply Recursion
        if (loanRequest.getDuration() > 1) {
            int newDuration =  loanRequest.getDuration() - 1  ;
            LocalDate date = loanRequest.getStartLoanDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate futureLocalRequestedDate = date.plusMonths(1);
            Date futureRequestedDate = Date.from(futureLocalRequestedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            loanRequest = new LoanRequest(remianingOutstandingPrincipal, loanRequest.getNominateRate(), newDuration, futureRequestedDate) ;
            
            getAnnuityPayment(loanRequest);
        }
    }

    
    @Override
    public List<AnnuityPayment> getAnnuityPaymentList() {
        return annuityPaymentList;
    }

    public void setAnnuityPaymentList(List<AnnuityPayment> annuityPaymentList) {
        this.annuityPaymentList = annuityPaymentList;
    }
}
