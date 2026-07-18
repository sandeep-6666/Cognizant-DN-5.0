package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loan.model.Loan;

@RestController
public class LoanController {

	// GET /loans/{number}
	// Dummy response, no backend connectivity, as per spec:
	// { number: "H00987987972342", type: "car", loan: 400000, emi: 3258, tenure: 18 }
	@GetMapping("/loans/{number}")
	public Loan getLoan(@PathVariable String number) {
		return new Loan(number, "car", 400000, 3258, 18);
	}

}
