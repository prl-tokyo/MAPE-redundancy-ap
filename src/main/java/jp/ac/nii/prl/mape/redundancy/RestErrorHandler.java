package jp.ac.nii.prl.mape.redundancy;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import jp.ac.nii.prl.mape.redundancy.controller.RedundancyViewNotFoundException;

@ControllerAdvice
public class RestErrorHandler {
	
	public RestErrorHandler() {}
	
	@ExceptionHandler(RedundancyViewNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void handleDeploymentNotFoundException(RedundancyViewNotFoundException ex) {}

}
