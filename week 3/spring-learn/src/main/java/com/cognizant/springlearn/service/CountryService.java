package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.model.Country;

@Service
public class CountryService {

	private static final Logger logger = LoggerFactory.getLogger(CountryService.class);

	@SuppressWarnings("unchecked")
	public Country getCountry(String code) {
		logger.info("START: CountryService.getCountry({})", code);

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country result;

		try {
			List<Country> countryList = context.getBean("countryList", List.class);

			// Lambda-based case-insensitive match, in place of a manual for-loop
			result = countryList.stream()
					.filter(country -> country.getCode().equalsIgnoreCase(code))
					.findFirst()
					.orElse(null);
		} finally {
			((ClassPathXmlApplicationContext) context).close();
		}

		logger.info("END: CountryService.getCountry(), returning {}", result);
		return result;
	}

}
