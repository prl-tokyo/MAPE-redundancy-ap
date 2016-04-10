package jp.ac.nii.prl.mape.redundancy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.nii.prl.mape.redundancy.model.Instance;
import jp.ac.nii.prl.mape.redundancy.repository.InstanceRepository;

@Service("instanceService")
public class InstanceServiceImpl implements InstanceService {
	
	@Autowired
	private InstanceRepository instanceRepository;
	
	/* (non-Javadoc)
	 * @see jp.ac.nii.prl.mape.redundancy.service.InstanceService#save(jp.ac.nii.prl.mape.redundancy.model.Instance)
	 */
	public void save(Instance instance) {
		instanceRepository.save(instance);
	}
	
	/* (non-Javadoc)
	 * @see jp.ac.nii.prl.mape.redundancy.service.InstanceService#findOne(java.lang.Long)
	 */
	public Optional<Instance> findOne(Long instanceId) {
		return Optional.ofNullable(instanceRepository.findOne(instanceId));
	}

}
