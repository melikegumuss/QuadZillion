package com.quadzillion.gui.controller;

import com.quadzillion.core.GamePane;
import com.quadzillion.core.PuzzleGamePane;
import com.quadzillion.core.levels.Level;
import com.quadzillion.gui.GameApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Pair;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    public static final String SCENE_LEVELS         = "levels";
    public static final String SCENE_PLAY_GAME      = "play";
    public static final String SCENE_SETTINGS       = "settings";
    public static final String SCENE_HOW_TO_PLAY    = "how_to_play";
    public static final String SCENE_END_GAME       = "endGame";

    private static final HashMap<String, Pair<Scene, Controllable>> loadedScenes = new HashMap<>();
    private static String current = SCENE_MAIN_MENU;


    private static Scene gameScene;
    public static ArrayList<Level> levels;
    static PuzzleGamePane gamePane;

    public static void loadGameScene(ArrayList<Level> lvls)
    {
        levels = lvls;
        loadScene(SCENE_PLAY_GAME);
        gameScene = getScene(SCENE_PLAY_GAME);
    }

    public static void addGamePanel()
    {
        gamePane = new PuzzleGamePane(levels.get(LevelsController.level));
        ((Pane)((AnchorPane)gameScene.getRoot()).getChildren().get(0)).getChildren().add(gamePane);
    }

    public static void removeChildren()
    {
        ((Pane)((AnchorPane)getScene(SCENE_PLAY_GAME).getRoot()).getChildren().get(0)).getChildren().removeAll(gamePane);
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
