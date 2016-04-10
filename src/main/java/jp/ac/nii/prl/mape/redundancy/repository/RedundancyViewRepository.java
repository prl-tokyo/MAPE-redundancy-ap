package jp.ac.nii.prl.mape.redundancy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.ac.nii.prl.mape.redundancy.model.RedundancyView;

public interface RedundancyViewRepository extends JpaRepository<RedundancyView, Long> {

}
