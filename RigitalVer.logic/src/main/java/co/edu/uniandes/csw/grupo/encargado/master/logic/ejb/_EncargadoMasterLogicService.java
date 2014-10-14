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

package co.edu.uniandes.csw.grupo.encargado.master.logic.ejb;

import co.edu.uniandes.csw.grupo.wiki.logic.dto.WikiDTO;
import co.edu.uniandes.csw.grupo.wiki.persistence.api.IWikiPersistence;
import co.edu.uniandes.csw.grupo.maquinavirtual.logic.dto.MaquinaVirtualDTO;
import co.edu.uniandes.csw.grupo.maquinavirtual.persistence.api.IMaquinaVirtualPersistence;
import co.edu.uniandes.csw.grupo.paginaweb.logic.dto.PaginaWebDTO;
import co.edu.uniandes.csw.grupo.paginaweb.persistence.api.IPaginaWebPersistence;
import co.edu.uniandes.csw.grupo.unidaddered.logic.dto.UnidadDeRedDTO;
import co.edu.uniandes.csw.grupo.unidaddered.persistence.api.IUnidadDeRedPersistence;
import co.edu.uniandes.csw.grupo.repositorio.logic.dto.RepositorioDTO;
import co.edu.uniandes.csw.grupo.repositorio.persistence.api.IRepositorioPersistence;
import co.edu.uniandes.csw.grupo.contenedorweb.logic.dto.ContenedorWebDTO;
import co.edu.uniandes.csw.grupo.contenedorweb.persistence.api.IContenedorWebPersistence;
import co.edu.uniandes.csw.grupo.softwaresalas.logic.dto.SoftwareSalasDTO;
import co.edu.uniandes.csw.grupo.softwaresalas.persistence.api.ISoftwareSalasPersistence;
import co.edu.uniandes.csw.grupo.sqldev.logic.dto.SQLDevDTO;
import co.edu.uniandes.csw.grupo.sqldev.persistence.api.ISQLDevPersistence;
import co.edu.uniandes.csw.grupo.mysql.logic.dto.MySQLDTO;
import co.edu.uniandes.csw.grupo.mysql.persistence.api.IMySQLPersistence;
import co.edu.uniandes.csw.grupo.encargado.logic.dto.EncargadoDTO;
import co.edu.uniandes.csw.grupo.encargado.master.logic.api._IEncargadoMasterLogicService;
import co.edu.uniandes.csw.grupo.encargado.master.logic.dto.EncargadoMasterDTO;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.api.IEncargadoMasterPersistence;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadowikiEntity;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadomaquinaVirtualEntity;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadopaginaWebEntity;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadounidadDeRedEntity;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadorepositorioEntity;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadocontenedorWebEntity;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadosoftwareSalasEntity;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadosQLDevEntity;
import co.edu.uniandes.csw.grupo.encargado.master.persistence.entity.EncargadomySQLEntity;
import co.edu.uniandes.csw.grupo.encargado.persistence.api.IEncargadoPersistence;
import javax.inject.Inject;

public abstract class _EncargadoMasterLogicService implements _IEncargadoMasterLogicService {

    @Inject
    protected IEncargadoPersistence encargadoPersistance;
    @Inject
    protected IEncargadoMasterPersistence encargadoMasterPersistance;
    @Inject
    protected IUnidadDeRedPersistence unidadDeRedPersistance;
    @Inject
    protected IContenedorWebPersistence contenedorWebPersistance;
    @Inject
    protected IMySQLPersistence mySQLPersistance;
    @Inject
    protected ISQLDevPersistence sQLDevPersistance;
    @Inject
    protected ISoftwareSalasPersistence softwareSalasPersistance;
    @Inject
    protected IRepositorioPersistence repositorioPersistance;
    @Inject
    protected IPaginaWebPersistence paginaWebPersistance;
    @Inject
    protected IWikiPersistence wikiPersistance;
    @Inject
    protected IMaquinaVirtualPersistence maquinaVirtualPersistance;

    public EncargadoMasterDTO createMasterEncargado(EncargadoMasterDTO encargado) {
        EncargadoDTO persistedEncargadoDTO = encargadoPersistance.createEncargado(encargado.getEncargadoEntity());
        if (encargado.getCreatewiki() != null) {
            for (WikiDTO wikiDTO : encargado.getCreatewiki()) {
                WikiDTO createdWikiDTO = wikiPersistance.createWiki(wikiDTO);
                EncargadowikiEntity encargadoWikiEntity = new EncargadowikiEntity(persistedEncargadoDTO.getId(), createdWikiDTO.getId());
                encargadoMasterPersistance.createEncargadowikiEntity(encargadoWikiEntity);
            }
        }
        if (encargado.getCreatemaquinaVirtual() != null) {
            for (MaquinaVirtualDTO maquinaVirtualDTO : encargado.getCreatemaquinaVirtual()) {
                MaquinaVirtualDTO createdMaquinaVirtualDTO = maquinaVirtualPersistance.createMaquinaVirtual(maquinaVirtualDTO);
                EncargadomaquinaVirtualEntity encargadoMaquinaVirtualEntity = new EncargadomaquinaVirtualEntity(persistedEncargadoDTO.getId(), createdMaquinaVirtualDTO.getId());
                encargadoMasterPersistance.createEncargadomaquinaVirtualEntity(encargadoMaquinaVirtualEntity);
            }
        }
        if (encargado.getCreatepaginaWeb() != null) {
            for (PaginaWebDTO paginaWebDTO : encargado.getCreatepaginaWeb()) {
                PaginaWebDTO createdPaginaWebDTO = paginaWebPersistance.createPaginaWeb(paginaWebDTO);
                EncargadopaginaWebEntity encargadoPaginaWebEntity = new EncargadopaginaWebEntity(persistedEncargadoDTO.getId(), createdPaginaWebDTO.getId());
                encargadoMasterPersistance.createEncargadopaginaWebEntity(encargadoPaginaWebEntity);
            }
        }
        if (encargado.getCreateunidadDeRed() != null) {
            for (UnidadDeRedDTO unidadDeRedDTO : encargado.getCreateunidadDeRed()) {
                UnidadDeRedDTO createdUnidadDeRedDTO = unidadDeRedPersistance.createUnidadDeRed(unidadDeRedDTO);
                EncargadounidadDeRedEntity encargadoUnidadDeRedEntity = new EncargadounidadDeRedEntity(persistedEncargadoDTO.getId(), createdUnidadDeRedDTO.getId());
                encargadoMasterPersistance.createEncargadounidadDeRedEntity(encargadoUnidadDeRedEntity);
            }
        }
        if (encargado.getCreaterepositorio() != null) {
            for (RepositorioDTO repositorioDTO : encargado.getCreaterepositorio()) {
                RepositorioDTO createdRepositorioDTO = repositorioPersistance.createRepositorio(repositorioDTO);
                EncargadorepositorioEntity encargadoRepositorioEntity = new EncargadorepositorioEntity(persistedEncargadoDTO.getId(), createdRepositorioDTO.getId());
                encargadoMasterPersistance.createEncargadorepositorioEntity(encargadoRepositorioEntity);
            }
        }
        if (encargado.getCreatecontenedorWeb() != null) {
            for (ContenedorWebDTO contenedorWebDTO : encargado.getCreatecontenedorWeb()) {
                ContenedorWebDTO createdContenedorWebDTO = contenedorWebPersistance.createContenedorWeb(contenedorWebDTO);
                EncargadocontenedorWebEntity encargadoContenedorWebEntity = new EncargadocontenedorWebEntity(persistedEncargadoDTO.getId(), createdContenedorWebDTO.getId());
                encargadoMasterPersistance.createEncargadocontenedorWebEntity(encargadoContenedorWebEntity);
            }
        }
        if (encargado.getCreatesoftwareSalas() != null) {
            for (SoftwareSalasDTO softwareSalasDTO : encargado.getCreatesoftwareSalas()) {
                SoftwareSalasDTO createdSoftwareSalasDTO = softwareSalasPersistance.createSoftwareSalas(softwareSalasDTO);
                EncargadosoftwareSalasEntity encargadoSoftwareSalasEntity = new EncargadosoftwareSalasEntity(persistedEncargadoDTO.getId(), createdSoftwareSalasDTO.getId());
                encargadoMasterPersistance.createEncargadosoftwareSalasEntity(encargadoSoftwareSalasEntity);
            }
        }
        if (encargado.getCreatesQLDev() != null) {
            for (SQLDevDTO sQLDevDTO : encargado.getCreatesQLDev()) {
                SQLDevDTO createdSQLDevDTO = sQLDevPersistance.createSQLDev(sQLDevDTO);
                EncargadosQLDevEntity encargadoSQLDevEntity = new EncargadosQLDevEntity(persistedEncargadoDTO.getId(), createdSQLDevDTO.getId());
                encargadoMasterPersistance.createEncargadosQLDevEntity(encargadoSQLDevEntity);
            }
        }
        if (encargado.getCreatemySQL() != null) {
            for (MySQLDTO mySQLDTO : encargado.getCreatemySQL()) {
                MySQLDTO createdMySQLDTO = mySQLPersistance.createMySQL(mySQLDTO);
                EncargadomySQLEntity encargadoMySQLEntity = new EncargadomySQLEntity(persistedEncargadoDTO.getId(), createdMySQLDTO.getId());
                encargadoMasterPersistance.createEncargadomySQLEntity(encargadoMySQLEntity);
            }
        }
        // update wiki
        if (encargado.getUpdatewiki() != null) {
            for (WikiDTO wikiDTO : encargado.getUpdatewiki()) {
                wikiPersistance.updateWiki(wikiDTO);
                EncargadowikiEntity encargadoWikiEntity = new EncargadowikiEntity(persistedEncargadoDTO.getId(), wikiDTO.getId());
                encargadoMasterPersistance.createEncargadowikiEntity(encargadoWikiEntity);
            }
        }
        // update maquinaVirtual
        if (encargado.getUpdatemaquinaVirtual() != null) {
            for (MaquinaVirtualDTO maquinaVirtualDTO : encargado.getUpdatemaquinaVirtual()) {
                maquinaVirtualPersistance.updateMaquinaVirtual(maquinaVirtualDTO);
                EncargadomaquinaVirtualEntity encargadoMaquinaVirtualEntity = new EncargadomaquinaVirtualEntity(persistedEncargadoDTO.getId(), maquinaVirtualDTO.getId());
                encargadoMasterPersistance.createEncargadomaquinaVirtualEntity(encargadoMaquinaVirtualEntity);
            }
        }
        // update paginaWeb
        if (encargado.getUpdatepaginaWeb() != null) {
            for (PaginaWebDTO paginaWebDTO : encargado.getUpdatepaginaWeb()) {
                paginaWebPersistance.updatePaginaWeb(paginaWebDTO);
                EncargadopaginaWebEntity encargadoPaginaWebEntity = new EncargadopaginaWebEntity(persistedEncargadoDTO.getId(), paginaWebDTO.getId());
                encargadoMasterPersistance.createEncargadopaginaWebEntity(encargadoPaginaWebEntity);
            }
        }
        // update unidadDeRed
        if (encargado.getUpdateunidadDeRed() != null) {
            for (UnidadDeRedDTO unidadDeRedDTO : encargado.getUpdateunidadDeRed()) {
                unidadDeRedPersistance.updateUnidadDeRed(unidadDeRedDTO);
                EncargadounidadDeRedEntity encargadoUnidadDeRedEntity = new EncargadounidadDeRedEntity(persistedEncargadoDTO.getId(), unidadDeRedDTO.getId());
                encargadoMasterPersistance.createEncargadounidadDeRedEntity(encargadoUnidadDeRedEntity);
            }
        }
        // update repositorio
        if (encargado.getUpdaterepositorio() != null) {
            for (RepositorioDTO repositorioDTO : encargado.getUpdaterepositorio()) {
                repositorioPersistance.updateRepositorio(repositorioDTO);
                EncargadorepositorioEntity encargadoRepositorioEntity = new EncargadorepositorioEntity(persistedEncargadoDTO.getId(), repositorioDTO.getId());
                encargadoMasterPersistance.createEncargadorepositorioEntity(encargadoRepositorioEntity);
            }
        }
        // update contenedorWeb
        if (encargado.getUpdatecontenedorWeb() != null) {
            for (ContenedorWebDTO contenedorWebDTO : encargado.getUpdatecontenedorWeb()) {
                contenedorWebPersistance.updateContenedorWeb(contenedorWebDTO);
                EncargadocontenedorWebEntity encargadoContenedorWebEntity = new EncargadocontenedorWebEntity(persistedEncargadoDTO.getId(), contenedorWebDTO.getId());
                encargadoMasterPersistance.createEncargadocontenedorWebEntity(encargadoContenedorWebEntity);
            }
        }
        // update softwareSalas
        if (encargado.getUpdatesoftwareSalas() != null) {
            for (SoftwareSalasDTO softwareSalasDTO : encargado.getUpdatesoftwareSalas()) {
                softwareSalasPersistance.updateSoftwareSalas(softwareSalasDTO);
                EncargadosoftwareSalasEntity encargadoSoftwareSalasEntity = new EncargadosoftwareSalasEntity(persistedEncargadoDTO.getId(), softwareSalasDTO.getId());
                encargadoMasterPersistance.createEncargadosoftwareSalasEntity(encargadoSoftwareSalasEntity);
            }
        }
        // update sQLDev
        if (encargado.getUpdatesQLDev() != null) {
            for (SQLDevDTO sQLDevDTO : encargado.getUpdatesQLDev()) {
                sQLDevPersistance.updateSQLDev(sQLDevDTO);
                EncargadosQLDevEntity encargadoSQLDevEntity = new EncargadosQLDevEntity(persistedEncargadoDTO.getId(), sQLDevDTO.getId());
                encargadoMasterPersistance.createEncargadosQLDevEntity(encargadoSQLDevEntity);
            }
        }
        // update mySQL
        if (encargado.getUpdatemySQL() != null) {
            for (MySQLDTO mySQLDTO : encargado.getUpdatemySQL()) {
                mySQLPersistance.updateMySQL(mySQLDTO);
                EncargadomySQLEntity encargadoMySQLEntity = new EncargadomySQLEntity(persistedEncargadoDTO.getId(), mySQLDTO.getId());
                encargadoMasterPersistance.createEncargadomySQLEntity(encargadoMySQLEntity);
            }
        }
        return encargado;
    }

    public EncargadoMasterDTO getMasterEncargado(Long id) {
        return encargadoMasterPersistance.getEncargado(id);
    }

    public void deleteMasterEncargado(Long id) {
        encargadoPersistance.deleteEncargado(id);
    }

    public void updateMasterEncargado(EncargadoMasterDTO encargado) {
        encargadoPersistance.updateEncargado(encargado.getEncargadoEntity());

        //---- FOR RELATIONSHIP
        // delete wiki
        if (encargado.getDeletewiki() != null) {
            for (WikiDTO wikiDTO : encargado.getDeletewiki()) {
                encargadoMasterPersistance.deleteEncargadowikiEntity(encargado.getEncargadoEntity().getId(), wikiDTO.getId());
            }
        }
        // persist new wiki
        if (encargado.getCreatewiki() != null) {
            for (WikiDTO wikiDTO : encargado.getCreatewiki()) {
                EncargadowikiEntity encargadoWikiEntity = new EncargadowikiEntity(encargado.getEncargadoEntity().getId(), wikiDTO.getId());
                encargadoMasterPersistance.createEncargadowikiEntity(encargadoWikiEntity);
            }
        }
        // update wiki
        if (encargado.getUpdatewiki() != null) {
            for (WikiDTO wikiDTO : encargado.getUpdatewiki()) {
                encargadoMasterPersistance.deleteEncargadowikiEntity(encargado.getEncargadoEntity().getId(), wikiDTO.getId());
                wikiPersistance.updateWiki(wikiDTO);
                EncargadowikiEntity encargadoWikiEntity = new EncargadowikiEntity(encargado.getId(), wikiDTO.getId());
                encargadoMasterPersistance.createEncargadowikiEntity(encargadoWikiEntity);
                
            }
        }
        // delete maquinaVirtual
        if (encargado.getDeletemaquinaVirtual() != null) {
            for (MaquinaVirtualDTO maquinaVirtualDTO : encargado.getDeletemaquinaVirtual()) {
                encargadoMasterPersistance.deleteEncargadomaquinaVirtualEntity(encargado.getEncargadoEntity().getId(), maquinaVirtualDTO.getId());
            }
        }
        // persist new maquinaVirtual
        if (encargado.getCreatemaquinaVirtual() != null) {
            for (MaquinaVirtualDTO maquinaVirtualDTO : encargado.getCreatemaquinaVirtual()) {
                EncargadomaquinaVirtualEntity encargadoMaquinaVirtualEntity = new EncargadomaquinaVirtualEntity(encargado.getEncargadoEntity().getId(), maquinaVirtualDTO.getId());
                encargadoMasterPersistance.createEncargadomaquinaVirtualEntity(encargadoMaquinaVirtualEntity);
            }
        }
        // update maquinaVirtual
        if (encargado.getUpdatemaquinaVirtual() != null) {
            for (MaquinaVirtualDTO maquinaVirtualDTO : encargado.getUpdatemaquinaVirtual()) {
                encargadoMasterPersistance.deleteEncargadomaquinaVirtualEntity(encargado.getEncargadoEntity().getId(), maquinaVirtualDTO.getId());
                maquinaVirtualPersistance.updateMaquinaVirtual(maquinaVirtualDTO);
                EncargadomaquinaVirtualEntity encargadoMaquinaVirtualEntity = new EncargadomaquinaVirtualEntity(encargado.getId(), maquinaVirtualDTO.getId());
                encargadoMasterPersistance.createEncargadomaquinaVirtualEntity(encargadoMaquinaVirtualEntity);
                
            }
        }
        // delete paginaWeb
        if (encargado.getDeletepaginaWeb() != null) {
            for (PaginaWebDTO paginaWebDTO : encargado.getDeletepaginaWeb()) {
                encargadoMasterPersistance.deleteEncargadopaginaWebEntity(encargado.getEncargadoEntity().getId(), paginaWebDTO.getId());
            }
        }
        // persist new paginaWeb
        if (encargado.getCreatepaginaWeb() != null) {
            for (PaginaWebDTO paginaWebDTO : encargado.getCreatepaginaWeb()) {
                EncargadopaginaWebEntity encargadoPaginaWebEntity = new EncargadopaginaWebEntity(encargado.getEncargadoEntity().getId(), paginaWebDTO.getId());
                encargadoMasterPersistance.createEncargadopaginaWebEntity(encargadoPaginaWebEntity);
            }
        }
        // update paginaWeb
        if (encargado.getUpdatepaginaWeb() != null) {
            for (PaginaWebDTO paginaWebDTO : encargado.getUpdatepaginaWeb()) {
                encargadoMasterPersistance.deleteEncargadopaginaWebEntity(encargado.getEncargadoEntity().getId(), paginaWebDTO.getId());
                paginaWebPersistance.updatePaginaWeb(paginaWebDTO);
                EncargadopaginaWebEntity encargadoPaginaWebEntity = new EncargadopaginaWebEntity(encargado.getId(), paginaWebDTO.getId());
                encargadoMasterPersistance.createEncargadopaginaWebEntity(encargadoPaginaWebEntity);
                
            }
        }
        // delete unidadDeRed
        if (encargado.getDeleteunidadDeRed() != null) {
            for (UnidadDeRedDTO unidadDeRedDTO : encargado.getDeleteunidadDeRed()) {
                encargadoMasterPersistance.deleteEncargadounidadDeRedEntity(encargado.getEncargadoEntity().getId(), unidadDeRedDTO.getId());
            }
        }
        // persist new unidadDeRed
        if (encargado.getCreateunidadDeRed() != null) {
            for (UnidadDeRedDTO unidadDeRedDTO : encargado.getCreateunidadDeRed()) {
                EncargadounidadDeRedEntity encargadoUnidadDeRedEntity = new EncargadounidadDeRedEntity(encargado.getEncargadoEntity().getId(), unidadDeRedDTO.getId());
                encargadoMasterPersistance.createEncargadounidadDeRedEntity(encargadoUnidadDeRedEntity);
            }
        }
        // update unidadDeRed
        if (encargado.getUpdateunidadDeRed() != null) {
            for (UnidadDeRedDTO unidadDeRedDTO : encargado.getUpdateunidadDeRed()) {
                encargadoMasterPersistance.deleteEncargadounidadDeRedEntity(encargado.getEncargadoEntity().getId(), unidadDeRedDTO.getId());
                unidadDeRedPersistance.updateUnidadDeRed(unidadDeRedDTO);
                EncargadounidadDeRedEntity encargadoUnidadDeRedEntity = new EncargadounidadDeRedEntity(encargado.getId(), unidadDeRedDTO.getId());
                encargadoMasterPersistance.createEncargadounidadDeRedEntity(encargadoUnidadDeRedEntity);
                
            }
        }
        // delete repositorio
        if (encargado.getDeleterepositorio() != null) {
            for (RepositorioDTO repositorioDTO : encargado.getDeleterepositorio()) {
                encargadoMasterPersistance.deleteEncargadorepositorioEntity(encargado.getEncargadoEntity().getId(), repositorioDTO.getId());
            }
        }
        // persist new repositorio
        if (encargado.getCreaterepositorio() != null) {
            for (RepositorioDTO repositorioDTO : encargado.getCreaterepositorio()) {
                EncargadorepositorioEntity encargadoRepositorioEntity = new EncargadorepositorioEntity(encargado.getEncargadoEntity().getId(), repositorioDTO.getId());
                encargadoMasterPersistance.createEncargadorepositorioEntity(encargadoRepositorioEntity);
            }
        }
        // update repositorio
        if (encargado.getUpdaterepositorio() != null) {
            for (RepositorioDTO repositorioDTO : encargado.getUpdaterepositorio()) {
                encargadoMasterPersistance.deleteEncargadorepositorioEntity(encargado.getEncargadoEntity().getId(), repositorioDTO.getId());
                repositorioPersistance.updateRepositorio(repositorioDTO);
                EncargadorepositorioEntity encargadoRepositorioEntity = new EncargadorepositorioEntity(encargado.getId(), repositorioDTO.getId());
                encargadoMasterPersistance.createEncargadorepositorioEntity(encargadoRepositorioEntity);
                
            }
        }
        // delete contenedorWeb
        if (encargado.getDeletecontenedorWeb() != null) {
            for (ContenedorWebDTO contenedorWebDTO : encargado.getDeletecontenedorWeb()) {
                encargadoMasterPersistance.deleteEncargadocontenedorWebEntity(encargado.getEncargadoEntity().getId(), contenedorWebDTO.getId());
            }
        }
        // persist new contenedorWeb
        if (encargado.getCreatecontenedorWeb() != null) {
            for (ContenedorWebDTO contenedorWebDTO : encargado.getCreatecontenedorWeb()) {
                EncargadocontenedorWebEntity encargadoContenedorWebEntity = new EncargadocontenedorWebEntity(encargado.getEncargadoEntity().getId(), contenedorWebDTO.getId());
                encargadoMasterPersistance.createEncargadocontenedorWebEntity(encargadoContenedorWebEntity);
            }
        }
        // update contenedorWeb
        if (encargado.getUpdatecontenedorWeb() != null) {
            for (ContenedorWebDTO contenedorWebDTO : encargado.getUpdatecontenedorWeb()) {
                encargadoMasterPersistance.deleteEncargadocontenedorWebEntity(encargado.getEncargadoEntity().getId(), contenedorWebDTO.getId());
                contenedorWebPersistance.updateContenedorWeb(contenedorWebDTO);
                EncargadocontenedorWebEntity encargadoContenedorWebEntity = new EncargadocontenedorWebEntity(encargado.getId(), contenedorWebDTO.getId());
                encargadoMasterPersistance.createEncargadocontenedorWebEntity(encargadoContenedorWebEntity);
                
            }
        }
        // delete softwareSalas
        if (encargado.getDeletesoftwareSalas() != null) {
            for (SoftwareSalasDTO softwareSalasDTO : encargado.getDeletesoftwareSalas()) {
                encargadoMasterPersistance.deleteEncargadosoftwareSalasEntity(encargado.getEncargadoEntity().getId(), softwareSalasDTO.getId());
            }
        }
        // persist new softwareSalas
        if (encargado.getCreatesoftwareSalas() != null) {
            for (SoftwareSalasDTO softwareSalasDTO : encargado.getCreatesoftwareSalas()) {
                EncargadosoftwareSalasEntity encargadoSoftwareSalasEntity = new EncargadosoftwareSalasEntity(encargado.getEncargadoEntity().getId(), softwareSalasDTO.getId());
                encargadoMasterPersistance.createEncargadosoftwareSalasEntity(encargadoSoftwareSalasEntity);
            }
        }
        // update softwareSalas
        if (encargado.getUpdatesoftwareSalas() != null) {
            for (SoftwareSalasDTO softwareSalasDTO : encargado.getUpdatesoftwareSalas()) {
                encargadoMasterPersistance.deleteEncargadosoftwareSalasEntity(encargado.getEncargadoEntity().getId(), softwareSalasDTO.getId());
                softwareSalasPersistance.updateSoftwareSalas(softwareSalasDTO);
                EncargadosoftwareSalasEntity encargadoSoftwareSalasEntity = new EncargadosoftwareSalasEntity(encargado.getId(), softwareSalasDTO.getId());
                encargadoMasterPersistance.createEncargadosoftwareSalasEntity(encargadoSoftwareSalasEntity);
                
            }
        }
        // delete sQLDev
        if (encargado.getDeletesQLDev() != null) {
            for (SQLDevDTO sQLDevDTO : encargado.getDeletesQLDev()) {
                encargadoMasterPersistance.deleteEncargadosQLDevEntity(encargado.getEncargadoEntity().getId(), sQLDevDTO.getId());
            }
        }
        // persist new sQLDev
        if (encargado.getCreatesQLDev() != null) {
            for (SQLDevDTO sQLDevDTO : encargado.getCreatesQLDev()) {
                EncargadosQLDevEntity encargadoSQLDevEntity = new EncargadosQLDevEntity(encargado.getEncargadoEntity().getId(), sQLDevDTO.getId());
                encargadoMasterPersistance.createEncargadosQLDevEntity(encargadoSQLDevEntity);
            }
        }
        // update sQLDev
        if (encargado.getUpdatesQLDev() != null) {
            for (SQLDevDTO sQLDevDTO : encargado.getUpdatesQLDev()) {
                encargadoMasterPersistance.deleteEncargadosQLDevEntity(encargado.getEncargadoEntity().getId(), sQLDevDTO.getId());
                sQLDevPersistance.updateSQLDev(sQLDevDTO);
                EncargadosQLDevEntity encargadoSQLDevEntity = new EncargadosQLDevEntity(encargado.getId(), sQLDevDTO.getId());
                encargadoMasterPersistance.createEncargadosQLDevEntity(encargadoSQLDevEntity);
                
            }
        }
        // delete mySQL
        if (encargado.getDeletemySQL() != null) {
            for (MySQLDTO mySQLDTO : encargado.getDeletemySQL()) {
                encargadoMasterPersistance.deleteEncargadomySQLEntity(encargado.getEncargadoEntity().getId(), mySQLDTO.getId());
            }
        }
        // persist new mySQL
        if (encargado.getCreatemySQL() != null) {
            for (MySQLDTO mySQLDTO : encargado.getCreatemySQL()) {
                EncargadomySQLEntity encargadoMySQLEntity = new EncargadomySQLEntity(encargado.getEncargadoEntity().getId(), mySQLDTO.getId());
                encargadoMasterPersistance.createEncargadomySQLEntity(encargadoMySQLEntity);
            }
        }
        // update mySQL
        if (encargado.getUpdatemySQL() != null) {
            for (MySQLDTO mySQLDTO : encargado.getUpdatemySQL()) {
                encargadoMasterPersistance.deleteEncargadomySQLEntity(encargado.getEncargadoEntity().getId(), mySQLDTO.getId());
                mySQLPersistance.updateMySQL(mySQLDTO);
                EncargadomySQLEntity encargadoMySQLEntity = new EncargadomySQLEntity(encargado.getId(), mySQLDTO.getId());
                encargadoMasterPersistance.createEncargadomySQLEntity(encargadoMySQLEntity);
                
            }
        }
    }
}
