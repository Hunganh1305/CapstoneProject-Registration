package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class createTeam_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<h2>Create your team</h2>\n");
      out.write("<p>You have to have a team before you can match a topic in this semester</p>\n");
      out.write("<hr/>\n");
      out.write("<div class =\"row\">\n");
      out.write("    <div class=\"col\">\n");
      out.write("        <form action=\"#\">\n");
      out.write("            <div class=\"mb-3 mt-3\">\n");
      out.write("                <label for=\"id\" class=\"form-label\">Id:</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"id\" placeholder=\"Enter id\" name=\"id\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"mb-3\">\n");
      out.write("                <label for=\"pwd\" class=\"form-label\">Name:</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"name\" placeholder=\"Enter name\" name=\"name\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"mb-3\">\n");
      out.write("                <label for=\"pwd\" class=\"form-label\">Price</label>\n");
      out.write("                <input type=\"number\" class=\"form-control\" id=\"price\" placeholder=\"Enter price\" name=\"price\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"mb-3\">\n");
      out.write("                <label for=\"pwd\" class=\"form-label\">Expired date:</label>\n");
      out.write("                <input type=\"date\" class=\"form-control\" id=\"expDate\" placeholder=\"Enter expired date\" name=\"expDate\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"mb-3\">\n");
      out.write("                <label for=\"pwd\" class=\"form-label\">Brand id:</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"brandId\" placeholder=\"Enter Brand ID\" name=\"brandID\">\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <button type=\"submit\" class=\"btn btn-primary\"><i class=\"bi bi-box-arrow-down\"></i>Save</button>\n");
      out.write("    <button type=\"submit\" class=\"btn btn-danger\"><i class=\"bi bi-x-circle\"></i>Cancel</button>\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
