
public class exp  {
    public static void main(String[] args){
        A obj =new A();
        obj.B();
        obj.C();
        obj.D();
        obj.E();
        // obj.F();
        obj.G();
        obj.H();
        Private p=new Private();
        System.out.println(p.pswd);

    }
    static class A{
        private String password="Tigeramit123&";
        A(){
            System.out.println("Object IS Created;");
            // this.B();
            // this.C();
            // this.D();
            // this.E();
            // this.F();
            // // this.G();
            // this.H();


        }
        public void B(){
            System.out.println("Inside Public");
        }
        void C(){
            System.out.println("Inside No Access Identifier:");
        }
        public static void D(){
            System.out.println("public Static Access Modifier:");

        }
        static void E(){
            System.out.println("Static Access Modifier:");
        }
        // private void F(){
        //     System.out.println("Private Access Modifier:");
        
        private void G(){
            System.out.println("Private Access Modifier:");
        }
        protected void H(){
            System.out.println(this.password);
        }




    }
}
