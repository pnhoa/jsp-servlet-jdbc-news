package com.nhuhoa.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhuhoa.model.NewModel;
import com.nhuhoa.service.INewService;
import com.nhuhoa.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet {
   
	private static final long serialVersionUID = 3285757388555132470L;
	
	@Inject
	private INewService newService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		// nhan kieu tra ve co dau ( tieng viet)
		request.setCharacterEncoding("UTF-8");
		// server tra ve cho client duoi dang file json 
		response.setContentType("application/json");
		// request.getReader() doc du lieu tra ve duoi dang BufferedReader
		// ham of convert dl sang String, sau do chuyen sang Object Java 
		NewModel newModel = HttpUtil.of(request.getReader()).toModel(NewModel.class);
		newModel = newService.save(newModel);
		mapper.writeValue(response.getOutputStream(), newModel);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("application/json");
		NewModel updateNew = HttpUtil.of(request.getReader()).toModel(NewModel.class);
		updateNew = newService.update(updateNew);
		mapper.writeValue(response.getOutputStream(), updateNew);

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("application/json");
		NewModel newModel = HttpUtil.of(request.getReader()).toModel(NewModel.class);
		newService.delete(newModel.getIds());
		mapper.writeValue(response.getOutputStream(), "{} ");

	}
}
