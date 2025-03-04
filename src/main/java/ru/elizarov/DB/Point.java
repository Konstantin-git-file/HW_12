package ru.elizarov.DB;

public class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point fromString(String s) {
        s = s.replace("Point{x=", "").replace("}", "");
        String[] parts = s.split(", y=");
        return new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }

    @Override
    public String toString() {
        return "Point{x=" + x + ", y=" + y + "}";
    }
}