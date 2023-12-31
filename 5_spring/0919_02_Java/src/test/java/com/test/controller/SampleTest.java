package com.test.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.config.RootConfig;
import com.test.sample.Hotel;
import com.test.sample.Restaurant;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class SampleTest {
	@Autowired
	private Restaurant restaurant;
	@Autowired
	private Hotel hotel;
	@Test
	public void test() {
		assertNotNull(restaurant);
		log.info(restaurant);
		log.info("====================");
		log.info(restaurant.getChef());
		
		log.info("========================================");
		assertNotNull(hotel);
		log.info(hotel);
		log.info("====================");
		log.info(hotel.getChef());
	}
}
