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

package co.edu.uniandes.csw.grupo.wiki.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.grupo.wiki.logic.dto.WikiDTO;
import co.edu.uniandes.csw.grupo.wiki.persistence.api._IWikiPersistence;
import co.edu.uniandes.csw.grupo.wiki.persistence.converter.WikiConverter;
import co.edu.uniandes.csw.grupo.wiki.persistence.entity.WikiEntity;

public abstract class _WikiPersistence implements _IWikiPersistence {

  	@PersistenceContext(unitName="RigitalVerPU")
 
	protected EntityManager entityManager;
	
	public WikiDTO createWiki(WikiDTO wiki) {
		WikiEntity entity=WikiConverter.persistenceDTO2Entity(wiki);
		entityManager.persist(entity);
		return WikiConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<WikiDTO> getWikis() {
		Query q = entityManager.createQuery("select u from WikiEntity u");
		return WikiConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public WikiDTO getWiki(Long id) {
		return WikiConverter.entity2PersistenceDTO(entityManager.find(WikiEntity.class, id));
	}

	public void deleteWiki(Long id) {
		WikiEntity entity=entityManager.find(WikiEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateWiki(WikiDTO detail) {
		WikiEntity entity=entityManager.merge(WikiConverter.persistenceDTO2Entity(detail));
		WikiConverter.entity2PersistenceDTO(entity);
	}

}