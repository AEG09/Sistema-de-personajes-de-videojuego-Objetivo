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
        System.out.println(nombre + " entrena para aumentar su fuerza.");
    }
}

// Subclase abstracta - Mágico
abstract class PersonajeMagico extends Personaje {
    public PersonajeMagico(String nombre, int nivel, int salud) {
        super(nombre, nivel, salud);
    }

    public void meditar() {
        System.out.println(nombre + " medita para aumentar su poder");
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
        System.out.println(nombre + " carga un poderoso ataque ");
    }

    @Override
    public void atacar() {
        cargarAtaque();
    }

    @Override
    public void defender() {
        System.out.println(nombre + " se defiende con el escudo.");
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
        System.out.println(nombre + " lanza un hechizo con fuego abrasador");
    }

    @Override
    public void curar() {
        System.out.println(nombre + " lanza un hechizo para curarse.");
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
        System.out.println(nombre + " recarga su carcaj");
    }

    @Override
    public void atacar() {
        dispararFlecha();
    }

    @Override
    public void volar() {
        System.out.println(nombre + " es capaz de volar");
    }
}

