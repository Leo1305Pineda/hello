package com.pedrocamejo.exeptions;

import java.io.Serializable;

public class IdNotFountExecption extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdNotFountExecption(Serializable id) {
		super("Id Not Found "+ id.toString());
	}

	
	
}
