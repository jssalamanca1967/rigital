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

package co.edu.uniandes.csw.grupo.wiki.persistence.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class _WikiEntity {

	private String servidor_host;
	private String rutaServidor;
	@Id
	@GeneratedValue(generator = "Wiki")
	private Long id;
	private String name;
	private String descripcion;
	private String proposito;
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	private Boolean destruido;
	private String caracteristicas;

	public String getServidor_host(){
		return servidor_host;
	}
	
	public void setServidor_host(String servidor_host){
		this.servidor_host = servidor_host;
	}
	public String getRutaServidor(){
		return rutaServidor;
	}
	
	public void setRutaServidor(String rutaServidor){
		this.rutaServidor = rutaServidor;
	}
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getDescripcion(){
		return descripcion;
	}
	
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	public String getProposito(){
		return proposito;
	}
	
	public void setProposito(String proposito){
		this.proposito = proposito;
	}
	public Date getFechaCreacion(){
		return fechaCreacion;
	}
	
	public void setFechaCreacion(Date fechaCreacion){
		this.fechaCreacion = fechaCreacion;
	}
	public Boolean getDestruido(){
		return destruido;
	}
	
	public void setDestruido(Boolean destruido){
		this.destruido = destruido;
	}
	public String getCaracteristicas(){
		return caracteristicas;
	}
	
	public void setCaracteristicas(String caracteristicas){
		this.caracteristicas = caracteristicas;
	}
}