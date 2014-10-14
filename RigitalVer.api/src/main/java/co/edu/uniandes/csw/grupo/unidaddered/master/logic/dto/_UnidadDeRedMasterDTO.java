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

package co.edu.uniandes.csw.grupo.unidaddered.master.logic.dto;

import co.edu.uniandes.csw.grupo.usuariounidaddered.logic.dto.UsuarioUnidadDeRedDTO;
import co.edu.uniandes.csw.grupo.problema.logic.dto.ProblemaDTO;
import co.edu.uniandes.csw.grupo.unidaddered.logic.dto.UnidadDeRedDTO;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public abstract class _UnidadDeRedMasterDTO {

 
    protected UnidadDeRedDTO unidadderedEntity;
    protected Long id;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public UnidadDeRedDTO getUnidadDeRedEntity() {
        return unidadderedEntity;
    }

    public void setUnidadDeRedEntity(UnidadDeRedDTO unidadderedEntity) {
        this.unidadderedEntity = unidadderedEntity;
    }
    
    public List<UsuarioUnidadDeRedDTO> createusuarios;
    public List<UsuarioUnidadDeRedDTO> updateusuarios;
    public List<UsuarioUnidadDeRedDTO> deleteusuarios;
    public List<UsuarioUnidadDeRedDTO> listusuarios;	
    public List<ProblemaDTO> createproblemas;
    public List<ProblemaDTO> updateproblemas;
    public List<ProblemaDTO> deleteproblemas;
    public List<ProblemaDTO> listproblemas;	
	
	
	
    public List<UsuarioUnidadDeRedDTO> getCreateusuarios(){ return createusuarios; };
    public void setCreateusuarios(List<UsuarioUnidadDeRedDTO> createusuarios){ this.createusuarios=createusuarios; };
    public List<UsuarioUnidadDeRedDTO> getUpdateusuarios(){ return updateusuarios; };
    public void setUpdateusuarios(List<UsuarioUnidadDeRedDTO> updateusuarios){ this.updateusuarios=updateusuarios; };
    public List<UsuarioUnidadDeRedDTO> getDeleteusuarios(){ return deleteusuarios; };
    public void setDeleteusuarios(List<UsuarioUnidadDeRedDTO> deleteusuarios){ this.deleteusuarios=deleteusuarios; };
    public List<UsuarioUnidadDeRedDTO> getListusuarios(){ return listusuarios; };
    public void setListusuarios(List<UsuarioUnidadDeRedDTO> listusuarios){ this.listusuarios=listusuarios; };	
    public List<ProblemaDTO> getCreateproblemas(){ return createproblemas; };
    public void setCreateproblemas(List<ProblemaDTO> createproblemas){ this.createproblemas=createproblemas; };
    public List<ProblemaDTO> getUpdateproblemas(){ return updateproblemas; };
    public void setUpdateproblemas(List<ProblemaDTO> updateproblemas){ this.updateproblemas=updateproblemas; };
    public List<ProblemaDTO> getDeleteproblemas(){ return deleteproblemas; };
    public void setDeleteproblemas(List<ProblemaDTO> deleteproblemas){ this.deleteproblemas=deleteproblemas; };
    public List<ProblemaDTO> getListproblemas(){ return listproblemas; };
    public void setListproblemas(List<ProblemaDTO> listproblemas){ this.listproblemas=listproblemas; };	
	
	
}
