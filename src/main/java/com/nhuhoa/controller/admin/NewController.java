package com.nhuhoa.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhuhoa.constant.SystemConstant;
import com.nhuhoa.model.NewModel;
import com.nhuhoa.service.INewService;
import com.nhuhoa.utils.FormUtil;

@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet {

	private static final long serialVersionUID = 8102180013404296329L;
	
	@Inject
	private INewService newService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewModel newModel = FormUtil.toModel(NewModel.class, request);
		Integer offset = (newModel.getPage() - 1) * newModel.getMaxPageItem();
		newModel.setListResult(newService.findAll(offset, newModel.getMaxPageItem()));
		newModel.setTotalItem(newService.getTotalItem());
		newModel.setTotalPage((int) Math.ceil((double) newModel.getTotalItem() / newModel.getMaxPageItem()));
		request.setAttribute(SystemConstant.MODEL,newModel);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/new/list.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
