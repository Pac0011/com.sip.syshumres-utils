package com.sip.syshumres_utils;

import java.io.File;
import java.io.IOException;
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
public final class UtilFile {
		
	private UtilFile() {// Noncompliant - method is empty
	}
	
	public static String saveFile(MultipartFile multiPart, String path) throws IOException {
		//Obtenemos el nombre original del archivo.
		try {
			createDirs(path);
			
			String contentType = multiPart.getContentType();
			if (contentType != null) {
				StringBuilder nameFile = new StringBuilder(RandomString.getRandomStringStream(8))
						.append(".")
						.append(contentType.replace("image/", ""));
				StringBuilder pathFile = new StringBuilder(path).append(nameFile);
				
				// Formamos el nombre del archivo para guardarlo en el disco duro.
				File imageFile = new File(pathFile.toString());
				// Guardamos fisicamente el archivo en HD.
				multiPart.transferTo(imageFile);
				return nameFile.toString();
			} 
		} catch(IOException ioe) { 
	        throw new IOException("Error al guardar archivo ", ioe);
	    }        
		return null;
	}
	
	public static void createDirs(String path) throws IOException {
        Files.createDirectories(Paths.get(path));
    }
	
	public static Resource getFileStream(String pathHD) throws IOException {
		Resource resource = null;
		try {
			//file:/Users/prong/Documents/UploadSysrh/documents/employees/DDDe55LOtVKp/tc5ETopQ.jpeg
			resource = new UrlResource("file:" + pathHD);
			if(!resource.exists()) {
	        	return null;
	        }
		} catch(IOException e) { 
			throw new IOException("Error al recuperar archivo ", e);
		}
		
		return resource;
	}

}
