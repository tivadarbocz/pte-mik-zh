package hu.mik.zh.config;

import hu.mik.zh.exception.NoResourceException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global Exception handler over endpoints
 * <p>
 * If an exception occurs during a rest call, it will translate to a specific HTTP RESPONSE
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { NoResourceException.class })
	protected String handleNoResourceException(RuntimeException ex,
			WebRequest request, Model model) {
		model.addAttribute("msg", ex.toString());

		return "error";
	}
}
