package jp.ac.nii.prl.mape.redundancy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.nii.prl.mape.redundancy.model.Instance;
import jp.ac.nii.prl.mape.redundancy.model.RedundancyView;
import jp.ac.nii.prl.mape.redundancy.repository.RedundancyViewRepository;

@Service("redundancyViewService")
public class RedundancyViewServiceImpl implements RedundancyViewService {

	@Autowired
	private RedundancyViewRepository redundancyViewRepository;
	
	@Autowired
	private InstanceService instanceService;
	
	/* (non-Javadoc)
	 * @see jp.ac.nii.prl.mape.redundancy.service.RedundancyViewService#save(jp.ac.nii.prl.mape.redundancy.model.RedundancyView)
	 */
	@Override
	public void save(RedundancyView redundancyView) {
		redundancyViewRepository.save(redundancyView);
		for (Instance instance:redundancyView.getInstances())
			instanceService.save(instance);
	}
	
	/* (non-Javadoc)
	 * @see jp.ac.nii.prl.mape.redundancy.service.RedundancyViewService#findOne(java.lang.Long)
	 */
	@Override
	public Optional<RedundancyView> findOne(Long redundancyViewId) {
		return Optional.ofNullable(redundancyViewRepository.findOne(redundancyViewId));
	}

	@Override
	public void analyseAndPlan(RedundancyView redundancyView) {
		if (redundancyView.getInstances().size() < 2) {// adaptation required
			addInstance(redundancyView);
		}
	}
	
	private void addInstance(RedundancyView redundancyView) {
		Instance instance = instanceService.createNewInstance(redundancyView);
		redundancyView.addInstance(instance);
		redundancyViewRepository.save(redundancyView);
		instanceService.save(instance);
	}

}
