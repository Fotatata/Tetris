import javax.swing.*;

public class BackEnd {
    static boolean[][] map = new boolean[10][20];

    public static void main(String[] args) {
        TetraPiece piece = new TetraPiece();
        FrontEnd colorPiece = new FrontEnd(piece);
        SwingUtilities.invokeLater(() -> colorPiece.setVisible(true));
    }

    public static TetraPiece NewPiece(TetraPiece piece) {
        switch (piece.Type) {
            case I -> {
                if (piece.Rotation % 2 == 0) {
                    if (piece.yPos == 16 ||
                            map[piece.xPos][piece.yPos + 4]) {
                        map[piece.xPos][piece.yPos] = true;
                        map[piece.xPos][piece.yPos + 1] = true;
                        map[piece.xPos][piece.yPos + 2] = true;
                        map[piece.xPos][piece.yPos + 3] = true;
                        return new TetraPiece();
                    }
                } else {
                    if (piece.yPos == 19 ||
                            map[piece.xPos][piece.yPos + 1] ||
                            map[piece.xPos + 1][piece.yPos + 1] ||
                            map[piece.xPos + 2][piece.yPos + 1] ||
                            map[piece.xPos + 3][piece.yPos + 1]) {
                        map[piece.xPos][piece.yPos] = true;
                        map[piece.xPos + 1][piece.yPos] = true;
                        map[piece.xPos + 2][piece.yPos] = true;
                        map[piece.xPos + 3][piece.yPos] = true;
                        return new TetraPiece();
                    }
                }
            }
            case J -> {
                switch (piece.Rotation % 4) {
                    case 0 -> {
                        if (piece.yPos == 17 ||
                                map[piece.xPos][piece.yPos + 3] ||
                                map[piece.xPos + 1][piece.yPos + 3]) {
                            map[piece.xPos + 1][piece.yPos] = true;
                            map[piece.xPos + 1][piece.yPos + 1] = true;
                            map[piece.xPos][piece.yPos + 2] = true;
                            map[piece.xPos + 1][piece.yPos + 2] = true;
                            return new TetraPiece();
                        }
                    }
                    case 1, -3 -> {
                        if (piece.yPos == 18 ||
                                map[piece.xPos][piece.yPos + 1] ||
                                map[piece.xPos + 1][piece.yPos + 1] ||
                                map[piece.xPos + 2][piece.yPos + 2]) {
                            map[piece.xPos][piece.yPos] = true;
                            map[piece.xPos + 1][piece.yPos] = true;
                            map[piece.xPos + 2][piece.yPos] = true;
                            map[piece.xPos + 2][piece.yPos + 1] = true;
                            return new TetraPiece();
                        }
                    }
                    case 2, -2 -> {
                        if (piece.yPos == 17 ||
                                map[piece.xPos][piece.yPos + 3] ||
                                map[piece.xPos + 1][piece.yPos + 1]) {
                            map[piece.xPos][piece.yPos] = true;
                            map[piece.xPos + 1][piece.yPos] = true;
                            map[piece.xPos][piece.yPos + 1] = true;
                            map[piece.xPos][piece.yPos + 2] = true;
                            return new TetraPiece();
                        }
                    }
                    case 3, -1 -> {
                        if (piece.yPos == 18 ||
                                map[piece.xPos][piece.yPos + 2] ||
                                map[piece.xPos + 1][piece.yPos + 2] ||
                                map[piece.xPos + 2][piece.yPos + 2]) {
                            map[piece.xPos][piece.yPos] = true;
                            map[piece.xPos][piece.yPos + 1] = true;
                            map[piece.xPos + 1][piece.yPos + 1] = true;
                            map[piece.xPos + 2][piece.yPos + 1] = true;
                            return new TetraPiece();
                        }
                    }
                }
            }
            case T -> {
                switch (piece.Rotation){
                    case 0 -> {
                        if (piece.yPos == 18 ||
                                map[piece.xPos][piece.yPos + 1] ||
                                map[piece.xPos + 1][piece.yPos + 2] ||
                                map[piece.xPos + 2][piece.yPos + 1]){
                            map[piece.xPos][piece.yPos] = true;
                            map[piece.xPos + 1][piece.yPos] = true;
                            map[piece.xPos + 2][piece.yPos] = true;
                            map[piece.xPos + 1][piece.yPos + 1] = true;
                            return new TetraPiece();
                        }
                    }
                    case 1, -3 -> {
                        if (piece.yPos == 17 ||
                                map[piece.xPos][piece.yPos + 3] ||
                                map[piece.xPos + 1][piece.yPos + 2]){
                            map[piece.xPos][piece.yPos] = true;
                            map[piece.xPos][piece.yPos + 1] = true;
                            map[piece.xPos][piece.yPos + 2] = true;
                            map[piece.xPos + 1][piece.yPos + 1] = true;
                            return new TetraPiece();
                        }
                    }
                    case 2, -2 -> {
                        if (piece.yPos == 18 ||
                                map[piece.xPos][piece.yPos + 2] ||
                                map[piece.xPos + 1][piece.yPos + 2] ||
                                map[piece.xPos + 2][piece.yPos + 2]){
                            map[piece.xPos][piece.yPos + 1] = true;
                            map[piece.xPos + 1][piece.yPos] = true;
                            map[piece.xPos + 1][piece.yPos + 1] = true;
                            map[piece.xPos + 2][piece.yPos + 1] = true;
                            return new TetraPiece();
                        }
                    }
                    case 3, -1 -> {
                        if (piece.yPos == 17 ||
                                map[piece.xPos][piece.yPos + 2] ||
                                map[piece.xPos +1][piece.yPos + 3]){
                            map[piece.xPos][piece.yPos + 1] = true;
                            map[piece.xPos + 1][piece.yPos] = true;
                            map[piece.xPos + 1][piece.yPos + 1] = true;
                            map[piece.xPos + 1][piece.yPos + 2] = true;
                            return new TetraPiece();
                        }
                    }
                }
            }
            case L -> {
                switch (piece.Rotation % 4){
                    case 0 -> {
                        if (piece.yPos == 17 ||
                                map[piece.xPos][piece.yPos + 3] ||
                                map[piece.xPos + 1][piece.yPos + 3]) {
                            map[piece.xPos][piece.yPos] = true;
                            map[piece.xPos + 1][piece.yPos + 2] = true;
                            map[piece.xPos][piece.yPos + 1] = true;
                            map[piece.xPos][piece.yPos + 2] = true;
                            return new TetraPiece();
                        }
                    }
                    case 1, -3 -> {
                        if (piece.yPos == 18 ||
                                map[piece.xPos][piece.yPos + 2] ||
                                map[piece.xPos + 1][piece.yPos + 2] ||
                                map[piece.xPos + 2][piece.yPos + 2]) {
                            map[piece.xPos + 2][piece.yPos] = true;
                            map[piece.xPos][piece.yPos + 1] = true;
                            map[piece.xPos + 1][piece.yPos + 1] = true;
                            map[piece.xPos + 2][piece.yPos + 1] = true;
                            return new TetraPiece();
                        }
                    }
                    case 2, -2 ->{
                        if (piece.yPos == 17 ||
                                map[piece.xPos][piece.yPos + 1] ||
                                map[piece.xPos + 1][piece.yPos + 3]) {
                            map[piece.xPos + 1][piece.yPos] = true;
                            map[piece.xPos + 1][piece.yPos + 1] = true;
                            map[piece.xPos][piece.yPos] = true;
                            map[piece.xPos + 1][piece.yPos + 2] = true;
                            return new TetraPiece();
                        }
                    }
                    case 3, -1 -> {
                        if (piece.yPos == 18 ||
                                map[piece.xPos][piece.yPos + 2] ||
                                map[piece.xPos + 1][piece.yPos + 1] ||
                                map[piece.xPos + 2][piece.yPos + 1]) {
                            map[piece.xPos][piece.yPos] = true;
                            map[piece.xPos + 1][piece.yPos] = true;
                            map[piece.xPos + 2][piece.yPos] = true;
                            map[piece.xPos][piece.yPos + 1] = true;
                            return new TetraPiece();
                        }
                    }
                }
            }
            case S -> {
                if (piece.Rotation % 2 == 0){
                    if (piece.yPos == 18 ||
                            map[piece.xPos][piece.yPos + 2] ||
                            map[piece.xPos + 1][piece.yPos + 2] ||
                            map[piece.xPos + 2][piece.yPos + 1]){
                        map[piece.xPos][piece.yPos + 1] = true;
                        map[piece.xPos + 1][piece.yPos] = true;
                        map[piece.xPos + 1][piece.yPos + 1] = true;
                        map[piece.xPos + 2][piece.yPos] = true;
                        return new TetraPiece();
                    }
                }else{
                    if (piece.yPos == 17 ||
                            map[piece.xPos][piece.yPos + 2] ||
                            map[piece.xPos + 1][piece.yPos + 3]){
                        map[piece.xPos][piece.yPos] = true;
                        map[piece.xPos][piece.yPos + 1] = true;
                        map[piece.xPos + 1][piece.yPos + 1] = true;
                        map[piece.xPos + 1][piece.yPos + 2] = true;
                        return new TetraPiece();
                    }
                }
            }
            case O -> {
                if (piece.yPos == 18 ||
                        map[piece.xPos][piece.yPos + 2] ||
                        map[piece.xPos + 1][piece.yPos + 2]){
                    map[piece.xPos][piece.yPos] = true;
                    map[piece.xPos + 1][piece.yPos] = true;
                    map[piece.xPos][piece.yPos + 1] = true;
                    map[piece.xPos + 1][piece.yPos + 1] = true;
                    return new TetraPiece();
                }
            }
            case Z -> {
                if (piece.Rotation % 2 == 0){
                    if (piece.yPos == 18 ||
                            map[piece.xPos][piece.yPos + 1] ||
                            map[piece.xPos + 1][piece.yPos + 2] ||
                            map[piece.xPos + 2][piece.yPos + 2]){
                        map[piece.xPos][piece.yPos] = true;
                        map[piece.xPos + 1][piece.yPos] = true;
                        map[piece.xPos + 1][piece.yPos + 1] = true;
                        map[piece.xPos + 2][piece.yPos + 1] = true;
                        return new TetraPiece();
                    }
                }else{
                    if (piece.yPos == 17 ||
                            map[piece.xPos][piece.yPos + 3] ||
                            map[piece.xPos + 1][piece.yPos + 2]){
                        map[piece.xPos + 1][piece.yPos] = true;
                        map[piece.xPos][piece.yPos + 1] = true;
                        map[piece.xPos + 1][piece.yPos + 1] = true;
                        map[piece.xPos][piece.yPos + 2] = true;
                        return new TetraPiece();
                    }
                }
            }
            case Y -> {
                switch (piece.Rotation % 4){
                    case 0 -> {
                        if (piece.yPos == 17 ||
                                map[piece.xPos][piece.yPos + 1] ||
                                map[piece.xPos + 1][piece.yPos + 3] ||
                                map[piece.xPos + 2][piece.yPos + 1]){
                            map[piece.xPos][piece.yPos] = true;
                            map[piece.xPos + 1][piece.yPos + 1] = true;
                            map[piece.xPos + 1][piece.yPos + 2] = true;
                            map[piece.xPos + 2][piece.yPos] = true;
                            return new TetraPiece();
                        }
                    }
                    case 1,-3 -> {
                        if (piece.yPos == 17 ||
                                map[piece.xPos][piece.yPos + 3] ||
                                map[piece.xPos + 1][piece.yPos + 2] ||
                                map[piece.xPos + 2][piece.yPos + 2] ||
                                map[piece.xPos][piece.yPos + 1]){
                            map[piece.xPos][piece.yPos] = true;
                            map[piece.xPos][piece.yPos + 2] = true;
                            map[piece.xPos + 1][piece.yPos + 1] = true;
                            map[piece.xPos + 2][piece.yPos + 1] = true;
                            return new TetraPiece();
                        }
                    }
                    case 2,-2 -> {
                        if (piece.yPos == 17 ||
                                map[piece.xPos][piece.yPos + 3] ||
                                map[piece.xPos + 1][piece.yPos + 2] ||
                                map[piece.xPos + 2][piece.yPos + 3]){
                            map[piece.xPos][piece.yPos + 2] = true;
                            map[piece.xPos + 1][piece.yPos + 1] = true;
                            map[piece.xPos + 1][piece.yPos] = true;
                            map[piece.xPos + 2][piece.yPos + 2] = true;
                            return new TetraPiece();
                        }
                    }
                    case 3,-1 -> {
                        if (piece.yPos == 17 ||
                                map[piece.xPos + 2][piece.yPos + 3] ||
                                map[piece.xPos + 1][piece.yPos + 2] ||
                                map[piece.xPos][piece.yPos + 2] ||
                                map[piece.xPos + 2][piece.yPos + 1]){
                            map[piece.xPos][piece.yPos + 1] = true;
                            map[piece.xPos + 1][piece.yPos + 1] = true;
                            map[piece.xPos + 2][piece.yPos] = true;
                            map[piece.xPos + 2][piece.yPos + 2] = true;
                            return new TetraPiece();
                        }
                    }
                }
            }
        }
        return piece;
    }

    public static void DeleteLine() {
        for (int i = 1; i < 20; i++) {
            if (map[0][i] && map[1][i] && map[2][i] && map[3][i] && map[4][i] && map[5][i] && map[6][i] && map[7][i] && map[8][i] && map[9][i]){
                for (int j = 0; j < 10; j++) {
                    for (int k = i; k > 0; k--) {
                        map[j][k] = map[j][k - 1];
                    }
                }
            }
        }
    }

    public static boolean MoveRight(TetraPiece piece){
        switch (piece.Type) {
            case I -> {
                if (piece.Rotation % 2 == 0) {
                    if (piece.xPos < 9) {
                        return !(map[piece.xPos + 1][piece.yPos] ||
                                map[piece.xPos + 1][piece.yPos + 1] ||
                                map[piece.xPos + 1][piece.yPos + 2] ||
                                map[piece.xPos + 1][piece.yPos + 3]);
                    }
                    return false;
                } else {
                    if (map[piece.xPos + 4][piece.yPos]){
                        return false;
                    }
                    return piece.xPos < 6;
                }
            }
            case J -> {
                switch (piece.Rotation % 4){
                    case 0 -> {
                        return !(map[piece.xPos + 2][piece.yPos] ||
                                 map[piece.xPos + 2][piece.yPos + 1] ||
                                 map[piece.xPos + 2][piece.yPos + 2]);
                    }
                }
                if (piece.Rotation % 2 == 0) {
                    return piece.xPos < 8;
                } else {
                    return piece.xPos < 7;
                }
            }
            case L -> {
                if (piece.Rotation % 2 == 0) {
                    return piece.xPos < 8;
                } else {
                    return piece.xPos < 7;
                }
            }
            case T, S, Z -> {
                if (piece.Rotation % 2 == 0) return piece.xPos < 7;
                else return piece.xPos < 8;
            }
            case O -> {
                return piece.xPos < 8;
            }
            case Y -> {
                return piece.xPos < 7;
            }
        }
        return false;
    }
    public static boolean Rotate(TetraPiece piece){
        return !switch (piece.Type) {
            case I -> piece.Rotation % 2 != 0 || piece.xPos < 6;
            case J, L -> piece.Rotation % 2 != 0 || piece.xPos < 8;
            case T, S, Z -> piece.Rotation % 2 == 0 || piece.xPos < 8;
            case O, Y -> true;
        };
    }
}