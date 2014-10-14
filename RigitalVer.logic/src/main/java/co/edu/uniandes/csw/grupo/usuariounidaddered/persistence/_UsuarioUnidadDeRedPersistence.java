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

package co.edu.uniandes.csw.grupo.usuariounidaddered.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.grupo.usuariounidaddered.logic.dto.UsuarioUnidadDeRedDTO;
import co.edu.uniandes.csw.grupo.usuariounidaddered.persistence.api._IUsuarioUnidadDeRedPersistence;
import co.edu.uniandes.csw.grupo.usuariounidaddered.persistence.converter.UsuarioUnidadDeRedConverter;
import co.edu.uniandes.csw.grupo.usuariounidaddered.persistence.entity.UsuarioUnidadDeRedEntity;

public abstract class _UsuarioUnidadDeRedPersistence implements _IUsuarioUnidadDeRedPersistence {

  	@PersistenceContext(unitName="RigitalVerPU")
 
	protected EntityManager entityManager;
	
	public UsuarioUnidadDeRedDTO createUsuarioUnidadDeRed(UsuarioUnidadDeRedDTO usuarioUnidadDeRed) {
		UsuarioUnidadDeRedEntity entity=UsuarioUnidadDeRedConverter.persistenceDTO2Entity(usuarioUnidadDeRed);
		entityManager.persist(entity);
		return UsuarioUnidadDeRedConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<UsuarioUnidadDeRedDTO> getUsuarioUnidadDeReds() {
		Query q = entityManager.createQuery("select u from UsuarioUnidadDeRedEntity u");
		return UsuarioUnidadDeRedConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public UsuarioUnidadDeRedDTO getUsuarioUnidadDeRed(Long id) {
		return UsuarioUnidadDeRedConverter.entity2PersistenceDTO(entityManager.find(UsuarioUnidadDeRedEntity.class, id));
	}

	public void deleteUsuarioUnidadDeRed(Long id) {
		UsuarioUnidadDeRedEntity entity=entityManager.find(UsuarioUnidadDeRedEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateUsuarioUnidadDeRed(UsuarioUnidadDeRedDTO detail) {
		UsuarioUnidadDeRedEntity entity=entityManager.merge(UsuarioUnidadDeRedConverter.persistenceDTO2Entity(detail));
		UsuarioUnidadDeRedConverter.entity2PersistenceDTO(entity);
	}

}