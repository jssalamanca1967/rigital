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

package co.edu.uniandes.csw.grupo.unidaddered.logic.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public abstract class _UnidadDeRedDTO {

	

	private String tipos;
	

	private String servidor;
	

	private String url;
	

	private Long id;
	

	private String name;
	

	private String descripcion;
	

	private String proposito;
	

	private String fechaCreacion;
	

	private Boolean destruido;
	

	private String caracteristicas;



	public String getTipos() {
		return tipos;
	}
 
	public void setTipos(String tipos) {
		this.tipos = tipos;
	}


	public String getServidor() {
		return servidor;
	}
 
	public void setServidor(String servidor) {
		this.servidor = servidor;
	}


	public String getUrl() {
		return url;
	}
 
	public void setUrl(String url) {
		this.url = url;
	}


	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}


	public String getDescripcion() {
		return descripcion;
	}
 
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getProposito() {
		return proposito;
	}
 
	public void setProposito(String proposito) {
		this.proposito = proposito;
	}


	public String getFechaCreacion() {
		return fechaCreacion;
	}
 
	public void setFechaCreacion(String fechacreacion) {
		this.fechaCreacion = fechacreacion;
	}


	public Boolean getDestruido() {
		return destruido;
	}
 
	public void setDestruido(Boolean destruido) {
		this.destruido = destruido;
	}


	public String getCaracteristicas() {
		return caracteristicas;
	}
 
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
}