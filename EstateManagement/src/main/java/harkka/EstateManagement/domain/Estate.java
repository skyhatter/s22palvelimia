 package harkka.EstateManagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Entity
public class Estate {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long estate_id;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String building, address;
	
	@NotNull
	@Min(value = 1700, message = "Minimi vuosi on 1700")
	@Max(value = 2023, message = "Maksimi rakennus vuosi on 2023")
	private int buildyear;
	
	@ManyToOne
	@JoinColumn(name = "management_id")
	private Management management;
	
	public Estate() {	
	}

	public Estate(String building, String address, int buildyear) {
		super();
		this.building = building;
		this.address = address;
		this.buildyear = buildyear;
	}
	
	public Estate(String building, String address, int buildyear, Management management) {
		super();
		this.building = building;
		this.address = address;
		this.buildyear = buildyear;
		this.management = management;
	}

	public Long getEstate_id() {
		return estate_id;
	}

	public void setEstate_id(Long estate_id) {
		this.estate_id = estate_id;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBuildyear() {
		return buildyear;
	}

	public void setBuildyear(int buildyear) {
		this.buildyear = buildyear;
	}
	
	public Management getManagement() {
		return management;
	}

	public void setManagement(Management management) {
		this.management = management;
	}

	@Override
	public String toString() {
		return "Estate [estate_id=" + estate_id + ", building=" + building + ", address=" + address + ", buildyear=" + buildyear
				+ ", management=" + management + "]";
	}
	
	
	
}
