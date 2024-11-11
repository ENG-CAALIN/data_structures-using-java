package bilow;

import java.awt.*;

public class Book {


    Point center;
    double radius;

    Book(){

    }
    Book (Point center,double radius  ){
        this.center=center;
        this.radius=radius;


    }

    double getMrameter(){
     return  2*Math.PI * this.radius;

    }

    double getRadius(){
        return Math.PI *this.radius*this.radius;


    }
     public void get( double radius){
        this.radius =radius;
    }


}