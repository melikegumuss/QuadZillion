package com.quadzillion.gui.controller;

import com.quadzillion.core.ExtendedGamePane;
import com.quadzillion.core.GamePane;
import com.quadzillion.core.PuzzleGamePane;
import com.quadzillion.core.levels.ExtendedLevel;
import com.quadzillion.core.levels.Level;
import com.quadzillion.core.levels.Level7;
import com.quadzillion.core.levels.PuzzleLevel;
import com.quadzillion.core.levels.extendedLevel.*;
import com.quadzillion.core.levels.puzzleLevels.*;
import com.quadzillion.gui.GameApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("unused")
public class Util
{
    public static final String THEME_VANILLA        = "default";
    public static final String THEME_DARK           = "dark";
    public static final String THEME_EXOTIC         = "exotic";

    public static final String SCENE_MAIN_MENU      = "main_menu";
    public static final String SCENE_CREDITS        = "credits";
    //public static final String SCENE_LEVELS         = "levels";
    public static final String SCENE_MODES          = "modes";
    public static final String SCENE_PLAY_GAME      = "play";
    public static final String SCENE_SETTINGS       = "settings";
    public static final String SCENE_HOW_TO_PLAY    = "how_to_play";
    public static final String SCENE_END_GAME       = "endGame";
    public static final String SCENE_VANILLA_LEVELS = "vanilla_levels";
    public static final String SCENE_PUZZLE_LEVELS  = "puzzle_levels";
    public static final String SCENE_EXTENDED_LEVELS= "extended_levels";
    private static final HashMap<String, Pair<Scene, Controllable>> loadedScenes = new HashMap<>();
    private static String current = SCENE_MAIN_MENU;


    private static Scene gameScene;
    public static ArrayList<Level> vanillaLevels;
    static GamePane vanillaGamePane;

    public static ArrayList<PuzzleLevel> puzzleLevels;
    static PuzzleGamePane puzzleGamePane;


    public static ArrayList<ExtendedLevel> extendedLevels;
    static ExtendedGamePane extendedGamePane;

    public static int currentLevel = 0;
    public static int mode = 1;

    public static void loadVanillaGameScene(ArrayList<Level> lvls)
    {
        vanillaLevels = lvls;
        loadScene(SCENE_PLAY_GAME);
        gameScene = getScene(SCENE_PLAY_GAME);
    }


    public static void addVanillaGamePane()
    {
        vanillaGamePane = new GamePane(vanillaLevels.get(currentLevel));
        ((Pane)((AnchorPane)gameScene.getRoot()).getChildren().get(0)).getChildren().add(vanillaGamePane);
    }

    public static void removeVanillaChildren()
    {
        ((Pane)((AnchorPane)getScene(SCENE_PLAY_GAME).getRoot()).getChildren().get(0)).getChildren().removeAll(vanillaGamePane);
    }


    public static void loadExtendedGameScene(ArrayList<ExtendedLevel> lvls)
    {
        extendedLevels = lvls;
        loadScene(SCENE_PLAY_GAME);
        gameScene = getScene(SCENE_PLAY_GAME);
    }


    public static void addExtendedGamePane()
    {
        extendedGamePane = new ExtendedGamePane( extendedLevels.get(currentLevel));
        ((Pane)((AnchorPane)gameScene.getRoot()).getChildren().get(0)).getChildren().add(extendedGamePane);
    }

    public static void removeExtendedChildren()
    {
        ((Pane)((AnchorPane)getScene(SCENE_PLAY_GAME).getRoot()).getChildren().get(0)).getChildren().removeAll(extendedGamePane);
    }



    public static void loadPuzzleGameScene(ArrayList<PuzzleLevel> lvls)
    {
        puzzleLevels = lvls;
        loadScene(SCENE_PLAY_GAME);
        gameScene = getScene(SCENE_PLAY_GAME);
    }


    public static void addPuzzleGamePanel()
    {
        puzzleGamePane = new PuzzleGamePane(puzzleLevels.get(currentLevel));
        ((Pane)((AnchorPane)gameScene.getRoot()).getChildren().get(0)).getChildren().add(puzzleGamePane);
    }

    public static void removePuzzleChildren()
    {
        ((Pane)((AnchorPane)getScene(SCENE_PLAY_GAME).getRoot()).getChildren().get(0)).getChildren().removeAll(puzzleGamePane);
    }



    public static void loadScene(String name)
    {
        try
        {
            String fullPath = "./resources/layout/" + name + ".fxml";
            FXMLLoader loader = new FXMLLoader(GameApplication.class.getResource(fullPath));

            Parent root = loader.load();
            Scene scene = new Scene(loader.getRoot(), 1280, 720);

            loadedScenes.put(name, new Pair<>(scene, loader.getController()));
            scene.setOnKeyPressed(e->{
                if(e.getCode() == KeyCode.ESCAPE){
                    ((MainMenuController)Util.getSceneController(Util.SCENE_MAIN_MENU)).onQuitButtonClicked();
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void applyTheme(String name)
    {
        String path = GameApplication.class.getResource("./resources/themes/" + name + "/theme.css").toExternalForm();

        for (HashMap.Entry<String, Pair<Scene, Controllable>> entry : loadedScenes.entrySet())
        {
            entry.getValue().getKey().getStylesheets().clear();
            entry.getValue().getKey().getStylesheets().add(path);
            entry.getValue().getValue().onThemeChange();
        }
    }

    public static void setScene(String name)
    {
        // Maybe add transition effects ??
        loadedScenes.get(name).getValue().onDestroy();
        loadedScenes.get(name).getKey().getRoot().setDisable(true);
        current = name;
        loadedScenes.get(name).getKey().getRoot().setDisable(false);
        GameApplication.getStage().setScene(loadedScenes.get(name).getKey());
        loadedScenes.get(name).getValue().onCreate();
    }

    public static Scene getCurrentScene()
    {
        return loadedScenes.get(current).getKey();
    }

    public static Scene getScene(String name)
    {
        return loadedScenes.get(name).getKey();
    }

    public static Controllable getSceneController(String name)
    {
        return loadedScenes.get(name).getValue();
    }

    public static String getCurrentSceneName()
    {
        return current;
    }

    // ADDITIONAL

    public static String getMusicPath()
    {
        return GameApplication.class.getResource("./resources/sounds/herbal.mp3").toExternalForm();
    }

    public static String getMusicPathCredits()
    {
        return GameApplication.class.getResource("./resources/sounds/creditsSong.mp3").toExternalForm();
    }

    public static String getVideoPath()
    {
        return GameApplication.class.getResource("./resources/sounds/tutorialVideo.mp4").toExternalForm();
    }

    public static String getEndGamePath()
    {
        return GameApplication.class.getResource("./resources/images/127-512.jpeg").toExternalForm();
    }
}
