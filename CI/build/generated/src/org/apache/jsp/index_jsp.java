package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_submit_value_styleClass_property;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_link_styleClass_page;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_html_form_styleClass_action;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_html_submit_value_styleClass_property = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_link_styleClass_page = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_html_form_styleClass_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_html_submit_value_styleClass_property.release();
    _jspx_tagPool_html_link_styleClass_page.release();
    _jspx_tagPool_html_form_styleClass_action.release();
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
      out.write("        <title>Index</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"js/jquery-3.3.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/popper.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/bootstrap.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"http://codeseven.github.com/toastr/toastr.js\"></script>\n");
      out.write("        <link href=\"http://codeseven.github.com/toastr/toastr.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"http://codeseven.github.com/toastr/toastr-responsive.css\" rel=\"stylesheet\"/>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-12\">\n");
      out.write("                    <div>\n");
      out.write("                        <nav class=\"navbar navbar-expand-lg navbar-light\" style=\"background-color: #0000FF;\">\n");
      out.write("                            <a class=\"navbar-brand\" href=\"accesoMantenimiento.do?action=index\" style = 'color: white'>Inicio</a>\n");
      out.write("                            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                            </button>\n");
      out.write("\n");
      out.write("                            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\" >\n");
      out.write("                                <ul class=\"navbar-nav mr-auto\" >\n");
      out.write("                                </ul>\n");
      out.write("                                <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                                    <div class=\"btn-group dropleft\">\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-outline-light dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                            Iniciar Secion\n");
      out.write("                                        </button>\n");
      out.write("                                        <div class=\"dropdown-menu\">\n");
      out.write("                                            ");
      if (_jspx_meth_html_form_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                                            ");
      if (_jspx_meth_html_link_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </nav>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-4\"> 1</div>\n");
      out.write("                        <div class=\"col-4\">2\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-4\"> 3</div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-1\"></div>\n");
      out.write("                    <div class=\"col-10\">\n");
      out.write("                        <h1>Index</h1>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-1\"></div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <p id=\"hola\" hidden=\"hidden\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensaje}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("        </div>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("            if ($(\"#hola\").text() != \"\") {\n");
      out.write("                window.onload = function () {\n");
      out.write("                    toastrs();\n");
      out.write("                };\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            toastr.options = {\n");
      out.write("                \"debug\": false,\n");
      out.write("                \"positionClass\": \"toast-bottom-right\",\n");
      out.write("                \"onclick\": null,\n");
      out.write("                \"fadeIn\": 300,\n");
      out.write("                \"fadeOut\": 100,\n");
      out.write("                \"timeOut\": 5000,\n");
      out.write("                \"extendedTimeOut\": 1000\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            var showToastrs = false;\n");
      out.write("\n");
      out.write("            function toastrs() {\n");
      out.write("\n");
      out.write("                if (!showToastrs) {\n");
      out.write("                    toastr.error($(\"#hola\").text(), 'Error');\n");
      out.write("\n");
      out.write("\n");
      out.write("                } else {\n");
      out.write("                    toastr.error('no se puede!\\'t.', 'Otro error crítico');\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_html_form_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:form
    org.apache.struts.taglib.html.FormTag _jspx_th_html_form_0 = (org.apache.struts.taglib.html.FormTag) _jspx_tagPool_html_form_styleClass_action.get(org.apache.struts.taglib.html.FormTag.class);
    _jspx_th_html_form_0.setPageContext(_jspx_page_context);
    _jspx_th_html_form_0.setParent(null);
    _jspx_th_html_form_0.setAction("/accesoMantenimiento");
    _jspx_th_html_form_0.setStyleClass("px-4 py-3");
    int _jspx_eval_html_form_0 = _jspx_th_html_form_0.doStartTag();
    if (_jspx_eval_html_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\n");
        out.write("                                                <div class=\"form-group\">\n");
        out.write("                                                    <label for=\"usuario\">Usuario :</label>\n");
        out.write("                                                    <input type=\"text\" class=\"form-control\" name=\"usuario\" id=\"usuario\" placeholder=\"escriba su usuario\" required=\"\">\n");
        out.write("                                                </div>\n");
        out.write("                                                <div class=\"form-group\">\n");
        out.write("                                                    <label for=\"contrasena\">Contraseña :</label>\n");
        out.write("                                                    <input type=\"password\" class=\"form-control\" name=\"contrasena\" id=\"contrasena\" placeholder=\"escriba su contraseña\" required=\"\">\n");
        out.write("                                                </div>\n");
        out.write("                                                <div class=\"form-check\">\n");
        out.write("                                                    <input type=\"checkbox\" class=\"form-check-input\" id=\"dropdownCheck\">\n");
        out.write("                                                    <label class=\"form-check-label\" for=\"dropdownCheck\">\n");
        out.write("                                                        Recordarme\n");
        out.write("                                                    </label>\n");
        out.write("                                                </div>\n");
        out.write("                                                ");
        if (_jspx_meth_html_submit_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_html_form_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\n");
        out.write("                                            ");
        int evalDoAfterBody = _jspx_th_html_form_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_html_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_html_form_styleClass_action.reuse(_jspx_th_html_form_0);
      return true;
    }
    _jspx_tagPool_html_form_styleClass_action.reuse(_jspx_th_html_form_0);
    return false;
  }

  private boolean _jspx_meth_html_submit_0(javax.servlet.jsp.tagext.JspTag _jspx_th_html_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:submit
    org.apache.struts.taglib.html.SubmitTag _jspx_th_html_submit_0 = (org.apache.struts.taglib.html.SubmitTag) _jspx_tagPool_html_submit_value_styleClass_property.get(org.apache.struts.taglib.html.SubmitTag.class);
    _jspx_th_html_submit_0.setPageContext(_jspx_page_context);
    _jspx_th_html_submit_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_html_form_0);
    _jspx_th_html_submit_0.setStyleClass("btn btn-primary");
    _jspx_th_html_submit_0.setProperty("action");
    _jspx_th_html_submit_0.setValue("Login");
    int _jspx_eval_html_submit_0 = _jspx_th_html_submit_0.doStartTag();
    if (_jspx_eval_html_submit_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_submit_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_submit_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_submit_0.doInitBody();
      }
      do {
        out.write("Iniciar Sesión");
        int evalDoAfterBody = _jspx_th_html_submit_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_submit_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_html_submit_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_html_submit_value_styleClass_property.reuse(_jspx_th_html_submit_0);
      return true;
    }
    _jspx_tagPool_html_submit_value_styleClass_property.reuse(_jspx_th_html_submit_0);
    return false;
  }

  private boolean _jspx_meth_html_link_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  html:link
    org.apache.struts.taglib.html.LinkTag _jspx_th_html_link_0 = (org.apache.struts.taglib.html.LinkTag) _jspx_tagPool_html_link_styleClass_page.get(org.apache.struts.taglib.html.LinkTag.class);
    _jspx_th_html_link_0.setPageContext(_jspx_page_context);
    _jspx_th_html_link_0.setParent(null);
    _jspx_th_html_link_0.setStyleClass("dropdown-item");
    _jspx_th_html_link_0.setPage("/jsp/acceso/ayuda1.jsp");
    int _jspx_eval_html_link_0 = _jspx_th_html_link_0.doStartTag();
    if (_jspx_eval_html_link_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_html_link_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_html_link_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_html_link_0.doInitBody();
      }
      do {
        out.write("¿Olvidaste tu contraseña?");
        int evalDoAfterBody = _jspx_th_html_link_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_html_link_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_html_link_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_html_link_styleClass_page.reuse(_jspx_th_html_link_0);
      return true;
    }
    _jspx_tagPool_html_link_styleClass_page.reuse(_jspx_th_html_link_0);
    return false;
  }
}
