package kaishdliad; // Add this line to declare the package
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