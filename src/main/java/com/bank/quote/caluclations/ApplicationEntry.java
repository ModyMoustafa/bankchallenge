package com.bank.quote.caluclations;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.bank.quote.caluclations.Exceptions.InvalidRequestAmountException;
import com.bank.quote.caluclations.model.AnnuityPayment;
import com.bank.quote.caluclations.model.LoanRequest;
import com.bank.quote.caluclations.service.api.CalculationService;
import com.bank.quote.caluclations.service.api.ValidationService;
import com.bank.quote.caluclations.service.impl.LoanValidationService;
import com.bank.quote.caluclations.service.impl.QuoteCalculationService;
/**
 * 
 * @author Ahmed Mostafa
 *
 *@description this is Entry point for the application 
 */
public class ApplicationEntry {

    // Injected the following service to be used during execution
    private static ValidationService s_validationService = new LoanValidationService();
    private static CalculationService s_calculationService;

    /**
     * @param args supplied file path and loan amount
     * @throws IOException and InvalidRequestAmountException
     */
    public static void main(String[] args) throws IOException, InvalidRequestAmountException {

        // Check the parameter that provide to application, if invalid system will be exit
        if (args.length < 4 || !s_validationService.isNumeric(args[0])
            || !s_validationService.isNumeric(args[1])
            || !s_validationService.isNumeric(args[2])
            || !s_validationService.isDate(args[3])) {
            System.err.println("Invalid/Incomplete parameters supplied");
            System.err.println("Please provide [requestedAmount] [nominateRate] [duration] [startLoanDate]");
            System.err.println("Please provide [startLoanDate] with dd/MM/YYYY");
            System.exit(1);
        }

        try {
            
            // Generate all requested data from args
            BigDecimal requestAmount = new BigDecimal(args[0]) ;
            Double nominateRate = Double.parseDouble(args[1]) ;
            Integer duration = Integer.valueOf(args[2]) ;
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date startLoanDate = formatter.parse(args[3]);
            
            // Initiate first loan request
            LoanRequest loanRequest = new LoanRequest(requestAmount, nominateRate, duration, startLoanDate) ;
            
            

            // Initialize the calculation service by Passing the load and offers
            s_calculationService = new QuoteCalculationService();
            
            // Generate annuityPaymentList
            s_calculationService.getAnnuityPayment(loanRequest);
                
            //  Get annuityPaymentList
            List<AnnuityPayment> annuityPaymentList = s_calculationService.getAnnuityPaymentList() ;
            
            // Display annuityPaymentList
            for (AnnuityPayment annuityPayment : annuityPaymentList) {
                System.out.println(annuityPayment.toString());
            }
            

        } catch (InvalidRequestAmountException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        System.exit(0);
    }
    
    
    
}
