package jp.ac.nii.prl.mape.redundancy.controller;

import org.springframework.web.client.RestClientException;

public class RedundancyViewNotFoundException extends RestClientException {

	private static final long serialVersionUID = -1271540170754527250L;

	public RedundancyViewNotFoundException(String msg) {
		super(msg);
	}
	
	public RedundancyViewNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
