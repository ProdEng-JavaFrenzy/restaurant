package com.javafrenzy.restaurant;

import com.javafrenzy.restaurant.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class RestaurantApplicationTests {

	@MockBean
	ReservationRepository reservationRepository;

	@Test
	void contextLoads() {
	}

}
