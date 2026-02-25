public class Gato extends Animal {


    public Gato(String name) {
        super(name); //Inicializa la clase padre, es Animal
    }

    @Override
    public void hacerSonido() {
        System.out.println(name+ " hace Miau");
    }
}