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

import co.edu.uniandes.csw.grupo.sqldev.persistence.entity.SQLDevEntity;
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
@IdClass(EncargadosQLDevEntityId.class)
@NamedQueries({
    @NamedQuery(name = "EncargadosQLDevEntity.getByMasterId", query = "SELECT  u FROM EncargadosQLDevEntity u WHERE u.encargadoId=:encargadoId"),
    @NamedQuery(name = "EncargadosQLDevEntity.deleteEncargadosQLDevEntity", query = "DELETE FROM EncargadosQLDevEntity u WHERE u.encargadoId=:encargadoId and  u.sQLDevId=:sQLDevId")
})
public class EncargadosQLDevEntity implements Serializable {

    @Id
    @Column(name = "encargadoId")
    private Long encargadoId;
    @Id
    @Column(name = "sQLDevId")
    private Long sQLDevId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "encargadoId", referencedColumnName = "id")
    @JoinFetch
    private SQLDevEntity encargadoIdEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "sQLDevId", referencedColumnName = "id")
    @JoinFetch
    private SQLDevEntity sQLDevIdEntity; 

    public EncargadosQLDevEntity() {
    }

    public EncargadosQLDevEntity(Long encargadoId, Long sQLDevId) {
        this.encargadoId =encargadoId;
        this.sQLDevId = sQLDevId;
    }

    public Long getEncargadoId() {
        return encargadoId;
    }

    public void setEncargadoId(Long encargadoId) {
        this.encargadoId = encargadoId;
    }

    public Long getSQLDevId() {
        return sQLDevId;
    }

    public void setSQLDevId(Long sQLDevId) {
        this.sQLDevId = sQLDevId;
    }

    public SQLDevEntity getEncargadoIdEntity() {
        return encargadoIdEntity;
    }

    public void setEncargadoIdEntity(SQLDevEntity encargadoIdEntity) {
        this.encargadoIdEntity = encargadoIdEntity;
    }

    public SQLDevEntity getSQLDevIdEntity() {
        return sQLDevIdEntity;
    }

    public void setSQLDevIdEntity(SQLDevEntity sQLDevIdEntity) {
        this.sQLDevIdEntity = sQLDevIdEntity;
    }

}
