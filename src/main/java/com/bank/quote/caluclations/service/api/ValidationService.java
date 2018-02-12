package com.bank.quote.caluclations.service.api;

/**
 * 
 * @author Ahmed Mostafa
 * 
 * @description this class represent the validation service layer 
 *
 */
public interface ValidationService {

    /**
     * @param requestedAmountArg
     * @return
     */
    default boolean isNumeric(String requestedAmountArg) {
        return false;
    }
    
    /**
     * 
     * @param startLoanDateArg
     * @return
     */
    default boolean isDate(String startLoanDateArg) {
        return false;
    }

    
}
