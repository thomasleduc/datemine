/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.data.Business;

import com.epita.mti.datemine.data.DAO.SharingDAO;
import com.epita.mti.datemine.data.Entity.Sharing;
import com.epita.mti.datemine.tools.RESTError;
import javax.inject.Inject;
import lombok.Getter;

/**
 *
 * @author macbookpro
 */
public class SharingBusiness extends AbstractBusiness<SharingDAO, Sharing> {
    
    public enum SharingRight {
        RELATED(0),
        READ_ONLY(1),
        MODIFY(2);

        @Getter
        private final int value;
        private SharingRight(int value) {
            this.value = value;
        }
    }

    @Inject
    private SharingDAO sharingDAO;

    @Override
    public SharingDAO getDao() {
        return sharingDAO;
    }

    @Override
    public RESTError checkBeforeAdding(Sharing entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
