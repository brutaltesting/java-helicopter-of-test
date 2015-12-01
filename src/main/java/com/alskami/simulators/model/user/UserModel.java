package com.alskami.simulators.model.user;

import com.alskami.simulators.ClientSimulator;
import com.alskami.simulators.model.ClientModelBase;

import java.io.Serializable;


public class UserModel extends ClientModelBase implements Serializable{
	private ClientSimulator simulator;

	private String username;
	private String firstName;
	private String lastName;

	public UserModel(){
	}

	@Override
	public ClientSimulator getSimulator() {
		return simulator;
	}

	@Override
	public void setSimulator(ClientSimulator simulator) {
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
