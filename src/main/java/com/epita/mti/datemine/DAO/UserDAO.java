/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.DAO;

import com.epita.mti.datemine.Entity.User;

/**
 *
 * @author leduc_t
 */
public class UserDAO extends AbstractDAO<User>{
    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
