public abstract class Persona {
    private String nombre, poder, debilidad, heroeoOvillano;
    private Integer fuerza,habilidadmental, habilidadfisica;
    private boolean tieneescuadron;

    public Persona(String nombre, String poder, String heroeoOvillano, String debilidad, int fuerza, int habilidadmental, int habilidadfisica) {
    this.nombre = nombre;
    this.poder = poder;
    this.heroeoOvillano=heroeoOvillano;
    this.debilidad=debilidad;
    this.fuerza=fuerza;
    this.habilidadmental=habilidadmental;
    this.habilidadfisica=habilidadfisica;
    }

    //GETTERS Y SETTERS DE CADA ATRIBUTO
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoder() {
        return poder;
    }
    public void setPoder(String poder) {
        this.poder = poder;
    }

    public String getDebilidad() {
        return debilidad;
    }
    public void setDebilidad(String debilidad) {
        this.debilidad = debilidad;
    }

    public String getHeroeoOvillano() {
        return heroeoOvillano;
    }

    public void setHeroeoOvillano(String heroeoOvillano) {
        this.heroeoOvillano = heroeoOvillano;
    }

    public Integer getFuerza() {
        return fuerza;
    }
    public void setFuerza(Integer fuerza) {
        this.fuerza = fuerza;
    }

    public Integer getHabilidadmental() {
        return habilidadmental;
    }
    public void setHabilidadmental(Integer habilidadmental) {
        this.habilidadmental = habilidadmental;
    }

    public Integer getHabilidadfisica() {
        return habilidadfisica;
    }
    public void setHabilidadfisica(Integer habilidadfisica) {
        this.habilidadfisica = habilidadfisica;
    }

    public boolean isTieneescuadron() {
        return tieneescuadron;
    }
    public void setTieneescuadron(boolean tieneescuadron) {
        this.tieneescuadron = tieneescuadron;
    }

    public abstract void finalchance(Persona p1, Persona p2);

    @Override
    public String toString() {
        return "Personas{" + "Nombre:" + nombre + ", Poder:" + poder + ", Tipo:" + heroeoOvillano + ", Debilidad:" + debilidad + ", Fuerza:" + fuerza + ", Habilidad Mental:" + habilidadmental + ", Habilidad Fisica:" + habilidadfisica + ", Escuadron:" + tieneescuadron + '}';
    }

}
