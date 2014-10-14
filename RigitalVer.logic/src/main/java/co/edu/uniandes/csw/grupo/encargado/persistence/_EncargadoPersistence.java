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

package co.edu.uniandes.csw.grupo.encargado.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.grupo.encargado.logic.dto.EncargadoDTO;
import co.edu.uniandes.csw.grupo.encargado.persistence.api._IEncargadoPersistence;
import co.edu.uniandes.csw.grupo.encargado.persistence.converter.EncargadoConverter;
import co.edu.uniandes.csw.grupo.encargado.persistence.entity.EncargadoEntity;

public abstract class _EncargadoPersistence implements _IEncargadoPersistence {

  	@PersistenceContext(unitName="RigitalVerPU")
 
	protected EntityManager entityManager;
	
	public EncargadoDTO createEncargado(EncargadoDTO encargado) {
		EncargadoEntity entity=EncargadoConverter.persistenceDTO2Entity(encargado);
		entityManager.persist(entity);
		return EncargadoConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<EncargadoDTO> getEncargados() {
		Query q = entityManager.createQuery("select u from EncargadoEntity u");
		return EncargadoConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public EncargadoDTO getEncargado(Long id) {
		return EncargadoConverter.entity2PersistenceDTO(entityManager.find(EncargadoEntity.class, id));
	}

	public void deleteEncargado(Long id) {
		EncargadoEntity entity=entityManager.find(EncargadoEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateEncargado(EncargadoDTO detail) {
		EncargadoEntity entity=entityManager.merge(EncargadoConverter.persistenceDTO2Entity(detail));
		EncargadoConverter.entity2PersistenceDTO(entity);
	}

}