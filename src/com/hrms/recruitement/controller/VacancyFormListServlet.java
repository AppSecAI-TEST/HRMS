package com.hrms.recruitement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.recruitement.bean.VacancyFormBean;
import com.hrms.recruitement.dao.AllRecruitmentListDAO;

public class VacancyFormListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int v_id = Integer.parseInt(request.getParameter("v_id"));
		System.out.println("v_id:"+v_id);
		AllRecruitmentListDAO AllRecruitmentListDAO = new AllRecruitmentListDAO();
		List<VacancyFormBean> listofVacancy = AllRecruitmentListDAO.getListOfVacancy(v_id);
		List<Object[]> listofBenefits = AllRecruitmentListDAO.getListOfBenefits(v_id);
		request.setAttribute("v_id", v_id);
		request.setAttribute("listofVacancy", listofVacancy);
		request.setAttribute("listofBenefits", listofBenefits);
		request.getRequestDispatcher("approveorrejectForm1.jsp").forward(request, response);
	}
}