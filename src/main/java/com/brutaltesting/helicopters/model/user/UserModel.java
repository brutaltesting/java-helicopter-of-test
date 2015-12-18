package com.brutaltesting.helicopters.model.user;

import com.brutaltesting.helicopters.Helicopter;
import com.brutaltesting.helicopters.model.ModelBase;

import java.io.Serializable;


public class UserModel extends ModelBase implements Serializable{
	private Helicopter simulator;

	private String username;
	private String firstName;
	private String lastName;

	public UserModel(){
	}

	@Override
	public Helicopter getSimulator() {
		return simulator;
	}

	@Override
	public void setSimulator(Helicopter simulator) {
		this.simulator = simulator;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
