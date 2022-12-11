import java.util.ArrayList;
import java.util.Scanner;

public class Pelea {
    static Scanner leer = new Scanner(System.in).useDelimiter("\n");
    static ArrayList<Persona> villanos = new ArrayList();
    static ArrayList<Persona> heroes = new ArrayList();
    static ArrayList<Universo> universe = new ArrayList();
    static ArrayList<Escuadron> squad = new ArrayList();
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("----Beyonder----");
            System.out.println("[1] Opcion Universo" +
                    "\n[2] Opcion Escuadranos" +
                    "\n[3] Opcion Personajes" +
                    "\n[4] Salir");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    opcionUniverso();
                    break;

                case 2:
                    opcionEscuadron();
                    break;

                case 3:
                    opcionPersona();
                    break;

                case 4:
                    System.out.println("Ha salido del Programa");
                    break;

                default:
                    System.out.println("OPCION INVALIDA!!!");
                    break;
            }
        } while (opcion != 4);
    }
    public static void opcionUniverso() {
        int opcion;
        do {
            System.out.println("--Opcion Universo--");
            System.out.println("1. Crear" +
                    "\n2. Modificar" +
                    "\n3. Eliminar" +
                    "\n4. Listar Universos" +
                    "\n5. Salir");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    crearUniverso();
                    break;

                case 2:
                    ModificarUniverse();
                    break;

                case 3:
                    System.out.println("Ingrese la posicion del evento a editar: ");
                    int pos = leer.nextInt();
                    squad.remove(pos);
                    break;

                case 4:
                    for (Universo univer : universe) {
                        System.out.println(univer.toString() + "\n");
                    }
                    break;

                case 5:
                    System.out.println("Ha salido del Programa!!");
                    break;
            }
        } while (opcion != 5);
    }

    public static void opcionEscuadron() {
        int opcion;
        do {
            System.out.println("--Opcion Escuadron--");
            System.out.println("1. Crear" +
                    "\n2. Modificar" +
                    "\n3. Eliminar" +
                    "\n4. Listar Escuadron" +
                    "\n5. Agregar Personaje al Escuadron" +
                    "\n6. Salir");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    crearSquad();
                    break;

                case 2:
                    break;

                case 3:
                    System.out.println("Ingrese la posicion del evento a editar: ");
                    int pos = leer.nextInt();
                    squad.remove(pos);
                    break;

                case 4:
                    for (Escuadron escuad : squad) {
                        System.out.println(escuad.toString() + "\n");
                    }
                    break;

                case 5:
                    break;

                case 6:
                    break;
            }
        } while (opcion != 6);
    }
    public static void opcionPersona() {
        int opcion;
        do {
            System.out.println("1. Crear" +
                    "\n2. Modificar" +
                    "\n3. Eliminar (mejor ni lo revises no lo hice XD)" +
                    "\n4. Listar Personajes" +
                    "\n5. Salir");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    crearPersonaje();
                    break;
                case 2:
                    editarPersonaje();
                    break;
                case 3:
                    //tampoco nuila
                    break;
                case 4:
                    imprimirPersonajes();
                    break;
                case 5:
                    break;
            }
        } while (opcion != 5);
    }
    public static void imprimirPersonajes(){
        System.out.println("---Heroes---");
        for(Persona hero: heroes){
            System.out.println(hero.toString());
        }
        System.out.println("\n---Villanos---");
        for(Persona vil: villanos){
            System.out.println(vil.toString());
        }
    }
    public static void eliminarPersonaje(){
        //no pude hacer lo de eliminar :)
    }
    public static void crearUniverso() {
        String univer;
        System.out.println("Ingrese Nombre de un Universo: ");
        univer = leer.next();
        if (buscarUni(univer) == null) {
            universe.add(new Universo(univer));
            System.out.println("Se ha creado el universo: " + univer + "!!!");
        } else {
            System.out.println("Ya existe un universo con este nombre");
        }
    }
    public static void ModificarUniverse() {
        System.out.println("Ingrese la posicion: ");
        int posicon = leer.nextInt();
        System.out.println("Ingrese el nombre universo: ");
        String universo = leer.next();
        if (buscarUni(universo) == null) {
            universe.set(posicon, new Universo(universo));
            System.out.println("Se ha editado el universo: " + universo + "!!!");
        } else {
            System.out.println("Ya existe universo");
        }
    }
    public static Universo buscarUni(String universo) {
        for (Universo univer : universe) {
            if (universo.equalsIgnoreCase(univer.getNombre())) {
                return univer;
            }
        }
        return null;
    }
    public static void crearSquad() {
        System.out.println("Nombre del escuadron: ");
        String escuadron = leer.next();
        System.out.println("Ubicacion de base: ");
        String lugar = leer.next();
        System.out.println("Tipo de escuadron (Heroe||Villano): ");
        String heroeoOvillano = leer.next();
        if (buscarSquad(escuadron) == null) {
            squad.add(new Escuadron(escuadron, lugar, heroeoOvillano));
            System.out.println("Se creo escuadron: " + escuadron + " !!!");
        } else {
            System.out.println("Ya existe un escuadron con este nombre");
        }
    }
    public static Escuadron buscarSquad(String escuadron) {
        for (Escuadron escuad : squad) {
            if (escuadron.equalsIgnoreCase(escuad.getNombre())) {
                return escuad;
            }
        }
        return null;
    }
    public static void crearPersonaje() {
        System.out.print("\n----Crear Personaje----" +
                "\nIngrese nombre: ");
        String nombre = leer.next();
        System.out.print("\nIngrese Poder: ");
        String poder = leer.next();
        System.out.print("\nIngrese Tipo(Heroe || Villano): ");
        String heroeoOvillano = leer.next().toLowerCase();
        System.out.print("\nIngrese Debilidad: ");
        String debilidad = leer.next();
        System.out.println("Ingrese Nivel de fuerza: ");
        int fuerza = leer.nextInt();
        System.out.println("Ingrese Nivel de Hab. Mental: ");
        int habilidadmental = leer.nextInt();
        System.out.println("Ingrese Nivel de Hab. Fisica: ");
        int habilidadfisica = leer.nextInt();
        System.out.println("\n----Tipo de Personaje----" +
                "\n[1] Persona " +
                "\n[2] Mutante" +
                "\n[3] Por Accidente Radiactivo" +
                "\n[4] SuperHumano" +
                "\n[5] Extraterrestre" +
                "\nSeleccione Opcion: ");
        int opcion = leer.nextInt();
        if (heroeoOvillano.equals("heroe")) {
            switch (opcion) {
                case 1:
                    heroes.add(new PersonaNormal(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica));
                    break;

                case 2:
                    heroes.add(new Mutante(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica));
                    break;

                case 3:
                    System.out.print("Ingrese Edad del accidente radioactivo: ");
                    int edad = leer.nextInt();
                    System.out.print("Ingrese tipo accidente: ");
                    String accidente = leer.next();
                    heroes.add(new PorAccidenteRadioactivo(edad, accidente, nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica));
                    break;

                case 4:
                    System.out.print("Ingrese super poder: ");
                    String superpoder = leer.next();
                    heroes.add(new SuperHumano(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica, superpoder));
                    break;

                case 5:
                    System.out.print("---Tipo de Extraterrestre--" +
                            "\n[1] Alien" +
                            "\n[2] Deidad");
                    int opcion2 = leer.nextInt();
                    switch (opcion2) {
                        case 1:
                            heroes.add(new Alien(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica));
                            break;

                        case 2:
                            System.out.println("Ingrese religion: ");
                            String religion = leer.next();
                            System.out.println("Tiene creyentes? si/no");
                            String creyentes = leer.next().toLowerCase();
                            boolean creyente;
                            creyente = (creyentes.equals("si"));
                            heroes.add(new Deidad(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica, creyente, religion));
                            break;
                    }
                    break;

                default:
                    System.out.println("Opcion no valida!!");
                    break;
            }
        } else if (heroeoOvillano.equals("villano")) {
            switch (opcion) {
                case 1:
                    villanos.add(new PersonaNormal(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica));
                    break;

                case 2:
                    villanos.add(new Mutante(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica));
                    break;

                case 3:
                    System.out.println("Ingrese la edad del momento del accidente radioactivo: ");
                    int edad = leer.nextInt();
                    System.out.println("Ingrese el tipo de accidente: ");
                    String accidente = leer.next();
                    villanos.add(new PorAccidenteRadioactivo(edad, accidente, nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica));
                    break;

                case 4:
                    System.out.println("Ingrese super poder: ");
                    String superpower = leer.next();
                    villanos.add(new SuperHumano(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica, superpower));
                    break;

                case 5:
                    System.out.println("---Tipo Extraterrestre---" +
                            "\n[1] Alien" +
                            "\n[2] Deidad" +
                            "Seleccione Opcion:");
                    int opcion2 = leer.nextInt();
                    switch (opcion2) {
                        case 1:
                            villanos.add(new Alien(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica));
                            break;

                        case 2:
                            System.out.println("Ingrese la religion a la que pertenece: ");
                            String religion = leer.next();
                            System.out.println("Esta deidad tiene creyentes? si/no");
                            String tiene = leer.next();
                            boolean creyente;
                            creyente = (tiene.equals("si"));
                            villanos.add(new Deidad(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica, creyente, religion));
                            break;
                    }
                    break;

                default:
                    System.out.println("Opcion no valida!!");
                    break;
            }
        }
    }
    public static void editarPersonaje() {
        System.out.println("\n----Editar Personaje----" +
                "\nIngrese posicion del personaje");
        int pos = leer.nextInt();
        System.out.println("Ingrese el nombre: ");
        String nombre = leer.next();
        System.out.println("\nIngrese el poder: ");
        String poder = leer.next();
        System.out.println("\nIngrese tipo(Heroe || Villano): ");
        String heroeoOvillano = leer.next().toLowerCase();
        System.out.println("\nIngrese debilidad: ");
        String debilidad = leer.next();
        System.out.println("Ingrese nivel de fuerza: ");
        int fuerza = leer.nextInt();
        System.out.println("Ingrese nivel de habilidad mental: ");
        int habilidadmental = leer.nextInt();
        System.out.println("Ingrese nivel de habilidad fisica: ");
        int habilidadfisica = leer.nextInt();
        System.out.println("\n----Tipo de Personaje----" +
                "\n[1] Persona Normal" +
                "\n[2] Mutante" +
                "\n[3] Por Accidente Radiactivo" +
                "\n[4] SuperHumano" +
                "\n[5] Extraterrestre" +
                "\nIngrese una opcion: ");
        int opcion = leer.nextInt();
        if (heroeoOvillano.equals("heroe")) {
            switch (opcion) {
                case 1:
                    heroes.set(pos, new PersonaNormal(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica));
                    break;
                case 2:
                    heroes.set(pos, new Mutante(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica));
                    break;
                case 3:
                    System.out.println("Ingrese edad del momento del accidente radioactivo: ");
                    int edad = leer.nextInt();
                    System.out.println("Ingrese el tipo de accidente: ");
                    String accidente = leer.next();
                    heroes.set(pos, new PorAccidenteRadioactivo(edad, accidente, nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica));
                    break;
                case 4:
                    System.out.println("Ingrese el super poder: ");
                    String superpower = leer.next();
                    heroes.set(pos, new SuperHumano(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica, superpower));
                    break;
                case 5:
                    System.out.println("---Tipo de Extraterrestre---" +
                            "\n[1] Alien" +
                            "\n[2] Deidad");
                    int opcion2 = leer.nextInt();
                    switch (opcion2) {
                        case 1:
                            heroes.set(pos, new Alien(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica));
                            break;

                        case 2:
                            System.out.println("Ingrese la religion perteneciente: ");
                            String religion = leer.next();
                            System.out.println("Esta deidad tiene creyentes? si/no");
                            String tiene = leer.next();
                            boolean creyente;
                            creyente = (tiene.equals("si"));
                            heroes.set(pos, new Deidad(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica, creyente, religion));
                            break;
                    }
                    break;

                default:
                    System.out.println("Opcion no valida!!");
                    break;
            }
        } else if (heroeoOvillano.equals("villano")) {
            switch (opcion) {
                case 1:
                    villanos.set(pos, new PersonaNormal(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica));
                    break;
                case 2:
                    villanos.set(pos,new Mutante(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica));
                    break;
                case 3:
                    System.out.println("Ingrese  edad del momento del accidente radioactivo: ");
                    int edad = leer.nextInt();
                    System.out.println("Ingrese tipo de accidente: ");
                    String accidente = leer.next();
                    villanos.set(pos,new PorAccidenteRadioactivo(edad, accidente, nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica));
                    break;
                case 4:
                    System.out.println("Ingrese super poder: ");
                    String superpower = leer.next();
                    villanos.set(pos,new SuperHumano(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica, superpower));
                    break;
                case 5:
                    System.out.println("---Tipo de Extraterrestre---" +
                            "\n[1] Alien" +
                            "\n[2] Deidad");
                    int opcion2 = leer.nextInt();
                    switch (opcion2) {
                        case 1:
                            villanos.set(pos,new Alien(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica));
                            break;
                        case 2:
                            System.out.println("Ingrese la religion: ");
                            String religion = leer.next();
                            System.out.println("Esta deidad tiene creyentes? si/no");
                            String creyentes = leer.next().toLowerCase();
                            boolean creyente;
                            creyente = (creyentes.equals("si"));
                            villanos.set(pos,new Deidad(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica, creyente, religion));
                            break;
                    }
                    break;
                default:
                    System.out.println("Opcion no valida!!");
                    break;
            }
        }
    }

    public static Persona buscarHeroe(String nombre) {
        for (Persona person : heroes) {
            if (nombre.equalsIgnoreCase(person.getNombre())) {
                return person;
            }
        }
        return null;
    }
    public static Persona buscarVillano(String nombre) {
        for (Persona person : heroes) {
            if (nombre.equalsIgnoreCase(person.getNombre())) {
                return person;
            }
        }
        return null;
    }
    public static void imprimirVillano() {
        for (Persona villain : villanos) {
            System.out.println(villain.toString() + "\n");
        }
    }
    public static void imprimirHeroe() {
        for (Persona heroe : heroes) {
            System.out.println(heroe.toString() + "\n");
        }
    }
    public static void imprimirUniverse() {
        for (Universo universo : universe) {
            System.out.println(universo.toString() + "\n");
        }
    }
    public static void imprimirEscuadron() {
        for (Escuadron escuad : squad) {
            System.out.println(escuad.toString() + "\n");
        }
    }
    public static void agregarDefaults() {
        universe.add(new Universo("Universo Y"));
        universe.add(new Universo("Universo Z"));

        squad.add(new Escuadron("BaleadasTeam", "San Pedro Sula", "heroe"));
        squad.add(new Escuadron("X100PRE", "Miami", "heroe"));
        squad.add(new Escuadron("LosRealesDku", "Tegucigalpa", "villano"));
        squad.add(new Escuadron("Los Mara Pupu de Gallo", "Bajos de Choloma", "villano"));

        buscarUni("Universo X").escuadron.add(squad.get(0));
        buscarUni("Universo X").escuadron.add(squad.get(2));
        buscarUni("Universo Capuleto").escuadron.add(squad.get(1));
        buscarUni("Universo Capuleto").escuadron.add(squad.get(3));


    }
    public static void agregarHeroe(Persona character) {
        for (Persona listar : heroes) {
            if (character.getNombre().equals(listar.getNombre())) {
                heroes.add(listar);
            }
        }
    }

    public static void agregarSquad() {
        System.out.println("Ingrese el universo a agregar: ");
        String univ = leer.next();
        if (buscarUni(univ) != null) {
            System.out.println("Ingrese el escuadron a agregar: ");
            String squa = leer.next();
            if (buscarSquad(squa) != null) {
                buscarUni(univ).escuadron.add(buscarSquad(squa));
            }
        }
    }


}


