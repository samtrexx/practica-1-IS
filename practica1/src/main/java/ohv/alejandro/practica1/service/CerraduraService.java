package ohv.alejandro.practica1.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 * Servicio para calcular las cerraduras de Kleene y positiva
 * y generar cadenas binarias.
 */
@Service
public class CerraduraService {

    // Constante para la representación de la cadena vacía
    private static final String EMPTY_STRING = "{λ}";

    /**
     * Método para la cerradura de Kleene (Σ^*).
     *
     * @param n longitud máxima de las cadenas binarias.
     * @return un mapa con el resultado de la cerradura de Kleene.
     */
    public Map<String, String> kleeneCerradura(int n) {
        Map<String, String> response = new HashMap<>();
        StringBuilder kleene = new StringBuilder(EMPTY_STRING + ", ");

        for (int i = 1; i <= n; i++) {
            kleene.append(generarBinarios(i)).append(", ");
        }

        // Eliminar la última coma y espacio
        response.put("Σ^*", kleene.substring(0, kleene.length() - 2));
        return response;
    }

    /**
     * Método para la cerradura positiva (Σ^+).
     *
     * @param n longitud máxima de las cadenas binarias.
     * @return un mapa con el resultado de la cerradura positiva.
     */
    public Map<String, String> kleeneCerraduraPositiva(int n) {
        Map<String, String> response = new HashMap<>();
        StringBuilder positiva = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            positiva.append(generarBinarios(i)).append(", ");
        }

        // Eliminar la última coma y espacio
        response.put("Σ^+", positiva.substring(0, positiva.length() - 2));
        return response;
    }

    /**
     * Método auxiliar para generar cadenas binarias de longitud 'n'.
     *
     * @param n longitud de las cadenas binarias a generar.
     * @return una cadena con las combinaciones binarias.
     */
    private String generarBinarios(int n) {
        return java.util.stream.IntStream.range(0, (int) Math.pow(2, n))
                .mapToObj(i -> String.format("%" + n + "s", Integer.toBinaryString(i))
                .replace(' ', '0'))
                .collect(Collectors.joining(", "));
    }
}
