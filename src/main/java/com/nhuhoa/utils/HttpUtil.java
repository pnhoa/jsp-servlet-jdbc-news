package com.nhuhoa.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	private String value;
	public HttpUtil(String value) {
		this.value = value;
	}
	public <T> T toModel(Class<T> tClass) {
		try {
			// tu chuoi String duoi dang json chuyen sang Object bang thu vien ObjectMapper
			return new ObjectMapper().readValue(value, tClass);
		} catch (Exception e) {
		
			System.out.println(e.getMessage());
		}
		return null;
	}
	public static HttpUtil of(BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
			// doc tung dong luu vao StringBuilder
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// gan gia tri cho value
		return new HttpUtil(sb.toString());
	}
}
