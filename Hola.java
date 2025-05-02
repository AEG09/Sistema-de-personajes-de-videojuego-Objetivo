package kaishdliad; 
import java.util.ArrayList;

interface Curable {
    void curar();
}

interface Volador {
    void volar();
}

interface Magico {
    void lanzarHechizo();
}

interface Defendible {
    void defender();
}

interface Movilizable {
    void moverse();
}

// Clase abstracta base
abstract class Personaje {
    protected String nombre;
    protected int nivel;
    protected int salud;

    public Personaje(String nombre, int nivel, int salud) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
    }

    public abstract void atacar();

    @Override
    public String toString() {
        return nombre + " (Nivel: " + nivel + ", Salud: " + salud + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Personaje otro = (Personaje) obj;
        return nombre.equals(otro.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}

// Subclase abstracta - Combate físico
abstract class PersonajeFisico extends Personaje {
    public PersonajeFisico(String nombre, int nivel, int salud) {
        super(nombre, nivel, salud);
    }

    public void entrenar() {
        System.out.println(nombre + " entrena para mejorar su fuerza.");
    }
}

// Subclase abstracta - Mágico
abstract class PersonajeMagico extends Personaje {
    public PersonajeMagico(String nombre, int nivel, int salud) {
        super(nombre, nivel, salud);
    }

    public void meditar() {
        System.out.println(nombre + " medita para aumentar su poder mágico.");
    }
}
class Hechicero extends PersonajeMagico implements Magico, Defendible {
    private int mana, concentracion;

    public Hechicero(String nombre, int nivel, int salud, int mana, int concentracion) {
        super(nombre, nivel, salud);
        this.mana = mana;
        this.concentracion = concentracion;
    }

    public void invocarEntidad() {
        System.out.println(nombre + " invoca una entidad mágica.");
    }

    @Override
    public void atacar() {
        invocarEntidad();
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " lanza un hechizo ancestral.");
    }

    @Override
    public void defender() {
        System.out.println(nombre + " genera un escudo mágico para defenderse.");
    }
}

class Asesino extends PersonajeFisico implements Movilizable, Curable {
    private int sigilo, critico;

    public Asesino(String nombre, int nivel, int salud, int sigilo, int critico) {
        super(nombre, nivel, salud);
        this.sigilo = sigilo;
        this.critico = critico;
    }

    public void atacarPorLaEspalda() {
        System.out.println(nombre + " ataca por la espalda con sigilo.");
    }

    public void ocultar() {
        System.out.println(nombre + " se oculta en las sombras.");
    }

    @Override
    public void atacar() {
        atacarPorLaEspalda();
    }

    @Override
    public void moverse() {
        System.out.println(nombre + " se mueve sigilosamente.");
    }

    @Override
    public void curar() {
        System.out.println(nombre + " utiliza un ungüento para curarse.");
    }
}

class Guerrero extends PersonajeFisico implements Defendible {
    private int fuerza, armadura, escudo;

    public Guerrero(String nombre, int nivel, int salud, int fuerza, int armadura, int escudo) {
        super(nombre, nivel, salud);
        this.fuerza = fuerza;
        this.armadura = armadura;
        this.escudo = escudo;
    }

    public void cargarAtaque() {
        System.out.println(nombre + " carga un poderoso ataque");
    }

    @Override
    public void atacar() {
        cargarAtaque();
    }

    @Override
    public void defender() {
        System.out.println(nombre + " se defiende con su escudo.");
    }
}

class Mago extends PersonajeMagico implements Magico, Curable {
    private int mana, sabiduria;

    public Mago(String nombre, int nivel, int salud, int mana, int sabiduria) {
        super(nombre, nivel, salud);
        this.mana = mana;
        this.sabiduria = sabiduria;
    }

    public void regenerarMana() {
        System.out.println(nombre + " regenera su maná.");
    }

    @Override
    public void atacar() {
        lanzarHechizo();
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " lanza un hechizo con fuego abrasador.");
    }

    @Override
    public void curar() {
        System.out.println(nombre + " lanza un hechizo de curación.");
    }
}

class Arquero extends PersonajeFisico implements Volador {
    private int agilidad, numFlechas;

    public Arquero(String nombre, int nivel, int salud, int agilidad, int numFlechas) {
        super(nombre, nivel, salud);
        this.agilidad = agilidad;
        this.numFlechas = numFlechas;
    }

    public void dispararFlecha() {
        System.out.println(nombre + " dispara una flecha");
    }

    public void reabastecerFlechas() {
        System.out.println(nombre + " recarga su carcaj.");
    }

    @Override
    public void atacar() {
        dispararFlecha();
    }

    @Override
    public void volar() {
        System.out.println(nombre + " puede volar.");
    }
}

class Juego {
    private ArrayList<Personaje> personajes = new ArrayList<>();

    public void agregarPersonaje(Personaje p) {
        personajes.add(p);
    }

    public void mostrarAcciones() {
        for (Personaje p : personajes) {
            System.out.println(p);
            p.atacar();
            if (p instanceof Curable) ((Curable) p).curar();
            if (p instanceof Volador) ((Volador) p).volar();
            if (p instanceof Magico) ((Magico) p).lanzarHechizo();
            if (p instanceof Defendible) ((Defendible) p).defender();
            if (p instanceof Movilizable) ((Movilizable) p).moverse();
            System.out.println();
        }
    }
}

public class Hola { 
    public static void main(String[] args) {
        Juego juego = new Juego();

        juego.agregarPersonaje(new Guerrero("Tung Tung Tung Tung Tung Sahur", 69, 20, 90, 70, 50));
        juego.agregarPersonaje(new Mago("Brim Brim Patapim", 12, 100, 120, 95));
        juego.agregarPersonaje(new Arquero("Bombardiro Crocodilo", 9, 110, 50, 30));
        juego.agregarPersonaje(new Hechicero("Lirili Larila", 11, 22, 100, 90));
        juego.agregarPersonaje(new Asesino("Capuchino Assasino", 60, 20, 99, 80));

        juego.mostrarAcciones(); 
    }
}


