package com.brutaltesting.helicopters.model.user;

import com.brutaltesting.helicopters.model.IModel;


public interface IUserModel extends IModel {

	public String getUsername();
	public void setUsername(String username);
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
}
