import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        Movimiento_Tipo A = new Movimiento_Tipo(1000,"Interbancario");
        Usuario n1 = new Usuario(2,23,"ramirez@gmail.com","Jose","Misajel","938 100 919");


        System.out.println("--------------------------------------------------------");
        System.out.println("La id del tipo de movimiento A es:"+A.getId());
        System.out.println("El nombre del tipo de movimiento A es:"+A.getNombre());
        System.out.println("--------------------------------------------------------");

        System.out.println("--------------------------------------------------------");
        System.out.println("La id del usuario n1 es:"+n1.getId());
        System.out.println("El nombre del tipo de usuario n1 es:"+n1.getActivo());
        System.out.println("El correo del usuario n1 es:"+n1.getCorreo());
        System.out.println("El nombre del usuario n1 es:"+n1.getNombre());
        System.out.println("El apellido del usuario n1 es:"+n1.getApellido());
        System.out.println("El numero del usuario n1 es:"+n1.getTelefono());
        System.out.println("--------------------------------------------------------");

    }
}
