package com.quadzillion.core.models;

public class Constants {
    public final static int TILE_SIZE = 40;

    public final static int MAINBOARD_X_LAYOUT = 350;
    public final static int MAINBOARD_Y_LAYOUT = 30;

    public final static int COLUMN_NO = 16;

    public final static int[][] INIT_LOCATION = {{Constants.MAINBOARD_X_LAYOUT - 7 * Constants.TILE_SIZE + 10, Constants.MAINBOARD_Y_LAYOUT + 70},
            {Constants.MAINBOARD_X_LAYOUT - 3 * Constants.TILE_SIZE, Constants.MAINBOARD_Y_LAYOUT},
            {Constants.MAINBOARD_X_LAYOUT - 7 * Constants.TILE_SIZE, Constants.MAINBOARD_Y_LAYOUT + 5 * Constants.TILE_SIZE},
            {Constants.MAINBOARD_X_LAYOUT - 3 * Constants.TILE_SIZE, Constants.MAINBOARD_Y_LAYOUT + 5 * Constants.TILE_SIZE},
            {Constants.MAINBOARD_X_LAYOUT - 7 * Constants.TILE_SIZE, Constants.MAINBOARD_Y_LAYOUT + 9 * Constants.TILE_SIZE},
            {Constants.MAINBOARD_X_LAYOUT - 3 * Constants.TILE_SIZE, Constants.MAINBOARD_Y_LAYOUT + 9 * Constants.TILE_SIZE},
            {Constants.MAINBOARD_X_LAYOUT - 7 * Constants.TILE_SIZE, Constants.MAINBOARD_Y_LAYOUT + 13 * Constants.TILE_SIZE},
            {Constants.MAINBOARD_X_LAYOUT - 4 * Constants.TILE_SIZE, Constants.MAINBOARD_Y_LAYOUT + 13 * Constants.TILE_SIZE},
            {Constants.MAINBOARD_X_LAYOUT + (Constants.COLUMN_NO + 1) * Constants.TILE_SIZE, Constants.MAINBOARD_Y_LAYOUT},
            {Constants.MAINBOARD_X_LAYOUT + (Constants.COLUMN_NO + 1) * Constants.TILE_SIZE, Constants.MAINBOARD_Y_LAYOUT + 4 * Constants.TILE_SIZE},
            {Constants.MAINBOARD_X_LAYOUT + (Constants.COLUMN_NO + 2) * Constants.TILE_SIZE, Constants.MAINBOARD_Y_LAYOUT + Constants.TILE_SIZE * 7},
            {Constants.MAINBOARD_X_LAYOUT - 3 * Constants.TILE_SIZE, Constants.MAINBOARD_Y_LAYOUT + 5 * Constants.TILE_SIZE}};

}
