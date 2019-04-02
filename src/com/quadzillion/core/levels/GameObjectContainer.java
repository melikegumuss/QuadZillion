package com.quadzillion.core.levels;

import com.quadzillion.core.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class GameObjectContainer
{
    public interface LevelInitListener
    {
        void onLevelInit(LevelContainer c);
    }

    public class LevelContainer
    {
        public List<Piece> pieces;
        // public List<Board> boards;
        // TODO: implement Board class later & add it to rendering stuff

        public LevelContainer()
        {
            pieces = new ArrayList<>();
        }
    }

    private LevelContainer container;

    public GameObjectContainer(LevelInitListener onInit)
    {
        container = new LevelContainer();
        onInit.onLevelInit(container);
    }

    public LevelContainer getContainer()
    {
        return container;
    }
}
