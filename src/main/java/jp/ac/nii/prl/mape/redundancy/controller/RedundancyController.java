package jp.ac.nii.prl.mape.redundancy.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jp.ac.nii.prl.mape.redundancy.model.Instance;
import jp.ac.nii.prl.mape.redundancy.model.RedundancyView;
import jp.ac.nii.prl.mape.redundancy.service.InstanceService;
import jp.ac.nii.prl.mape.redundancy.service.RedundancyViewService;

@RestController
@Component
@RequestMapping("/redundancy")
public class RedundancyController {
	
	@Autowired
	private RedundancyViewService redundancyViewService;
	
	@Autowired
	private InstanceService instanceService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> createDeployment(@RequestBody RedundancyView redundancyView) {
		// analyse and plan
		redundancyViewService.analyseAndPlan(redundancyView);
		
		// save redundancy view
		redundancyViewService.save(redundancyView);
		
		// create response
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(redundancyView.getId()).toUri());
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{redundancyViewId}", method=RequestMethod.GET)
	public RedundancyView getRedundancyView(@PathVariable Long redundancyViewId) {
		Optional<RedundancyView> redundancyView = redundancyViewService.findOne(redundancyViewId);
		if (redundancyView.isPresent())
			return redundancyView.get();
		throw new RedundancyViewNotFoundException(String.format("RedundancyView %s not found", redundancyViewId));
	}

	@RequestMapping(value="/instances", method=RequestMethod.GET)
	public Collection<Instance> getAllInstances() {
		return instanceService.findAll();
	}
}
