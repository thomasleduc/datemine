/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.data.DAO;

import com.epita.mti.datemine.data.Entity.Sharing;

/**
 *
 * @author leduc_t
 */
public class SharingDAO extends AbstractDAO<Sharing>{

    @Override
    public Class<Sharing> getEntityClass() {
        return Sharing.class;
    }

}
