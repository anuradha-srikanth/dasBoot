package com.boot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	
	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void testShipwreck() {
//		ShipwreckController sc = new ShipwreckController();
		Shipwreck sw = new Shipwreck();
		sw.setId(1l);
		when(shipwreckRepository.getOne(1l)).thenReturn(sw);
		
		Shipwreck wreck = sc.get(1L);
		
		verify(shipwreckRepository).getOne(1L);
		
		assertEquals(1l, wreck.getId().longValue());
//		assertThat(wreck.getId(), is(1l));
	}

}
