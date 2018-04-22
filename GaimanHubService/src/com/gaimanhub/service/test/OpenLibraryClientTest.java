package com.gaimanhub.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gaimanhub.service.client.OpenLibraryClient;
import com.gaimanhub.service.json.openlibrary.OpenLibraryResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:SpringDispatcher-servlet.xml"})
public class OpenLibraryClientTest {
	
	@Autowired
	private OpenLibraryClient testClient;
	
	@Test
	public void testGetAllGaiman() {
		OpenLibraryResponse response = testClient.getAllGaiman();
		assertNotNull(response);
		assertTrue(response.getDocs().size() > 0);
		assertEquals(response.getNumFound(), response.getDocs().size());
	}
	
	@Test
	public void testSearchGaiman() {
		OpenLibraryResponse response = testClient.searchGaiman("S*");
		assertNotNull(response);
		assertTrue(response.getDocs().size() > 0);
		assertEquals(response.getNumFound(), response.getDocs().size());
	}
}
