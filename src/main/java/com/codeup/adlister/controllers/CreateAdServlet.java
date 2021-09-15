package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description")
                //ADDED CHECKBOXES FOR CATEGORIES ALREADY ADDED TO TABLE
        );
        Long IDofNewAd = DaoFactory.getAdsDao().insert(ad);
        if (request.getParameter("clothing") != null) {
            DaoFactory.getAdsDao().addCategory(IDofNewAd, 2L);
        }
        if (request.getParameter("electronics-media") != null) {
            DaoFactory.getAdsDao().addCategory(IDofNewAd, 1L);
        }
        ;
        if (request.getParameter("vehicles") != null) {
            DaoFactory.getAdsDao().addCategory(IDofNewAd, 3L);
        }
        if (request.getParameter("sporting-goods") != null) {
            DaoFactory.getAdsDao().addCategory(IDofNewAd, 4L);
        }
        if (request.getParameter("pets") != null) {
            DaoFactory.getAdsDao().addCategory(IDofNewAd, 5L);
        }
        response.sendRedirect("/ads");
    }

}