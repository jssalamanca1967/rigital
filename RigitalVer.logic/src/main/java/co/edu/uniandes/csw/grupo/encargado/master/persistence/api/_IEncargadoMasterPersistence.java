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

package co.edu.uniandes.csw.grupo.encargado.master.persistence.api;

import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadowikiEntity;
import co.edu.uniandes.csw.grupo.wiki.logic.dto.WikiDTO;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadomaquinaVirtualEntity;
import co.edu.uniandes.csw.grupo.maquinavirtual.logic.dto.MaquinaVirtualDTO;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadopaginaWebEntity;
import co.edu.uniandes.csw.grupo.paginaweb.logic.dto.PaginaWebDTO;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadounidadDeRedEntity;
import co.edu.uniandes.csw.grupo.unidaddered.logic.dto.UnidadDeRedDTO;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadorepositorioEntity;
import co.edu.uniandes.csw.grupo.repositorio.logic.dto.RepositorioDTO;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadocontenedorWebEntity;
import co.edu.uniandes.csw.grupo.contenedorweb.logic.dto.ContenedorWebDTO;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadosoftwareSalasEntity;
import co.edu.uniandes.csw.grupo.softwaresalas.logic.dto.SoftwareSalasDTO;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadosQLDevEntity;
import co.edu.uniandes.csw.grupo.sqldev.logic.dto.SQLDevDTO;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadomySQLEntity;
import co.edu.uniandes.csw.grupo.mysql.logic.dto.MySQLDTO;
import co.edu.uniandes.csw.grupo.encargado.master.logic.dto.EncargadoMasterDTO;
import java.util.List;

public interface _IEncargadoMasterPersistence {

	public EncargadoMasterDTO getEncargado(Long encargadoId);
	
	
    public EncargadowikiEntity createEncargadowikiEntity(EncargadowikiEntity entity);
    public void deleteEncargadowikiEntity(Long encargadoId, Long wikiId);
    public List<WikiDTO> getEncargadowikiEntityList(Long encargadoId);
    public EncargadomaquinaVirtualEntity createEncargadomaquinaVirtualEntity(EncargadomaquinaVirtualEntity entity);
    public void deleteEncargadomaquinaVirtualEntity(Long encargadoId, Long maquinaVirtualId);
    public List<MaquinaVirtualDTO> getEncargadomaquinaVirtualEntityList(Long encargadoId);
    public EncargadopaginaWebEntity createEncargadopaginaWebEntity(EncargadopaginaWebEntity entity);
    public void deleteEncargadopaginaWebEntity(Long encargadoId, Long paginaWebId);
    public List<PaginaWebDTO> getEncargadopaginaWebEntityList(Long encargadoId);
    public EncargadounidadDeRedEntity createEncargadounidadDeRedEntity(EncargadounidadDeRedEntity entity);
    public void deleteEncargadounidadDeRedEntity(Long encargadoId, Long unidadDeRedId);
    public List<UnidadDeRedDTO> getEncargadounidadDeRedEntityList(Long encargadoId);
    public EncargadorepositorioEntity createEncargadorepositorioEntity(EncargadorepositorioEntity entity);
    public void deleteEncargadorepositorioEntity(Long encargadoId, Long repositorioId);
    public List<RepositorioDTO> getEncargadorepositorioEntityList(Long encargadoId);
    public EncargadocontenedorWebEntity createEncargadocontenedorWebEntity(EncargadocontenedorWebEntity entity);
    public void deleteEncargadocontenedorWebEntity(Long encargadoId, Long contenedorWebId);
    public List<ContenedorWebDTO> getEncargadocontenedorWebEntityList(Long encargadoId);
    public EncargadosoftwareSalasEntity createEncargadosoftwareSalasEntity(EncargadosoftwareSalasEntity entity);
    public void deleteEncargadosoftwareSalasEntity(Long encargadoId, Long softwareSalasId);
    public List<SoftwareSalasDTO> getEncargadosoftwareSalasEntityList(Long encargadoId);
    public EncargadosQLDevEntity createEncargadosQLDevEntity(EncargadosQLDevEntity entity);
    public void deleteEncargadosQLDevEntity(Long encargadoId, Long sQLDevId);
    public List<SQLDevDTO> getEncargadosQLDevEntityList(Long encargadoId);
    public EncargadomySQLEntity createEncargadomySQLEntity(EncargadomySQLEntity entity);
    public void deleteEncargadomySQLEntity(Long encargadoId, Long mySQLId);
    public List<MySQLDTO> getEncargadomySQLEntityList(Long encargadoId);
   
  
}
