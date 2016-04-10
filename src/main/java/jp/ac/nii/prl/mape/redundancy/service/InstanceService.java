package jp.ac.nii.prl.mape.redundancy.service;

import java.util.Collection;
import java.util.Optional;

import jp.ac.nii.prl.mape.redundancy.model.Instance;
import jp.ac.nii.prl.mape.redundancy.model.RedundancyView;

public interface InstanceService {

	void save(Instance instance);

	Optional<Instance> findOne(Long instanceId);
	
	Collection<Instance> findByRedundancyViewId(Long redundancyViewId);

	Instance createNewInstance(RedundancyView redundancyView);

}