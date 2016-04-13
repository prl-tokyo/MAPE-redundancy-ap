package jp.ac.nii.prl.mape.redundancy.service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

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
		for (Instance instance:redundancyView.getInstances()) {
			instanceService.save(instance);
		}
	}
	
	/* (non-Javadoc)
	 * @see jp.ac.nii.prl.mape.redundancy.service.RedundancyViewService#findOne(java.lang.Long)
	 */
	@Override
	public Optional<RedundancyView> findOne(Long redundancyViewId) {
		RedundancyView redundancy = redundancyViewRepository.findOne(redundancyViewId);
		if (redundancy == null)
			return Optional.empty();
		Collection<Instance> instances = instanceService.findByRedundancyViewId(redundancyViewId);
		redundancy.setInstances(instances);
		return Optional.of(redundancy);
	}

	@Override
	public void analyseAndPlan(RedundancyView redundancyView) {
		Collection<Instance> liveInstances = redundancyView.getInstances()
				.stream()
				.filter(i -> i.getStatus() != 2)
				.collect(Collectors.toList());
		if (liveInstances.size() < 2) {// adaptation required
			addInstance(2 - liveInstances.size(), redundancyView);
		}
	}
	
	private void addInstance(int number, RedundancyView redundancyView) {
		while (number > 0) {
			Collection<Instance> terminatingInstances = redundancyView.getInstances()
					.stream()
					.filter(i -> i.getStatus() == 2)
					.collect(Collectors.toList());
			if (!terminatingInstances.isEmpty()) {
				terminatingInstances.iterator().next().setStatus(0);
			} else {
				Instance instance = instanceService.createNewInstance(redundancyView);
				redundancyView.addInstance(instance);
				redundancyViewRepository.save(redundancyView);
				instanceService.save(instance);
			}
			number--;
		}
	}

}
