package com.example.repositories;

import com.example.constants.AccommodationType;
import com.example.models.Accommodation;
import com.example.models.DayPass;
import com.example.models.Room;
import com.example.models.Service;
import com.example.models.Stay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccommodationRepository {
    private static AccommodationRepository instance;
    private static List<Accommodation> listAccommodations;

    private AccommodationRepository() {
        initialize();
    }

    public static AccommodationRepository getInstance() {
        if (instance == null) {
            instance = new AccommodationRepository();

        }
        return instance;
    }


    public static List<Accommodation> getAccomodations() {
        return listAccommodations;
    }




    private void initialize() {
        listAccommodations = new ArrayList<>();
        listAccommodations.add(
                new Stay("Hotel Palermo Deluxe", 4.8f, "Buenos Aires", "Lujoso hotel en el corazón de Palermo", Arrays.asList(
                        new Room("Suite", "Habitación de lujo con jacuzzi", 5, "Suite", 250.0f),
                        new Room("Doble", "Habitación doble con balcón", 10, "Doble", 180.0f),
                        new Room("Individual", "Habitación económica y moderna", 8, "Individual", 120.0f),
                        new Room("Familiar", "Habitación amplia para familias", 6, "Familiar", 200.0f),
                        new Room("Deluxe", "Habitación con servicios exclusivos", 4, "Deluxe", 300.0f)),
                        220.0f, AccommodationType.HOTEL)
        );
        listAccommodations.add(
                new Stay("Hotel Recoleta Plaza", 4.7f, "Buenos Aires", "Hotel elegante en la exclusiva zona de Recoleta", Arrays.asList(
                        new Room("Suite", "Habitación de lujo con vistas al jardín", 6, "Suite", 280.0f),
                        new Room("Doble", "Habitación doble con balcón privado", 8, "Doble", 190.0f),
                        new Room("Individual", "Habitación moderna para ejecutivos", 10, "Individual", 140.0f),
                        new Room("Familiar", "Habitación espaciosa para toda la familia", 5, "Familiar", 230.0f),
                        new Room("Deluxe", "Habitación de lujo con terraza", 3, "Deluxe", 320.0f)),
                        250.0f, AccommodationType.HOTEL)
        );
        listAccommodations.add(
                new Stay("Estancia La Pampa", 4.5f, "Buenos Aires", "Hermosa estancia con caballos y campos verdes", Arrays.asList(
                        new Room("Suite", "Habitación elegante en el casco principal", 5, "Suite", 300.0f),
                        new Room("Doble", "Habitación acogedora con vista al campo", 8, "Doble", 150.0f),
                        new Room("Familiar", "Habitación amplia para grupos grandes", 7, "Familiar", 250.0f),
                        new Room("Individual", "Habitación económica y sencilla", 4, "Individual", 100.0f),
                        new Room("Deluxe", "Habitación exclusiva con jacuzzi", 2, "Deluxe", 350.0f)),
                        200.0f, AccommodationType.FARM)
        );
        listAccommodations.add(
                new Stay("Estancia El Molino", 4.3f, "Buenos Aires", "Estancia rústica con molino antiguo", Arrays.asList(
                        new Room("Suite", "Habitación con decoración clásica", 3, "Suite", 220.0f),
                        new Room("Doble", "Habitación doble con vistas al lago", 6, "Doble", 160.0f),
                        new Room("Individual", "Habitación individual económica", 8, "Individual", 90.0f),
                        new Room("Familiar", "Habitación espaciosa para familias grandes", 5, "Familiar", 210.0f),
                        new Room("Deluxe", "Habitación de lujo con balcón privado", 2, "Deluxe", 330.0f)),
                        190.0f, AccommodationType.FARM)
        );
        listAccommodations.add(
                new Stay("Apartment Plaza San Martín", 4.6f, "Buenos Aires", "Cómodos apartamentos frente a Plaza San Martín", Arrays.asList(
                        new Room("Suite", "Suite con cocina completa y vistas", 4, "Suite", 280.0f),
                        new Room("Doble", "Apartamento doble moderno", 6, "Doble", 170.0f),
                        new Room("Individual", "Apartamento pequeño y económico", 8, "Individual", 110.0f),
                        new Room("Familiar", "Apartamento amplio para familias", 3, "Familiar", 260.0f),
                        new Room("Deluxe", "Apartamento de lujo con terraza", 2, "Deluxe", 400.0f)),
                        240.0f, AccommodationType.APARTMENT)
        );
        listAccommodations.add(
                new Stay("Apartment Belgrano Loft", 4.4f, "Buenos Aires", "Apartamentos modernos en el barrio de Belgrano", Arrays.asList(
                        new Room("Suite", "Loft con diseño exclusivo", 5, "Suite", 300.0f),
                        new Room("Doble", "Apartamento doble con balcón", 7, "Doble", 190.0f),
                        new Room("Individual", "Habitación pequeña para viajeros", 10, "Individual", 100.0f),
                        new Room("Familiar", "Apartamento ideal para grupos", 4, "Familiar", 270.0f),
                        new Room("Deluxe", "Apartamento premium con jacuzzi", 3, "Deluxe", 450.0f)),
                        260.0f, AccommodationType.APARTMENT)
        );
        listAccommodations.add(
                new DayPass(
                        "DayPass Hotel Palermo Deluxe", 4.8f, "Buenos Aires", "Disfruta de las instalaciones del Hotel Palermo Deluxe con piscina y spa",
                        Arrays.asList(
                                new Service("Piscina", "Acceso a una piscina amplia y climatizada", 150.0f),
                                new Service("Spa", "Relájate en el spa con sauna y masajes", 170.0f),
                                new Service("Restaurante", "Menú buffet con variedad de platos", 180.0f),
                                new Service("Gimnasio", "Acceso al gimnasio con entrenador personal", 160.0f),
                                new Service("Bar", "Cócteles y bebidas en el bar de la piscina", 140.0f)
                        ),
                        150.0f, AccommodationType.DAY_PASS
                )
        );
        listAccommodations.add(
                new DayPass(
                        "DayPass Apartment Plaza San Martín", 4.6f, "Buenos Aires", "Día de relax en los apartamentos Plaza San Martín con jacuzzi y terraza",
                        Arrays.asList(
                                new Service("Jacuzzi", "Acceso al jacuzzi privado en la terraza", 120.0f),
                                new Service("Terraza", "Disfruta de la terraza con vistas panorámicas", 130.0f),
                                new Service("Café", "Café y snacks incluidos durante el día", 120.0f),
                                new Service("Zona de lectura", "Espacio tranquilo para leer y descansar", 125.0f),
                                new Service("Bar", "Cócteles y bebidas en el bar de la terraza", 140.0f)
                        ),
                        120.0f, AccommodationType.DAY_PASS
                )
        );


        // Rosario
        listAccommodations.add(
                new Stay("Hotel Rosario Centro", 4.5f, "Rosario", "Hotel moderno en el centro de la ciudad", Arrays.asList(
                        new Room("Suite", "Habitación con vista al río Paraná", 5, "Suite", 240.0f),
                        new Room("Doble", "Habitación doble cómoda y luminosa", 8, "Doble", 160.0f),
                        new Room("Individual", "Habitación económica para viajeros", 10, "Individual", 120.0f),
                        new Room("Familiar", "Habitación ideal para familias", 6, "Familiar", 210.0f),
                        new Room("Deluxe", "Habitación exclusiva con terraza", 3, "Deluxe", 330.0f)),
                        220.0f, AccommodationType.HOTEL)
        );
        listAccommodations.add(
                new Stay("Hotel Monumento", 4.6f, "Rosario", "Elegante hotel cerca del Monumento a la Bandera", Arrays.asList(
                        new Room("Suite", "Habitación con diseño contemporáneo", 4, "Suite", 260.0f),
                        new Room("Doble", "Habitación doble con decoración moderna", 8, "Doble", 170.0f),
                        new Room("Individual", "Habitación pequeña y económica", 10, "Individual", 110.0f),
                        new Room("Familiar", "Espacio amplio para familias", 5, "Familiar", 240.0f),
                        new Room("Deluxe", "Habitación premium con vista panorámica", 2, "Deluxe", 380.0f)),
                        230.0f, AccommodationType.HOTEL)
        );
        listAccommodations.add(
                new Stay("Estancia La Ribera", 4.4f, "Rosario", "Hermosa estancia a orillas del río Paraná", Arrays.asList(
                        new Room("Suite", "Habitación elegante con vista al río", 3, "Suite", 270.0f),
                        new Room("Doble", "Habitación doble acogedora", 7, "Doble", 150.0f),
                        new Room("Individual", "Habitación rústica y económica", 9, "Individual", 90.0f),
                        new Room("Familiar", "Habitación amplia para grupos", 6, "Familiar", 220.0f),
                        new Room("Deluxe", "Habitación de lujo con terraza privada", 2, "Deluxe", 350.0f)),
                        210.0f, AccommodationType.FARM)
        );
        listAccommodations.add(

                new Stay("Estancia Las Palmeras", 4.3f, "Rosario", "Estancia tranquila rodeada de naturaleza", Arrays.asList(
                        new Room("Suite", "Suite con estilo colonial", 4, "Suite", 250.0f),
                        new Room("Doble", "Habitación doble cómoda", 6, "Doble", 140.0f),
                        new Room("Individual", "Habitación sencilla para viajeros", 10, "Individual", 100.0f),
                        new Room("Familiar", "Espacio ideal para familias", 5, "Familiar", 200.0f),
                        new Room("Deluxe", "Habitación con decoración premium", 2, "Deluxe", 320.0f)),
                        200.0f, AccommodationType.FARM)
        );
        listAccommodations.add(

                new Stay("Apartment Costanera", 4.5f, "Rosario", "Apartamentos modernos frente al río", Arrays.asList(
                        new Room("Suite", "Suite con vistas al río Paraná", 3, "Suite", 300.0f),
                        new Room("Doble", "Apartamento doble con cocina equipada", 7, "Doble", 190.0f),
                        new Room("Individual", "Habitación económica y funcional", 8, "Individual", 110.0f),
                        new Room("Familiar", "Apartamento amplio para familias", 4, "Familiar", 270.0f),
                        new Room("Deluxe", "Apartamento premium con terraza privada", 2, "Deluxe", 420.0f)),
                        250.0f, AccommodationType.APARTMENT)
        );
        listAccommodations.add(

                new Stay("Apartment Centro Rosario", 4.3f, "Rosario", "Apartamentos céntricos y modernos", Arrays.asList(
                        new Room("Suite", "Suite con diseño minimalista", 5, "Suite", 320.0f),
                        new Room("Doble", "Habitación doble con balcón", 6, "Doble", 180.0f),
                        new Room("Individual", "Habitación económica ideal", 9, "Individual", 120.0f),
                        new Room("Familiar", "Espacio ideal para grupos", 5, "Familiar", 290.0f),
                        new Room("Deluxe", "Habitación premium con vista urbana", 3, "Deluxe", 440.0f)),
                        270.0f, AccommodationType.APARTMENT)
        );
        listAccommodations.add(
                new DayPass(
                        "DayPass Hotel Rosario Centro", 4.5f, "Rosario", "Día completo en el Hotel Rosario Centro con almuerzo incluido",
                        Arrays.asList(
                                new Service("Gimnasio", "Gimnasio totalmente equipado", 120.0f),
                                new Service("Almuerzo", "Disfruta de un almuerzo gourmet", 130.0f),
                                new Service("Zona de descanso", "Áreas cómodas para relajarte", 140.0f),
                                new Service("Piscina", "Piscina climatizada con vistas panorámicas", 150.0f),
                                new Service("Bar", "Bebidas y snacks en el bar de la piscina", 125.0f)
                        ),
                        120.0f, AccommodationType.DAY_PASS
                )
        );
        listAccommodations.add(
                new DayPass(
                        "DayPass Apartment Costanera", 4.5f, "Rosario", "Día de sol en los apartamentos Costanera con piscina y vistas al río Paraná",
                        Arrays.asList(
                                new Service("Piscina", "Piscina al aire libre con reposeras", 100.0f),
                                new Service("Solarium", "Área de relax con camastros", 110.0f),
                                new Service("Barbacoa", "Asado y comidas típicas en la parrilla", 130.0f),
                                new Service("Juegos", "Actividades recreativas para toda la familia", 100.0f),
                                new Service("Bar", "Bebidas y snacks en el bar de la piscina", 120.0f)
                        ),
                        100.0f, AccommodationType.DAY_PASS
                )
        );


        // Córdoba
        listAccommodations.add(
                new Stay("Hotel Córdoba Central", 4.7f, "Córdoba", "Hotel moderno en el centro histórico", Arrays.asList(
                        new Room("Suite", "Habitación lujosa con balcón", 5, "Suite", 260.0f),
                        new Room("Doble", "Habitación doble con vista a la ciudad", 8, "Doble", 170.0f),
                        new Room("Individual", "Habitación económica y cómoda", 10, "Individual", 130.0f),
                        new Room("Familiar", "Espacio ideal para familias", 6, "Familiar", 220.0f),
                        new Room("Deluxe", "Habitación premium con terraza", 3, "Deluxe", 350.0f)),
                        240.0f, AccommodationType.HOTEL)
        );
        listAccommodations.add(
                new Stay("Hotel Nueva Córdoba", 4.5f, "Córdoba", "Elegante hotel en el barrio de Nueva Córdoba", Arrays.asList(
                        new Room("Suite", "Habitación con diseño moderno", 4, "Suite", 280.0f),
                        new Room("Doble", "Habitación doble con balcón privado", 7, "Doble", 180.0f),
                        new Room("Individual", "Habitación pequeña y económica", 9, "Individual", 140.0f),
                        new Room("Familiar", "Habitación amplia para familias", 5, "Familiar", 260.0f),
                        new Room("Deluxe", "Habitación premium con vista panorámica", 2, "Deluxe", 380.0f)),
                        250.0f, AccommodationType.HOTEL)
        );
        listAccommodations.add(
                new Stay("Estancia La Cumbre", 4.6f, "Córdoba", "Hermosa estancia en las sierras de Córdoba", Arrays.asList(
                        new Room("Suite", "Suite con vistas a las sierras", 4, "Suite", 290.0f),
                        new Room("Doble", "Habitación doble acogedora", 7, "Doble", 160.0f),
                        new Room("Individual", "Habitación económica para aventureros", 8, "Individual", 110.0f),
                        new Room("Familiar", "Habitación espaciosa para grupos", 5, "Familiar", 250.0f),
                        new Room("Deluxe", "Habitación premium con jacuzzi", 2, "Deluxe", 370.0f)),
                        230.0f, AccommodationType.FARM)
        );
        listAccommodations.add(
                new Stay("Estancia El Cóndor", 4.4f, "Córdoba", "Estancia rústica rodeada de naturaleza", Arrays.asList(
                        new Room("Suite", "Habitación con estilo colonial", 3, "Suite", 260.0f),
                        new Room("Doble", "Habitación doble con vistas al lago", 6, "Doble", 150.0f),
                        new Room("Individual", "Habitación sencilla para viajeros", 10, "Individual", 100.0f),
                        new Room("Familiar", "Espacio ideal para familias", 5, "Familiar", 230.0f),
                        new Room("Deluxe", "Habitación exclusiva con terraza", 2, "Deluxe", 340.0f)),
                        220.0f, AccommodationType.FARM)
        );
        listAccommodations.add(
                new Stay("Apartment Patio Olmos", 4.6f, "Córdoba", "Apartamentos modernos cerca del shopping Patio Olmos", Arrays.asList(
                        new Room("Suite", "Apartamento premium con vistas", 3, "Suite", 320.0f),
                        new Room("Doble", "Apartamento doble bien equipado", 7, "Doble", 200.0f),
                        new Room("Individual", "Apartamento pequeño y económico", 9, "Individual", 130.0f),
                        new Room("Familiar", "Apartamento ideal para grupos", 5, "Familiar", 280.0f),
                        new Room("Deluxe", "Apartamento con terraza privada", 2, "Deluxe", 400.0f)),
                        270.0f, AccommodationType.APARTMENT)
        );
        listAccommodations.add(
                new Stay("Apartment Nueva Córdoba", 4.5f, "Córdoba", "Apartamentos modernos en Nueva Córdoba", Arrays.asList(
                        new Room("Suite", "Suite con diseño minimalista", 4, "Suite", 300.0f),
                        new Room("Doble", "Habitación doble con balcón", 6, "Doble", 190.0f),
                        new Room("Individual", "Apartamento económico y cómodo", 8, "Individual", 120.0f),
                        new Room("Familiar", "Espacio amplio para familias", 5, "Familiar", 290.0f),
                        new Room("Deluxe", "Apartamento premium con jacuzzi", 2, "Deluxe", 420.0f)),
                        280.0f, AccommodationType.APARTMENT)
        );
        listAccommodations.add(
                new DayPass(
                        "DayPass Apartment Patio Olmos", 4.6f, "Córdoba", "Relájate en el Apartment Patio Olmos con terraza y vistas a la ciudad",
                        Arrays.asList(
                                new Service("Jacuzzi", "Acceso al jacuzzi privado", 100.0f),
                                new Service("Terraza", "Disfruta de la terraza con vistas panorámicas", 120.0f),
                                new Service("Café", "Café y snacks incluidos durante el día", 110.0f),
                                new Service("Zona de lectura", "Espacio tranquilo para leer y descansar", 125.0f),
                                new Service("Bar", "Cócteles y bebidas en el bar de la terraza", 130.0f)
                        ),
                        100.0f, AccommodationType.DAY_PASS
                )
        );
        listAccommodations.add(
                new DayPass(
                        "DayPass Apartment Nueva Córdoba", 4.5f, "Córdoba", "Día de relax en los apartamentos de Nueva Córdoba con piscina y solarium",
                        Arrays.asList(
                                new Service("Piscina", "Piscina al aire libre con reposeras", 80.0f),
                                new Service("Solarium", "Área de relax con camastros", 90.0f),
                                new Service("Barbacoa", "Asado y comidas típicas en la parrilla", 100.0f),
                                new Service("Juegos", "Actividades recreativas para toda la familia", 85.0f),
                                new Service("Bar", "Bebidas y snacks en el bar de la piscina", 95.0f)
                        ),
                        80.0f, AccommodationType.DAY_PASS
                )
        );


        // Mar del Plata
        listAccommodations.add(
                new Stay("Hotel Costa Atlántica", 4.7f, "Mar del Plata", "Hotel frente al mar con servicios exclusivos", Arrays.asList(
                        new Room("Suite", "Habitación con vistas al océano", 5, "Suite", 300.0f),
                        new Room("Doble", "Habitación doble con balcón", 8, "Doble", 200.0f),
                        new Room("Individual", "Habitación económica para viajeros", 10, "Individual", 130.0f),
                        new Room("Familiar", "Espacio ideal para familias", 6, "Familiar", 260.0f),
                        new Room("Deluxe", "Habitación premium con terraza", 3, "Deluxe", 380.0f)),
                        260.0f, AccommodationType.HOTEL)
        );
        listAccommodations.add(
                new Stay("Hotel Playa Grande", 4.6f, "Mar del Plata", "Hotel elegante cerca de Playa Grande", Arrays.asList(
                        new Room("Suite", "Habitación con estilo moderno", 4, "Suite", 280.0f),
                        new Room("Doble", "Habitación doble con vistas al mar", 7, "Doble", 190.0f),
                        new Room("Individual", "Habitación pequeña y económica", 8, "Individual", 120.0f),
                        new Room("Familiar", "Espacio amplio para familias", 5, "Familiar", 270.0f),
                        new Room("Deluxe", "Habitación premium con jacuzzi", 2, "Deluxe", 400.0f)),
                        250.0f, AccommodationType.HOTEL)
        );
        listAccommodations.add(
                new Stay("Estancia Mar Azul", 4.4f, "Mar del Plata", "Estancia rústica rodeada de naturaleza", Arrays.asList(
                        new Room("Suite", "Habitación con estilo colonial", 3, "Suite", 260.0f),
                        new Room("Doble", "Habitación doble con vistas al lago", 6, "Doble", 150.0f),
                        new Room("Individual", "Habitación sencilla para viajeros", 10, "Individual", 100.0f),
                        new Room("Familiar", "Espacio ideal para familias", 5, "Familiar", 230.0f),
                        new Room("Deluxe", "Habitación exclusiva con terraza", 2, "Deluxe", 340.0f)),
                        220.0f, AccommodationType.FARM)
        );
        listAccommodations.add(
                new Stay("Estancia Las Dunas", 4.3f, "Mar del Plata", "Estancia tranquila en la costa marplatense", Arrays.asList(
                        new Room("Suite", "Habitación con vistas al mar", 4, "Suite", 280.0f),
                        new Room("Doble", "Habitación doble acogedora", 7, "Doble", 160.0f),
                        new Room("Individual", "Habitación económica para aventureros", 8, "Individual", 110.0f),
                        new Room("Familiar", "Habitación espaciosa para grupos", 5, "Familiar", 250.0f),
                        new Room("Deluxe", "Habitación premium con jacuzzi", 2, "Deluxe", 370.0f)),
                        230.0f, AccommodationType.FARM)
        );
        listAccommodations.add(
                new Stay("Apartment Playa Varese", 4.6f, "Mar del Plata", "Apartamentos modernos frente a Playa Varese", Arrays.asList(
                        new Room("Suite", "Suite con vistas al mar", 3, "Suite", 320.0f),
                        new Room("Doble", "Apartamento doble con cocina equipada", 7, "Doble", 200.0f),
                        new Room("Individual", "Habitación económica y funcional", 9, "Individual", 130.0f),
                        new Room("Familiar", "Apartamento amplio para familias", 5, "Familiar", 280.0f),
                        new Room("Deluxe", "Apartamento premium con terraza privada", 2, "Deluxe", 400.0f)),
                        270.0f, AccommodationType.APARTMENT)
        );
        listAccommodations.add(
                new Stay("Apartment Playa Chica", 4.5f, "Mar del Plata", "Apartamentos modernos cerca de Playa Chica", Arrays.asList(
                        new Room("Suite", "Suite con diseño minimalista", 4, "Suite", 300.0f),
                        new Room("Doble", "Habitación doble con balcón", 6, "Doble", 190.0f),
                        new Room("Individual", "Apartamento económico y cómodo", 8, "Individual", 120.0f),
                        new Room("Familiar", "Espacio amplio para familias", 5, "Familiar", 290.0f),
                        new Room("Deluxe", "Apartamento premium con jacuzzi", 2, "Deluxe", 420.0f)),
                        280.0f, AccommodationType.APARTMENT)
        );
        listAccommodations.add(
                new DayPass(
                        "DayPass Estancia Las Dunas", 4.3f, "Mar del Plata", "Día de campo en la Estancia Las Dunas con cabalgatas y asado",
                        Arrays.asList(
                                new Service("Cabalgata", "Recorrido a caballo por los campos de la estancia", 80.0f),
                                new Service("Asado", "Almuerzo con asado y comidas típicas", 90.0f),
                                new Service("Piscina", "Piscina al aire libre con reposeras", 80.0f),
                                new Service("Juegos", "Actividades recreativas para toda la familia", 85.0f),
                                new Service("Bar", "Bebidas y snacks en el bar de la piscina", 90.0f)
                        ),
                        80.0f, AccommodationType.DAY_PASS
                )
        );
        listAccommodations.add(
                new DayPass(
                        "DayPass Estancia Mar Azul", 4.4f, "Mar del Plata", "Día de campo en la Estancia Mar Azul con cabalgatas y almuerzo campestre",
                        Arrays.asList(
                                new Service("Cabalgata", "Recorrido a caballo por los campos de la estancia", 70.0f),
                                new Service("Almuerzo", "Almuerzo campestre con comidas típicas", 80.0f),
                                new Service("Piscina", "Piscina al aire libre con reposeras", 75.0f),
                                new Service("Juegos", "Actividades recreativas para toda la familia", 70.0f),
                                new Service("Bar", "Bebidas y snacks en el bar de la piscina", 80.0f)
                        ),
                        70.0f, AccommodationType.DAY_PASS
                )
        );
    }
}
