package com.madurobank.customerstatementprocessor.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.madurobank.customerstatementprocessor.common.Utility;
import com.madurobank.customerstatementprocessor.service.StatementProcessService;

@RestController
public class StatementProcessController {

	private static final Logger logger = LoggerFactory.getLogger(StatementProcessController.class);

    @Autowired
    private StatementProcessService statementprocessservice;
	
	@PostMapping("/validateFile")
    public void uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {		
		
       statementprocessservice.processStatement(Utility.convert(multipartFile));
         
	}
	
}
