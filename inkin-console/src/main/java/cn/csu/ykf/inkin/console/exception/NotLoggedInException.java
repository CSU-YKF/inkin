package cn.csu.ykf.inkin.console.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class NotLoggedInException extends RuntimeException {

    private ModelAndView modelAndView;

    public NotLoggedInException(String message) {
        super(message);
    }

    public NotLoggedInException(String message, ModelAndView modelAndView) {
        super(message);
        this.modelAndView = modelAndView;
    }

    public ModelAndView getModelAndView() {
        return modelAndView;
    }
}