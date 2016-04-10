package jp.ac.nii.prl.mape.redundancy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.ac.nii.prl.mape.redundancy.model.Instance;

public interface InstanceRepository extends JpaRepository<Instance, Long> {

}
