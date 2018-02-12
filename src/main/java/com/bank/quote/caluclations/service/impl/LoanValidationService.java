package com.bank.quote.caluclations.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.bank.quote.caluclations.Exceptions.InvalidRequestAmountException;
import com.bank.quote.caluclations.service.api.ValidationService;

/**
 * 
 * @author Ahmed Mostafa
 * 
 * @Description This class responsible for validate loan
 *
 */
public class LoanValidationService implements ValidationService {

    /**
     * @param requestedAmountArg
     * @return
     * @throws InvalidRequestAmountException
     */
    @Override
    public boolean isNumeric(String requestedAmountArg) {
        return requestedAmountArg != null && requestedAmountArg.matches("[-+]?\\d*\\.?\\d+");
    }

    
    /**
     * @param startLoanDateArg
     * @return
     * @throws ParseException
     */
    @Override
    public boolean isDate(String startLoanDateArg) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
              formatter.parse(startLoanDateArg);
              return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
}
