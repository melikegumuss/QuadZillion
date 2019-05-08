package com.quadzillion.gui;

import com.quadzillion.core.levels.*;
import com.quadzillion.core.levels.extendedLevel.eLevel1;
import com.quadzillion.core.levels.extendedLevel.eLevel2;
import com.quadzillion.core.levels.puzzleLevels.pLevel1;
import com.quadzillion.core.levels.puzzleLevels.pLevel2;
import com.quadzillion.core.levels.puzzleLevels.pLevel3;
import com.quadzillion.gui.controller.MainMenuController;
import com.quadzillion.gui.controller.Util;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;


public class GameApplication extends Application {
    private static GameApplication instance;
    private static Stage primaryStage;

    private Scene sceneMainMenu;

    public static Stage getStage() {
        return primaryStage;
    }

    public static GameApplication getInstance() {
        return instance;
    }

    private MainMenuController mc;

    @Override
    public void start(Stage stage) throws Exception {
        GameApplication.instance = this;
        primaryStage = stage;

        ArrayList<Level> levelList = new ArrayList<>();

        levelList.add(new Level1());

        levelList.add(new Level2());

        levelList.add(new Level3());

        levelList.add(new Level4());

        levelList.add(new Level5());

        levelList.add(new Level6());

        levelList.add(new Level7());

        ArrayList<PuzzleLevel> puzzleLevels = new ArrayList<>();

        puzzleLevels.add(new pLevel1());
        puzzleLevels.add(new pLevel2());
        puzzleLevels.add(new pLevel3());

        ArrayList<ExtendedLevel> extendedLevels = new ArrayList<>();

        extendedLevels.add(new eLevel1());
        extendedLevels.add(new eLevel2());
        extendedLevels.add(new eLevel2());


        Util.loadScene(Util.SCENE_SETTINGS);
        Util.loadScene(Util.SCENE_MAIN_MENU);
        Util.loadScene(Util.SCENE_CREDITS);
        Util.loadVanillaGameScene(levelList);
        Util.loadPuzzleGameScene(puzzleLevels);
        Util.loadExtendedGameScene(extendedLevels);

        Util.loadScene(Util.SCENE_HOW_TO_PLAY);
        Util.loadScene(Util.SCENE_MODES);
        Util.loadScene(Util.SCENE_EXTENDED_LEVELS);
        Util.loadScene(Util.SCENE_PUZZLE_LEVELS);
        Util.loadScene(Util.SCENE_VANILLA_LEVELS);
        Util.setScene(Util.SCENE_MAIN_MENU);
        Util.applyTheme(Util.THEME_VANILLA);

        primaryStage.setTitle("QuadZillion");
        primaryStage.setOnCloseRequest(
                e -> ((MainMenuController) Util.getSceneController(Util.SCENE_MAIN_MENU)).onQuitButtonClicked());
        primaryStage.show();

    }
}
