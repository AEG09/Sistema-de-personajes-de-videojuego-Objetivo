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