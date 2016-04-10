package jp.ac.nii.prl.mape.redundancy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.nii.prl.mape.redundancy.model.RedundancyView;
import jp.ac.nii.prl.mape.redundancy.repository.RedundancyViewRepository;

@Service("redundancyViewService")
public class RedundancyViewServiceImpl implements RedundancyViewService {

	@Autowired
	private RedundancyViewRepository redundancyViewRepository;
	
	/* (non-Javadoc)
	 * @see jp.ac.nii.prl.mape.redundancy.service.RedundancyViewService#save(jp.ac.nii.prl.mape.redundancy.model.RedundancyView)
	 */
	@Override
	public void save(RedundancyView redundancyView) {
		redundancyViewRepository.save(redundancyView);
	}
	
	/* (non-Javadoc)
	 * @see jp.ac.nii.prl.mape.redundancy.service.RedundancyViewService#findOne(java.lang.Long)
	 */
	@Override
	public Optional<RedundancyView> findOne(Long redundancyViewId) {
		return Optional.ofNullable(redundancyViewRepository.findOne(redundancyViewId));
	}

}
