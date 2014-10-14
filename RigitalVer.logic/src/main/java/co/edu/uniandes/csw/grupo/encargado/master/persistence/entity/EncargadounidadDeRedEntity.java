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

package co.edu.uniandes.csw.grupo.encargado.master.persistence.entity;

import co.edu.uniandes.csw.grupo.unidaddered.persistence.entity.UnidadDeRedEntity;
import co.edu.uniandes.csw.grupo.encargado.persistence.entity.EncargadoEntity;
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
@IdClass(EncargadounidadDeRedEntityId.class)
@NamedQueries({
    @NamedQuery(name = "EncargadounidadDeRedEntity.getByMasterId", query = "SELECT  u FROM EncargadounidadDeRedEntity u WHERE u.encargadoId=:encargadoId"),
    @NamedQuery(name = "EncargadounidadDeRedEntity.deleteEncargadounidadDeRedEntity", query = "DELETE FROM EncargadounidadDeRedEntity u WHERE u.encargadoId=:encargadoId and  u.unidadDeRedId=:unidadDeRedId")
})
public class EncargadounidadDeRedEntity implements Serializable {

    @Id
    @Column(name = "encargadoId")
    private Long encargadoId;
    @Id
    @Column(name = "unidadDeRedId")
    private Long unidadDeRedId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "encargadoId", referencedColumnName = "id")
    @JoinFetch
    private UnidadDeRedEntity encargadoIdEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "unidadDeRedId", referencedColumnName = "id")
    @JoinFetch
    private UnidadDeRedEntity unidadDeRedIdEntity; 

    public EncargadounidadDeRedEntity() {
    }

    public EncargadounidadDeRedEntity(Long encargadoId, Long unidadDeRedId) {
        this.encargadoId =encargadoId;
        this.unidadDeRedId = unidadDeRedId;
    }

    public Long getEncargadoId() {
        return encargadoId;
    }

    public void setEncargadoId(Long encargadoId) {
        this.encargadoId = encargadoId;
    }

    public Long getUnidadDeRedId() {
        return unidadDeRedId;
    }

    public void setUnidadDeRedId(Long unidadDeRedId) {
        this.unidadDeRedId = unidadDeRedId;
    }

    public UnidadDeRedEntity getEncargadoIdEntity() {
        return encargadoIdEntity;
    }

    public void setEncargadoIdEntity(UnidadDeRedEntity encargadoIdEntity) {
        this.encargadoIdEntity = encargadoIdEntity;
    }

    public UnidadDeRedEntity getUnidadDeRedIdEntity() {
        return unidadDeRedIdEntity;
    }

    public void setUnidadDeRedIdEntity(UnidadDeRedEntity unidadDeRedIdEntity) {
        this.unidadDeRedIdEntity = unidadDeRedIdEntity;
    }

}