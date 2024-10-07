package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.view.View;

public interface Controller {
	public View process(HttpServletRequest req, HttpServletResponse resp);
}
