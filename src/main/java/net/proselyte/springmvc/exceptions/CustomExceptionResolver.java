package net.proselyte.springmvc.exceptions;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Администратор on 13.09.16.
 */
public class CustomExceptionResolver extends SimpleMappingExceptionResolver {

    @Override
    protected ModelAndView getModelAndView(String viewName, Exception ex) {
        return getCustomModelAndView(viewName, ex, null);
    }

    @Override
    protected ModelAndView getModelAndView(String viewName, Exception ex,
                                           HttpServletRequest request) {
        return getCustomModelAndView(viewName, ex, request);
    }

    private ModelAndView getCustomModelAndView(String viewName, Exception ex,
                                               HttpServletRequest request){
        ModelAndView mv = super.getModelAndView(viewName, ex);

        mv.addObject("message", "view: " + viewName
                + "exceptionMessage: " + ex.getMessage()
             );

        return mv;
    }
}