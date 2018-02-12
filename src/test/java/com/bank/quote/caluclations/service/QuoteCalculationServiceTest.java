package com.bank.quote.caluclations.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bank.quote.caluclations.model.AnnuityPayment;
import com.bank.quote.caluclations.model.LoanRequest;
import com.bank.quote.caluclations.service.api.CalculationService;
import com.bank.quote.caluclations.service.impl.QuoteCalculationService;

public class QuoteCalculationServiceTest {

    private CalculationService calculationService;
    private List<AnnuityPayment> annuityPaymentList ;

    @Before
    public void setUp() throws Exception {
        BigDecimal requestAmount = new BigDecimal("5000") ;
        Double nominateRate = Double.parseDouble("5.00") ;
        Integer duration = Integer.valueOf(24) ;
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date startLoanDate = formatter.parse("01/01/2018");
        
        LoanRequest loanRequest = new LoanRequest(requestAmount, nominateRate, duration, startLoanDate) ;
        
        calculationService = new QuoteCalculationService();
        
        // Generate annuityPaymentList
        calculationService.getAnnuityPayment(loanRequest);
            
        //  Get annuityPaymentList
        annuityPaymentList = calculationService.getAnnuityPaymentList() ;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getFirstAnnuityPayment() throws Exception {
        // Assert
        assertEquals("First Annuity Payment should be 360.00", BigDecimal.valueOf(360.00).setScale(2, RoundingMode.CEILING), annuityPaymentList.get(0).getBorrowerPaymentAmount());
    }

    @Test
    public void getLastAnnuityPayment() throws Exception {
        // Assert
        assertEquals("Last Annuity Payment should be 110.00", BigDecimal.valueOf(110.00).setScale(2, RoundingMode.CEILING), annuityPaymentList.get(annuityPaymentList.size() - 1).getBorrowerPaymentAmount());
    }

}