package StreamsFilesAndDirectoriesLab;

import java.io.Serializable;

public class Cube implements Serializable {


        String cube;
        int width;
        int length;
        int depth;

        public Cube(String cube, int width, int length, int depth) {
            this.cube = cube;
            this.width = width;
            this.length = length;
            this.depth = depth;
        }
    }


