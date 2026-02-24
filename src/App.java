import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = "inteligencia";
        int intentoMaximo = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        while (!palabraAdivinada && intentos < intentoMaximo) {

            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");
            System.out.print("Ingresa una letra: ");
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            // Bucle SOLO para verificar si la letra existe y actualizar el array
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            // CORRECCIÓN 1 y 2: Esto va FUERA del for y con la lógica invertida (!)
            if (!letraCorrecta) {
                intentos++;
                System.out.println("Incorrecto! Intentos restantes: " + (intentoMaximo - intentos));
            }

            // Verificar si ganó
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
            }
        }

        // CORRECCIÓN 3: El mensaje de derrota es si NO adivinó
        if (!palabraAdivinada) {
            System.out.println("Has perdido! La palabra secreta era: " + palabraSecreta);
        }
        
        scanner.close();
    }
}
