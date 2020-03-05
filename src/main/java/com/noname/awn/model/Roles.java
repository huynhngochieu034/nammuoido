package com.noname.awn.model;

import org.springframework.data.mongodb.core.mapping.Document;
import com.noname.awn.enums.ERole;

@Document(collection = "Roles")
public class Roles extends BaseClass {
	
	private ERole name;

	  public Roles() {

	  }

	  public Roles(ERole name) {
	    this.setName(name);
	  }

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}

}
