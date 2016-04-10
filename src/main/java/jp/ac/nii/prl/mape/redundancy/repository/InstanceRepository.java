package jp.ac.nii.prl.mape.redundancy.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.ac.nii.prl.mape.redundancy.model.Instance;

public interface InstanceRepository extends JpaRepository<Instance, Long> {

	Collection<Instance> findByRedundancyViewId(Long redundancyViewId);
	
}
