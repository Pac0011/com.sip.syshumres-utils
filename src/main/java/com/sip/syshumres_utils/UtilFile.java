package com.sip.syshumres_utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

/**
 * Implementacion de guardado de archivos (documentos, imagenes etc)
 * 
 * @author Prong
 * @version 2.0
 */
public class UtilFile {
	
	public static String saveFile(MultipartFile multiPart, String path) {
		//Obtenemos el nombre original del archivo.
		try {
			createDirs(path);
		} catch (IOException e1) {
			System.out.println("Error " + e1.getMessage());
			return null;
		}
		StringBuilder nameFile = new StringBuilder(RandomString.getRandomStringStream(8))
				.append(".")
				.append(multiPart.getContentType().replace("image/", ""));
		StringBuilder pathFile = new StringBuilder(path)
				.append(nameFile);
		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro.
			File imageFile = new File(pathFile.toString());
			System.out.println("Archivo: " + imageFile.getAbsolutePath());
			// Guardamos fisicamente el archivo en HD.
			multiPart.transferTo(imageFile);
			return nameFile.toString();
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}
	
	public static void createDirs(String path) throws IOException {
        Files.createDirectories(Paths.get(path));
    }
	
	public static Resource getFileStream(String pathHD) {
		Resource resource = null;
		try {
			//file:/Users/prong/Documents/UploadSysrh/documents/employees/DDDe55LOtVKp/tc5ETopQ.jpeg
			resource = new UrlResource("file:" + pathHD);
			if(!resource.exists()) {
            	return null;
            }
		} catch (MalformedURLException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
		
		return resource;
	}

}
