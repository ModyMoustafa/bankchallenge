package com.bank.quote.caluclations.service.api;

import java.util.List;

import com.bank.quote.caluclations.model.AnnuityPayment;
import com.bank.quote.caluclations.model.LoanRequest;
public interface CalculationService {
    
    /**
     * 
     * @param loanRequest
     */
    void getAnnuityPayment(LoanRequest loanRequest) ;
    
    /**
     * 
     * @return get all Annuity Payment
     */
    List<AnnuityPayment> getAnnuityPaymentList();
}
