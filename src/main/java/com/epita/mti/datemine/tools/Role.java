package com.epita.mti.datemine.tools;

/**
 * @author leduc_t
 */
public enum Role {
        /**
         * Administrator preset.
         */
        ADMIN(3),
        /**
         * Premium User preset.
         */
        PREMIUM(2),
        /**
         * Normal User preset.
         */
        USER(1),
        /**
         * Public User preset.
         */
        PUBLIC(0);

        /**
         * The Role value.
         */
        private final int level;

        /**
         * Constructor.
         * @param lvl The value.
         */
        private Role(final int lvl) {
                this.level = lvl;
        }
}