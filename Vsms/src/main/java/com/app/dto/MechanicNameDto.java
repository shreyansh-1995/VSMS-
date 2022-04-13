package com.app.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MechanicNameDto {
	private String mechName;

	public String getMechName() {
		return mechName;
	}

	public void setMechName(String mechName) {
		this.mechName = mechName;
	}
	
//	@Override
//	public String toString() {
//		return "MechanicPendingGetRequest [mechName=" + mechName + "]";
//	}
	
	
}
