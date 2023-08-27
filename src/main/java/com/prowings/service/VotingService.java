package com.prowings.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.prowings.model.Person;

@Service
public class VotingService {

	@Autowired
	RestTemplate restTemplate;

	public ResponseEntity<String> doVoting() {
		Person person = new Person(50, "Salaman", 50, "India");

		ResponseEntity<String> result = new ResponseEntity<String>(HttpStatus.CREATED);
//		http://localhost:8080/rest-api-globalException-demo/vote

//			public <T> ResponseEntity<T> postForEntity(URI url, @Nullable Object request, Class<T> responseType)
//		throws RestClientException {


		result = restTemplate.postForEntity("http://localhost:8080/rest-api-globalException-demo/vote", person,
				String.class);

		return result;
	}
}
