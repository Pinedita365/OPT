package com.example.ej1_tema5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class Security {
    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsService = new InMemoryUserDetailsManager();
        UserDetails user1 = User.builder()
                .username("admin")
                .password(this.passwordEncoder().encode("admin"))
                .authorities("write")
                .build();

        userDetailsService.createUser(user1);
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

// 2. ¿Qué ganamos con esto comparado con lo anterior?
// Si el primer ejercicio era "automático" y el segundo era "por configuración", este tercer paso es "tomar el control total". Aquí te explico por qué es mejor:

// Adiós a las contraseñas a la vista: Antes, tu contraseña estaba escrita tal cual en el archivo de texto. Ahora, gracias al BCryptPasswordEncoder, la contraseña "admin" viaja por el sistema como un código cifrado e indescifrable. Es el estándar que se usa en aplicaciones reales.

// Capacidad de crecimiento: En el archivo .properties solo puedes tener un usuario. Con esta clase, si mañana necesitas 10 usuarios o 3 niveles de permisos distintos (quien solo lee, quien puede escribir, etc.), solo tienes que añadir unas líneas más de código en el mismo sitio.

// Inteligencia de Spring: Al usar la anotación @Configuration, le estás diciendo a Spring: "Oye, olvida tus reglas por defecto, a partir de ahora yo te digo quién entra y cómo se valida la clave".

// 3. Debate: Lo bueno y lo no tan bueno
// Como todo en programación, esta forma tiene sus dos caras:

// La parte buena (Ventajas)
// Es el "camino profesional": Casi cualquier empresa que use Spring Boot configura la seguridad así. Aprender esto es aprender cómo se trabaja de verdad.

// Orden: Tienes un archivo específico (SecurityConfig) donde sabes que está TODO lo relacionado con proteger tu web. Si algo falla en el login, vas directo ahí.

// Personalización: Puedes decidir cosas como: "el admin puede entrar aquí, pero el usuario normal no". Eso en los pasos anteriores era casi imposible de gestionar.

// Los puntos débiles (Inconvenientes)
// Más código que escribir: Obviamente, es más complejo que escribir una sola línea en un archivo de configuración.

// Memoria volátil: Aunque es más avanzado, seguimos usando InMemoryUserDetailsManager. Esto significa que si apagas el servidor, los usuarios "se olvidan". Para que sea definitivo, el siguiente paso lógico sería conectarlo a una base de datos.

// Curva de aprendizaje: Al principio asusta ver tantos términos nuevos (Bean, UserDetailsService, Encoder), pero una vez entiendes que son "piezas de Lego" que encajan, todo cobra sentido.