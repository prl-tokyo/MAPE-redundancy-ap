package jp.ac.nii.prl.mape.redundancy.service;

import java.util.Optional;

import jp.ac.nii.prl.mape.redundancy.model.RedundancyView;

public interface RedundancyViewService {

	void save(RedundancyView redundancyView);

	Optional<RedundancyView> findOne(Long redundancyViewId);
	
	void analyseAndPlan(RedundancyView redundancyView);

}