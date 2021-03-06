package fr.dauphine.javaavance.td1;

import java.util.Objects;

public class Circle {
    private int radius;
    private Point center;

    public Circle(Point centerOftheCirle, int radiusOfTheCircle){
        this.radius = radiusOfTheCircle;
        this.center = centerOftheCirle;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }
    public Circle translate(int dx, int dy){
         center = center.translate(dx, dy);
         Circle newCercle = new Circle(center, radius);
            return  newCercle;
    }
    public double area(){
        return Math.pow((double) radius, 2) * Math.PI;
    }
    public boolean contains(Point p){
        //Calcul de la distance avec Pythagore
        double distance = Math.sqrt((double) Math.pow(center.getX() - p.getX(),2) + (double) Math.pow(center.getY() - p.getY(),2));
        System.out.println(distance);
        return distance <= radius;
    }
//    public boolean contains(Point p, Circle...circles){
//        boolean isPresent = false;
//        if(circles == null)
//            return isPresent;
//        else {
//            for (Circle circle : circles) {
//                if(circle.contains(p))
//                    isPresent = true;
//            }
//        }
//        return  isPresent;
//    }

        public static boolean contains(Point p, Circle...circles){
        boolean isPresent = false;
        if(circles == null)
            return isPresent;
        else {
            for (Circle circle : circles) {
                if(circle.contains(p))
                    isPresent = true;
            }
        }
        return  isPresent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return getRadius() == circle.getRadius() && Objects.equals(getCenter(), circle.getCenter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRadius(), getCenter());
    }
}
