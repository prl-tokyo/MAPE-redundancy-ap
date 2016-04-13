package jp.ac.nii.prl.mape.redundancy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Instance {

	@GeneratedValue
	@Id
	@JsonIgnore
	private Long id;
	
	@NotEmpty
	private String instID;
	
	@NotNull
	private int status;
	
	@ManyToOne
	@JsonIgnore
	private RedundancyView redundancyView;

	public Long getId() {
		return id;
	}

	public String getInstID() {
		return instID;
	}

	@JsonBackReference
	public RedundancyView getRedundancyView() {
		return redundancyView;
	}

	public int getStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInstID(String instID) {
		this.instID = instID;
	}

	public void setRedundancyView(RedundancyView redundancyView) {
		this.redundancyView = redundancyView;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return String.format("Instance ID %s(%d), status %d, in view %d", instID, id, status, redundancyView.getId());
	}
}
