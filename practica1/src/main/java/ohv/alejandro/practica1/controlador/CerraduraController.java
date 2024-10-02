package ohv.alejandro.practica1.controlador;

import ohv.alejandro.practica1.service.CerraduraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Controlador para gestionar las solicitudes relacionadas con
 * las cerraduras de Kleene y positiva.
 */
@RestController
@RequestMapping("/api/cerradura")
public class CerraduraController {

    @Autowired
    private CerraduraService cerraduraService;

    /**
     * Endpoint para obtener la cerradura de Kleene (Σ^*).
     *
     * @param n longitud máxima de las cadenas binarias.
     * @return un mapa con el resultado de la cerradura de Kleene.
     */
    @GetMapping("/estrella/{n}")
    public Map<String, Object> obtenerCerraduraEstrella(@PathVariable int n) {
        Map<String, String> kleeneResult = cerraduraService.kleeneCerradura(n);
        Map<String, Object> response = new HashMap<>();
        //response.put("titulo", "Cerradura de Kleene (Σ^*)");
        //response.put("mensaje", "Este es el conjunto de cadenas obtenidas a partir de la cerradura de Kleene.");
        response.put("resultado", kleeneResult);
        return response;
    }

    /**
     * Endpoint para obtener la cerradura positiva (Σ^+).
     *
     * @param n longitud máxima de las cadenas binarias.
     * @return un mapa con el resultado de la cerradura positiva.
     */
    @GetMapping("/positiva/{n}")
    public Map<String, Object> obtenerCerraduraPositiva(@PathVariable int n) {
        Map<String, String> positivaResult = cerraduraService.kleeneCerraduraPositiva(n);
        Map<String, Object> response = new HashMap<>();
        //response.put("titulo", "Cerradura Positiva (Σ^+)");
        //response.put("mensaje", "Este es el conjunto de cadenas obtenidas a partir de la cerradura positiva.");
        response.put("resultado", positivaResult);
        return response;
    }
}

/*
 * // Para querystring 
 * @PutMapping("/estrella")
public Map<String, Object> obtenerCerraduraEstrella(@RequestParam int n) {
    // Implementación
}

@PutMapping("/positiva")
public Map<String, Object> obtenerCerraduraPositiva(@RequestParam int n) {
    // Implementación
}
 */