package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import views.View;

public interface Controller{
	View process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
