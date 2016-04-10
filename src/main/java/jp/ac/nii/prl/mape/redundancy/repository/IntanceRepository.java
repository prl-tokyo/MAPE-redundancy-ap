package jp.ac.nii.prl.mape.redundancy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.ac.nii.prl.mape.redundancy.model.Instance;

public interface IntanceRepository extends JpaRepository<Instance, Long> {

}
