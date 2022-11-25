package harkka.EstateManagement.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Management {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long management_id;
	
	@Size(min = 1, max = 50)
	private String managementName, email;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "management")
	private List<Estate> estates;

	public Management() {
		super();
	}

	public Management(String managementName, String email) {
		super();
		this.managementName = managementName;
		this.email = email;
	}
	
	public Management(String managementName, String email, List<Estate> estates) {
		super();
		this.managementName = managementName;
		this.email = email;
		this.estates = estates;
	}

	public Long getManagement_id() {
		return management_id;
	}

	public void setManagement_id(Long management_id) {
		this.management_id = management_id;
	}

	public String getManagementName() {
		return managementName;
	}

	public void setManagementName(String managementName) {
		this.managementName = managementName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Estate> getEstates() {
		return estates;
	}

	public void setEstates(List<Estate> estates) {
		this.estates = estates;
	}

	@Override
	public String toString() {
		return "Management [management_id=" + management_id + ", managementName=" 
				+ managementName + ", email=" + email + "]";
	}
	
	
}
