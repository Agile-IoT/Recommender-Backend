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

public class Workflow {

	
	public String type;
	public String datatag;
	public String dataowner;
	public String href;
	public String description;
	public String installCommand;
	public String javascriptCode;
	
	public Workflow(){
		
	}
	
	public Workflow(String type,String datatag,String dataowner,String href){
		this.type = type;
		this.datatag = datatag;
		this.dataowner = dataowner; 
		this.href = href;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDatatag() {
		return datatag;
	}
	public void setDatatag(String datatag) {
		this.datatag = datatag;
	}
	public String getDataowner() {
		return dataowner;
	}
	public void setDataowner(String dataowner) {
		this.dataowner = dataowner;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstallCommand() {
		return installCommand;
	}

	public void setInstallCommand(String installCommand) {
		this.installCommand = installCommand;
	}

	public String getJavascriptCode() {
		return javascriptCode;
	}

	public void setJavascriptCode(String javascriptCode) {
		this.javascriptCode = javascriptCode;
	}
	

}
