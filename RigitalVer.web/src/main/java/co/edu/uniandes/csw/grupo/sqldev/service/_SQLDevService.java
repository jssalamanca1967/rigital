/* ========================================================================
 * Copyright 2014 grupo
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 grupo

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201408112050

*/

package co.edu.uniandes.csw.grupo.sqldev.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.grupo.sqldev.logic.api.ISQLDevLogicService;
import co.edu.uniandes.csw.grupo.sqldev.logic.dto.SQLDevDTO;


public abstract class _SQLDevService {

	@Inject
	protected ISQLDevLogicService sQLDevLogicService;
	
	@POST
	public SQLDevDTO createSQLDev(SQLDevDTO sQLDev){
		return sQLDevLogicService.createSQLDev(sQLDev);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteSQLDev(@PathParam("id") Long id){
		sQLDevLogicService.deleteSQLDev(id);
	}
	
	@GET
	public List<SQLDevDTO> getSQLDevs(){
		return sQLDevLogicService.getSQLDevs();
	}
	
	@GET
	@Path("{id}")
	public SQLDevDTO getSQLDev(@PathParam("id") Long id){
		return sQLDevLogicService.getSQLDev(id);
	}
	
	@PUT
    @Path("{id}")
	public void updateSQLDev(@PathParam("id") Long id, SQLDevDTO sQLDev){
		sQLDevLogicService.updateSQLDev(sQLDev);
	}
	
}