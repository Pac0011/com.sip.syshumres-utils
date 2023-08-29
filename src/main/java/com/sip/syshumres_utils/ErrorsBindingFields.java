package com.sip.syshumres_utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

/**
 * Valida los campos en el request 
 * 
 * @author Prong
 * @version 2.0
 */
public class ErrorsBindingFields {
	
	public static  ResponseEntity<?> validate(BindingResult result) {
		Map<String, Object> errors = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			String field = err.getField();
			//Se coloca \\. para que no lo interprete como un regrex
			//field = field.replaceAll("\\.","_");
			//Valid number the class inner
			//Recorta el objeto hasta 1 nivel y replaza . por _
			if (field.chars().filter(ch -> ch == '.').count() > 0) {
				field = splitString(field);
			}
			errors.put(field, "El campo " + err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errors);
	}
	
	public static String splitString(String s) {
		String[] arr = s.split("\\.");
		return new StringBuilder(Optional.ofNullable(arr[(arr.length-2)]).orElse(""))
				.append("_")
				.append(Optional.ofNullable(arr[(arr.length-1)]).orElse("")).toString();
	}

}
