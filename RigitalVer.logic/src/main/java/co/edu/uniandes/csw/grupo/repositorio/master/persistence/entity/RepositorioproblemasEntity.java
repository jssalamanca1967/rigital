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

package co.edu.uniandes.csw.grupo.repositorio.master.persistence.entity;

import co.edu.uniandes.csw.grupo.problema.persistence.entity.ProblemaEntity;
import co.edu.uniandes.csw.grupo.repositorio.persistence.entity.RepositorioEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn; 
import org.eclipse.persistence.annotations.JoinFetch;

@Entity
@IdClass(RepositorioproblemasEntityId.class)
@NamedQueries({
    @NamedQuery(name = "RepositorioproblemasEntity.getByMasterId", query = "SELECT  u FROM RepositorioproblemasEntity u WHERE u.repositorioId=:repositorioId"),
    @NamedQuery(name = "RepositorioproblemasEntity.deleteRepositorioproblemasEntity", query = "DELETE FROM RepositorioproblemasEntity u WHERE u.repositorioId=:repositorioId and  u.problemasId=:problemasId")
})
public class RepositorioproblemasEntity implements Serializable {

    @Id
    @Column(name = "repositorioId")
    private Long repositorioId;
    @Id
    @Column(name = "problemasId")
    private Long problemasId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "repositorioId", referencedColumnName = "id")
    @JoinFetch
    private ProblemaEntity repositorioIdEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "problemasId", referencedColumnName = "id")
    @JoinFetch
    private ProblemaEntity problemasIdEntity; 

    public RepositorioproblemasEntity() {
    }

    public RepositorioproblemasEntity(Long repositorioId, Long problemasId) {
        this.repositorioId =repositorioId;
        this.problemasId = problemasId;
    }

    public Long getRepositorioId() {
        return repositorioId;
    }

    public void setRepositorioId(Long repositorioId) {
        this.repositorioId = repositorioId;
    }

    public Long getProblemasId() {
        return problemasId;
    }

    public void setProblemasId(Long problemasId) {
        this.problemasId = problemasId;
    }

    public ProblemaEntity getRepositorioIdEntity() {
        return repositorioIdEntity;
    }

    public void setRepositorioIdEntity(ProblemaEntity repositorioIdEntity) {
        this.repositorioIdEntity = repositorioIdEntity;
    }

    public ProblemaEntity getProblemasIdEntity() {
        return problemasIdEntity;
    }

    public void setProblemasIdEntity(ProblemaEntity problemasIdEntity) {
        this.problemasIdEntity = problemasIdEntity;
    }

}