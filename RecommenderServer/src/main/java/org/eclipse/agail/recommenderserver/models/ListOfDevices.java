/*********************************************************************
 * Copyright (C) 2017 TUGraz.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 **********************************************************************/
package org.eclipse.agail.recommenderserver.models;

import java.util.ArrayList;
import java.util.List;

public class ListOfDevices {
	
	private List<Device> deviceList = new ArrayList<Device>();

	public ListOfDevices(){
		
	}
	public List<Device> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<Device> deviceList) {
		this.deviceList = deviceList;
	}

	public void addDevice(Device device) {
		this.deviceList.add(device);
	}

}
