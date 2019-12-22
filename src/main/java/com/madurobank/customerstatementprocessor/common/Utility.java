package com.madurobank.customerstatementprocessor.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public interface Utility {

	static final Logger logger = LoggerFactory.getLogger(Utility.class);

	public static File convert(MultipartFile file) {
		File convFile = new File(file.getOriginalFilename());

		try {
			convFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convFile);

			fos.write(file.getBytes());
			fos.close();
		} catch (IOException ioException) {
			logger.error("ERROR: Unable to convert MultipartFile to file for " + file.getName() + " due to exception "
					+ ioException);
		}

		return convFile;
	}

}
