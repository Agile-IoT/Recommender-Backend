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

public class ListOfClouds {
	
	private List<Cloud> cloudList = new ArrayList<Cloud>();

	public List<Cloud> getCloudList() {
		return cloudList;
	}

	public void setCloudList(List<Cloud> cloudList) {
		this.cloudList = cloudList;
	}

}
