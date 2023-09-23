public class Shapes {
    public static void main(String args[]){
        // Circle c1=new Circle(5);
        // float ar1=c1.area();
        // float pm1=c1.perimeter();
        // System.out.println("---------Circle Area, Circumference--------");
        // System.out.println("Area = "+ar1);
        // System.out.println("Circumference = "+pm1);
        // System.out.println("---------Through Class---------");
        // c1.description();
        
        Rectangle r1=new Rectangle(3,4);
        r1.description();
        Rectangle r2=new Rectangle();
        r2.description();
        System.out.println(r1);
    }
    
    
}
class Circle{
    float radius;
    Circle(int r){
        this.radius=r;
    }
    public float area(){
        return 3.14f*(this.radius)*(this.radius);
    }
    public float perimeter(){
        return 2.0f*3.14f*this.radius;
    }
    public void description(){
        System.out.println("Radius = "+this.radius);
        System.out.println("Circumference = "+this.perimeter());
        System.out.println("Area= "+this.area());
        
    }


}
class Rectangle{
    int len,breadth;
    int area,perimeter;
    Rectangle(int l,int b){
        this.len=l;
        this.breadth=b;

    }
    Rectangle(){
        this.len=1;
        this.breadth=1;

    }
    public int area(){
        return this.len*this.breadth;
    }
    public int perimeter(){
        return 2*(this.len+this.breadth);
    }
    public void description(){

        System.out.println("Length = "+this.len);
        System.out.println("Breadth = "+this.breadth);
        System.out.println("Area = "+this.area()+" sq unit");
        System.out.println(this+"Perimeter= = "+this.perimeter());

    }
   

    }

