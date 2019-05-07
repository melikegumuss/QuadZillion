package com.quadzillion.core.levels;

import java.util.ArrayList;

public class PuzzleLevel extends Level{

    public int [][] solution;
    public String fileName;

    public  PuzzleLevel()
    {

    }

    public String getFileName() {
        return fileName;
    }


    public ArrayList<String> forbiddenUrls()
    {
        ArrayList<String> urls = new ArrayList<>();

        for (int j = 0; j < 4; j++) {
              for (int i = 0; i < 4; i++) {
                 if( solution[j][i] == 2)
                      urls.add("com/quadzillion/gui/resources/images/puzzleLevels/"+ fileName +"/" + j + i + ".jpg");
            }
        }


        for (int j = 0; j < 4; j++) {
            for  (int i = 4; i < 8; i++){
                if (solution[j][i] == 2)
                    urls.add("com/quadzillion/gui/resources/images/puzzleLevels/" + fileName + "/" + j + i + ".jpg");
            }
        }


        for (int j = 4; j < 8; j++) {
            for (int i = 0; i < 4; i++) {
                if (solution[j][i] == 2)
                    urls.add("com/quadzillion/gui/resources/images/puzzleLevels/" + fileName + "/" + j + i + ".jpg");
            }
        }

        for(int j = 4; j < 8; j++)  {
            for (int i = 4; i < 8; i++)  {
                if (solution[j][i] == 2)
                    urls.add("com/quadzillion/gui/resources/images/puzzleLevels/" + fileName + "/" + j + i + ".jpg");
            }
        }

        return urls;
    }



}
