package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
//@WebIntegrationTest
public class ShipwreckControllerWebIntegrationTest {
	@Test
	public void testListAll() throws IOException {
		//programmatically call the rest API
		TestRestTemplate restTemplate = new TestRestTemplate();
		String url = "http://localhost:8080/api/v1/shipwrecks";
		
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
				
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode responseJson = objectMapper.readTree(response.getBody());
		
		assertThat (responseJson.isMissingNode(), is(false));
		assertThat(responseJson.toString(), equalTo("[]"));
	}

}
