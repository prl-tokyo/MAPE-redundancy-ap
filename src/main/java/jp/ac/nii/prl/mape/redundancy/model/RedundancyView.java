package jp.ac.nii.prl.mape.redundancy.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RedundancyView {

	@GeneratedValue
	@Id
	@JsonIgnore
	private Long id;
	
	@NotEmpty
	@OneToMany(mappedBy="RedundancyView")
	private Collection<Instance> instances;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Instance> getInstances() {
		return instances;
	}

	public void setInstances(Collection<Instance> instances) {
		this.instances = instances;
	}

	public void addInstance(Instance instance) {
		instances.add(instance);
	}
	
}
