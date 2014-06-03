package com.epita.mti.datemine.data.DAO.tools;

/**
 * The column name enum for exist research.
 */
public enum FieldAccess {

    /**
     * User : The login column.
     */
    USERNAME("login"),
    /**
     * User : The email column.
     */
    USEREMAIL("email");

    /**
     * The text column.
     */
    private final String column;

    /**
     * Constructor.
     *
     * @param name The column name
     */
    private FieldAccess(final String name) {
        this.column = name;
    }

    @Override
    public String toString() {
        return this.column;
    }
}
