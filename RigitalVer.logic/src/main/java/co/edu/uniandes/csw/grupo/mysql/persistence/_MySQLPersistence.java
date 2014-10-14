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

package co.edu.uniandes.csw.grupo.mysql.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.grupo.mysql.logic.dto.MySQLDTO;
import co.edu.uniandes.csw.grupo.mysql.persistence.api._IMySQLPersistence;
import co.edu.uniandes.csw.grupo.mysql.persistence.converter.MySQLConverter;
import co.edu.uniandes.csw.grupo.mysql.persistence.entity.MySQLEntity;

public abstract class _MySQLPersistence implements _IMySQLPersistence {

  	@PersistenceContext(unitName="RigitalVerPU")
 
	protected EntityManager entityManager;
	
	public MySQLDTO createMySQL(MySQLDTO mySQL) {
		MySQLEntity entity=MySQLConverter.persistenceDTO2Entity(mySQL);
		entityManager.persist(entity);
		return MySQLConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<MySQLDTO> getMySQLs() {
		Query q = entityManager.createQuery("select u from MySQLEntity u");
		return MySQLConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public MySQLDTO getMySQL(Long id) {
		return MySQLConverter.entity2PersistenceDTO(entityManager.find(MySQLEntity.class, id));
	}

	public void deleteMySQL(Long id) {
		MySQLEntity entity=entityManager.find(MySQLEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateMySQL(MySQLDTO detail) {
		MySQLEntity entity=entityManager.merge(MySQLConverter.persistenceDTO2Entity(detail));
		MySQLConverter.entity2PersistenceDTO(entity);
	}

}