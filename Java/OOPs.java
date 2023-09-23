public class OOPs{
    public static void main(String args[]){
        Vehicle car=new Vehicle();
        // car.color="Red";
        // car.wheels=4;
        // car.headLights=2;
        // car.move();
        // car.description();
        // car.stop();
        // car.description();
        car.move();
        car.stop();
        car.description();


    }
}
class Vehicle{
    int wheels,headLights;
    String color;
    boolean isRest=true;
    Vehicle(){
        this.wheels=4;
        this.headLights=1;
        this.color="White";
        System.out.println("Vehicle Object Is Created:");
        System.out.println("------------Default Description--------");
        this.description();
    }
    public void move(){
        System.out.println("Vehicle Is Moving.");
        this.isRest=false;

    }
    public void stop(){
        System.out.println("Vehicle Is Stopped.");
        this.isRest=true;
    }
    public void isRest(){
        System.out.println(this.isRest);
    }
    public void description(){
        System.out.println("Vehicle has "+this.wheels+" Wheels");
        System.out.println("Vehicle has "+this.headLights+" Headlights");
        System.out.println("Vehicle has "+this.color+" Color");
        if (this.isRest){
            System.out.println("Vehicle is At Rest.");
        }
        else{
            System.out.println("Vehicle IS In Moving State.");
        }
    }



}