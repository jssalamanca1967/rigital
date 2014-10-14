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

package co.edu.uniandes.csw.grupo.mysql.master.persistence;
import co.edu.uniandes.csw.grupo.problema.logic.dto.ProblemaDTO;
import co.edu.uniandes.csw.grupo.mysql.master.persistence.entity.MySQLproblemaEntity;
import co.edu.uniandes.csw.grupo.problema.persistence.converter.ProblemaConverter;
import co.edu.uniandes.csw.grupo.mysql.logic.dto.MySQLDTO;
import co.edu.uniandes.csw.grupo.mysql.master.logic.dto.MySQLMasterDTO;
import co.edu.uniandes.csw.grupo.mysql.master.persistence.api._IMySQLMasterPersistence;
import co.edu.uniandes.csw.grupo.mysql.persistence.api.IMySQLPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class _MySQLMasterPersistence implements _IMySQLMasterPersistence {

  	@PersistenceContext(unitName="RigitalVerPU")
 
    protected EntityManager entityManager;
    
    @Inject
    protected IMySQLPersistence mysqlPersistence;  

    public MySQLMasterDTO getMySQL(Long mysqlId) {
        MySQLMasterDTO mysqlMasterDTO = new MySQLMasterDTO();
        MySQLDTO mysql = mysqlPersistence.getMySQL(mysqlId);
        mysqlMasterDTO.setMySQLEntity(mysql);
        mysqlMasterDTO.setListproblema(getMySQLproblemaEntityList(mysqlId));
        return mysqlMasterDTO;
    }

    public MySQLproblemaEntity createMySQLproblemaEntity(MySQLproblemaEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteMySQLproblemaEntity(Long mySQLId, Long problemaId) {
        Query q = entityManager.createNamedQuery("MySQLproblemaEntity.deleteMySQLproblemaEntity");
        q.setParameter("mySQLId", mySQLId);
        q.setParameter("problemaId", problemaId);
        q.executeUpdate();
    }

    public List<ProblemaDTO> getMySQLproblemaEntityList(Long mySQLId) {
        ArrayList<ProblemaDTO> resp = new ArrayList<ProblemaDTO>();
        Query q = entityManager.createNamedQuery("MySQLproblemaEntity.getByMasterId");
        q.setParameter("mySQLId",mySQLId);
        List<MySQLproblemaEntity> qResult =  q.getResultList();
        for (MySQLproblemaEntity entity : qResult) { 
            if(entity.getProblemaIdEntity()==null){
                entityManager.refresh(entity);
            }
            resp.add(ProblemaConverter.entity2PersistenceDTO(entity.getProblemaIdEntity()));
        }
        return resp;
    }

}
