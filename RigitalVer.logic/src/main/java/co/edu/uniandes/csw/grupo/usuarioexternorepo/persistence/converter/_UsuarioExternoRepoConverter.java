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

package co.edu.uniandes.csw.grupo.usuarioexternorepo.persistence.converter;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


import co.edu.uniandes.csw.grupo.usuarioexternorepo.logic.dto.UsuarioExternoRepoDTO;
import co.edu.uniandes.csw.grupo.usuarioexternorepo.persistence.entity.UsuarioExternoRepoEntity;

public abstract class _UsuarioExternoRepoConverter {

	public static UsuarioExternoRepoDTO entity2PersistenceDTO(UsuarioExternoRepoEntity entity){
		if (entity != null) {
			UsuarioExternoRepoDTO dto = new UsuarioExternoRepoDTO();
					dto.setTipoAcceso(entity.getTipoAcceso());
					dto.setId(entity.getId());
					dto.setName(entity.getName());
					dto.setLogin(entity.getLogin());
					dto.setPermisoEscritura(entity.getPermisoEscritura());
					dto.setPermisoLectura(entity.getPermisoLectura());
			return dto;
		}else{
			return null;
		}
	}
	
	public static UsuarioExternoRepoEntity persistenceDTO2Entity(UsuarioExternoRepoDTO dto){
		if(dto!=null){
			UsuarioExternoRepoEntity entity=new UsuarioExternoRepoEntity();
					entity.setTipoAcceso(dto.getTipoAcceso());
			
					entity.setId(dto.getId());
			
					entity.setName(dto.getName());
			
					entity.setLogin(dto.getLogin());
			
					entity.setPermisoEscritura(dto.getPermisoEscritura());
			
					entity.setPermisoLectura(dto.getPermisoLectura());
			
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<UsuarioExternoRepoDTO> entity2PersistenceDTOList(List<UsuarioExternoRepoEntity> entities){
		List<UsuarioExternoRepoDTO> dtos=new ArrayList<UsuarioExternoRepoDTO>();
		for(UsuarioExternoRepoEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<UsuarioExternoRepoEntity> persistenceDTO2EntityList(List<UsuarioExternoRepoDTO> dtos){
		List<UsuarioExternoRepoEntity> entities=new ArrayList<UsuarioExternoRepoEntity>();
		for(UsuarioExternoRepoDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}