/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.web.controller;

import com.epita.mti.datemine.data.Business.AbstractBusiness;
import com.epita.mti.datemine.data.DAO.AbstractDAO;
import com.epita.mti.datemine.data.Entity.AbstractEntity;
import com.epita.mti.datemine.web.SessBean;
import javax.inject.Inject;

/**
 * The abstract controller that make the general.
 * @author leduc_t
 * @param <B> The Business.
 * @param <D> The DAO.
 * @param <E> The Entity.
 */
public class AbstractController
<B extends AbstractBusiness<D, E>,
        D extends AbstractDAO<E>,
        E extends AbstractEntity> {

    @Inject
    private SessBean session;

    /*******************************************
     ************* Not used yet ****************
     *******************************************/
}
