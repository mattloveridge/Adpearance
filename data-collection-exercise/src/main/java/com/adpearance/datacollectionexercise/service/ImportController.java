package com.adpearance.datacollectionexercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("import")
public class ImportController {
	
	@Autowired
	ImportService importService;

	private static final String CLIENT_WEBSITE_URL = "http://exercise.fourbot.io/index";
	
	@PostMapping(value="/execute")
    public ResponseEntity<?> execute() throws Exception {
		
		// TODO wire up to ImportService
		importService.execute(CLIENT_WEBSITE_URL);
		
		// TODO update to account for success and failure status
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
