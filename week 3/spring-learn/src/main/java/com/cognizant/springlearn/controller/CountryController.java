package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;

@RestController
public class CountryController {

	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	private CountryService countryService;

	@RequestMapping("/country")
	public Country getCountryIndia() {
		logger.info("START: getCountryIndia()");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country india;

		try {
			india = context.getBean("india", Country.class);
		} finally {
			((ClassPathXmlApplicationContext) context).close();
		}

		logger.info("END: getCountryIndia(), returning {}", india);
		return india;
	}

	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) {
		logger.info("START: getCountry({})", code);

		Country country = countryService.getCountry(code);

		logger.info("END: getCountry(), returning {}", country);
		return country;
	}

}
