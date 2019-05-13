package keyon.tang.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: tangkeyon@gmail.com
 * @Date: 2019/4/21 21:18
 * @Version 1.0
 */
public class ExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
       CustomException customException=null;
        if(e instanceof CustomException){
            customException=(CustomException)e;
        }else{
            customException=new CustomException(e.getMessage());
        }
        String message = customException.getMessage();

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("error",message);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
