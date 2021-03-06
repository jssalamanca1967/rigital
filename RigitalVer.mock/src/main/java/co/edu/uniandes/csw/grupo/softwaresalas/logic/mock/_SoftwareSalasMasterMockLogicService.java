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

package co.edu.uniandes.csw.grupo.softwaresalas.logic.mock;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.grupo.softwaresalas.logic.dto.SoftwareSalasDTO;
import co.edu.uniandes.csw.grupo.softwaresalas.logic.api.ISoftwareSalasLogicService;
import co.edu.uniandes.csw.grupo.softwaresalas.master.logic.api._ISoftwareSalasMasterLogicService;
import co.edu.uniandes.csw.grupo.softwaresalas.master.logic.dto.SoftwareSalasMasterDTO;
import co.edu.uniandes.csw.grupo.problema.logic.api.IProblemaLogicService;
import co.edu.uniandes.csw.grupo.problema.logic.dto.ProblemaDTO;
import javax.inject.Inject;


public abstract class _SoftwareSalasMasterMockLogicService implements _ISoftwareSalasMasterLogicService {

    protected static ArrayList<SoftwareSalasMasterDTO> softwareSalasMasterDtosList = new ArrayList<SoftwareSalasMasterDTO>() ;
    @Inject
    protected IProblemaLogicService problemaPersistance;
    @Inject
    protected ISoftwareSalasLogicService softwareSalasPersistance;

    public SoftwareSalasMasterDTO createMasterSoftwareSalas(SoftwareSalasMasterDTO softwareSalas) {

        softwareSalasPersistance.createSoftwareSalas(softwareSalas.getSoftwareSalasEntity());
        for (ProblemaDTO dto : softwareSalas.getCreateproblema()) {
            problemaPersistance.createProblema(dto);
        }
        softwareSalasMasterDtosList.add(softwareSalas);
        return softwareSalas;
    }

    public SoftwareSalasMasterDTO getMasterSoftwareSalas(Long id) {
        for (SoftwareSalasMasterDTO softwareSalasMasterDTO : softwareSalasMasterDtosList) {
            if (softwareSalasMasterDTO.getSoftwareSalasEntity().getId() == id) {
                return softwareSalasMasterDTO;
            }
        }

        return null;
    }

    public void deleteMasterSoftwareSalas(Long id) {
        for (SoftwareSalasMasterDTO softwareSalasMasterDTO : softwareSalasMasterDtosList) {
            if (softwareSalasMasterDTO.getSoftwareSalasEntity().getId() == id) {

                for (ProblemaDTO dto : softwareSalasMasterDTO.getCreateproblema()) {
                    problemaPersistance.deleteProblema(dto.getId());
                }
                softwareSalasPersistance.deleteSoftwareSalas(softwareSalasMasterDTO.getId());
                softwareSalasMasterDtosList.remove(softwareSalasMasterDTO);
            }
        }

    }

    public void updateMasterSoftwareSalas(SoftwareSalasMasterDTO softwareSalas) {

        // update Problema
        if (softwareSalas.getUpdateproblema() != null) {
            for (ProblemaDTO dto : softwareSalas.getUpdateproblema()) {
                problemaPersistance.updateProblema(dto);
            }
        }
        // persist new Problema
        if (softwareSalas.getCreateproblema() != null) {
            for (ProblemaDTO dto : softwareSalas.getCreateproblema()) {
                ProblemaDTO persistedProblemaDTO = problemaPersistance.createProblema(dto);
                dto = persistedProblemaDTO;
            }
        }
        // delete Problema
        if (softwareSalas.getDeleteproblema() != null) {
            for (ProblemaDTO dto : softwareSalas.getDeleteproblema()) {

                problemaPersistance.deleteProblema(dto.getId());
            }
        }
    }
}