package task;

public enum Direction {
    North{
        public Vector2 move(Vector2 start, double distance) {
            return new Vector2(start.getX(), start.getY() - distance);
        }
    },
    West{
        public Vector2 move(Vector2 start, double distance) {
            return new Vector2(start.getX() - distance, start.getY());
        }
    },
    South{
        public Vector2 move(Vector2 start, double distance) {
            return new Vector2(start.getX(), start.getY() + distance);
        }
    },
    East{
        public Vector2 move(Vector2 start, double distance) {
            return new Vector2(start.getX() + distance, start.getY());
        }
    };

    public abstract Vector2 move(Vector2 start, double distance);
}
