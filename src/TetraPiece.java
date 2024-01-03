public class TetraPiece {
    public enum type {
        S,
        O,
        Z,
        L,
        T,
        J,
        I,
        Y
    }

    int xPos = 4;
    int yPos = 0;
    type Type;
    int Rotation = 0;

    public TetraPiece(){
        float random = (float) Math.random();
             if (random < (1.0/8.0)) this.Type = type.S;
        else if (random < (2.0/8.0)) this.Type = type.O;
        else if (random < (3.0/8.0)) this.Type = type.Z;
        else if (random < (4.0/8.0)) this.Type = type.L;
        else if (random < (5.0/8.0)) this.Type = type.T;
        else if (random < (6.0/8.0)) this.Type = type.J;
        else if (random < (7.0/8.0)) this.Type = type.I;
        else this.Type = type.Y;
    }
}
