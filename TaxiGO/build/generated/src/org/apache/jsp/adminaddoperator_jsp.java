package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminaddoperator_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Add operator</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <b>You can add a new operator here:</b>\n");
      out.write("        <form method=\"POST\" action=\"AdminServlet\">\n");
      out.write("            Company name:\n");
      out.write("            <input type=\"text\" name=\"number1\"><br>\n");
      out.write("            Base rate:\n");
      out.write("            <input type=\"number\" name=\"number2\"><br>\n");
      out.write("            Price per km: \n");
      out.write("            <input type=\"number\" name=\"number3\"><br>\n");
      out.write("            Weekend fee: \n");
      out.write("            <input type=\"number\" name=\"number4\"><br>\n");
      out.write("            Rating: \n");
      out.write("            <input type=\"number\" name=\"number5\"><br>\n");
      out.write("            Email:\n");
      out.write("            <input type=\"text\" name=\"number6\"><br>\n");
      out.write("            Phone:\n");
      out.write("            <input type=\"text\" name=\"number7\"><br>\n");
      out.write("            Password:\n");
      out.write("            <input type=\"password\" name=\"number8\"><br>\n");
      out.write("            \n");
      out.write("            <input type=\"submit\" value=\"Update\" name=\"function\" />\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
