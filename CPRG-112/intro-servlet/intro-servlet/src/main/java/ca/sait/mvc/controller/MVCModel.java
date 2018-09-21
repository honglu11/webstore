package ca.sait.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MVCModel {
    public String getErrorMessage();
    public void handle(HttpServletRequest request, HttpServletResponse response);

}
