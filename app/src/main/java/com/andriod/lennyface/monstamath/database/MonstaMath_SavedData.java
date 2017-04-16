package com.andriod.lennyface.monstamath.database;



public class MonstaMath_SavedData {
    public static final String TABLE_GAMESAVE = "game_save";
    public static final String COLUMN_LEVEL = "level";
    public static final String COLUMN_CHARACTERTYPE = "character type";
   // public static final String COLUMN_CHARACTERHEALTH = "character type";
   // public static final String COLUMN_CHARACTERDAMAGE = "character type";
    public static final String COLUMN_MONSTERSUSED = "monster names";
    public static final String COLUMN_CHARACTERSCOMPLETED = "characters completed";
    public static final String COLUMN_MUSICSELECTION = "music";
    public static final String COLUMN_VOLUMECONTROL = "volume";
    public static final String COLUMN_HAPTIC = "haptic";

    public static final String SQL_CREATE =
            "Create Table " + TABLE_GAMESAVE + "(" +
                    COLUMN_LEVEL + " INTEGER, " +
                    COLUMN_CHARACTERTYPE + "TEXT," +
                    COLUMN_MONSTERSUSED + "TEXT," +
                    COLUMN_CHARACTERSCOMPLETED + "TEXT," +
                    COLUMN_MUSICSELECTION + "TEXT," +
                    COLUMN_VOLUMECONTROL + "REAL," +
                    COLUMN_HAPTIC + "INTEGER," + ");";

    public static final String SQL_DELETE = "DROP TABLE" + TABLE_GAMESAVE;
}
