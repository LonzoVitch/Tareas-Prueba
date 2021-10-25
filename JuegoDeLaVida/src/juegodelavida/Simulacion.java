
package juegodelavida;


public class Simulacion {
    
    int ancho;
    int largo;
    int[][] tablero;

// Creamos el codigo del tablero, para que más adelante solo reciba en largo y ancho//
    public Simulacion(int ancho, int largo) {
        this.ancho = ancho;
        this.largo = largo;
      
        this.tablero = new int[ancho][largo];
    }

    public void printTablero() {
        System.out.println("Nueva");
        for (int y = 0; y < largo; y++) {
            String line = "|";
            for (int x = 0; x < ancho; x++) {
                if (this.tablero[x][y] == 0) {
                    line += " M ";
                } else {
                    line += " V ";
                }
            }
            line += "|";
            System.out.println(line);
        }
        System.out.println("Fin\n");
    }

//Comenzamos con el codigo que dara si una celula esta viva o muerta, primero declarando ambos estados Vivo-Muerto
    public void setVivo(int x, int y) {
        this.tablero[x][y] = 1;
    }

    public void setMuerto(int x, int y) {
        this.tablero[x][y] = 0;
    }

    public int contarVecinosVivos(int x, int y) {
        int count = 0;

        count += obtenerEstado(x - 1, y - 1);
        count += obtenerEstado(x, y - 1);
        count += obtenerEstado(x + 1, y - 1);

        count += obtenerEstado(x - 1, y);
        count += obtenerEstado(x + 1, y);

        count += obtenerEstado(x - 1, y + 1);
        count += obtenerEstado(x, y + 1);
        count += obtenerEstado(x + 1, y + 1);

        return count;
    }

    public int obtenerEstado(int x, int y) {
        if (x < 0 || x >= ancho) {
            return 0;
        }

        if (y < 0 || y >= largo) {
            return 0;
        }

        return this.tablero[x][y];
    }

    public void step() {
        int[][] newTablero = new int[ancho][largo];
//Aqui vemos las instruccione del juego, 2 o 3 celulas vivas, la celula seguira via, mas de 3 morira en la proxima generacion//
        for (int y = 0; y < largo; y++) {
            for (int x = 0; x < ancho; x++) {
                int vecinosVivos = contarVecinosVivos(x, y);
                if (obtenerEstado(x, y) == 1) {
                    if (vecinosVivos < 2) {
                        newTablero[x][y] = 0;
                    } else if (vecinosVivos == 2 || vecinosVivos == 3) {
                       
                        newTablero[x][y] = 1;
                    } else if (vecinosVivos > 3) 
                    {
                        newTablero[x][y] = 0;
                    }
                } else {
                    if (vecinosVivos == 3) {
                        newTablero[x][y] = 1;
                    }
                }

            }
        }

        this.tablero = newTablero;
    }
 //Nos sirve para conocer el tamaño del tablero, se puede modificar sin problema//        
    public static void main(String[] args) {
        Simulacion simulacion = new Simulacion(15, 10);
//Aqui es donde podremos insertar celulas vivas y decidir donde se encontraran//
//Puede agragarse más celulas iniciamos con 6 vivas//
        simulacion.setVivo(2, 3);
        simulacion.setVivo(1, 4);
        simulacion.setVivo(5, 5);
        simulacion.setVivo(3, 3);
        simulacion.setVivo(2, 4);
        simulacion.setVivo(2, 4);
      

//Indica el número de generaciones que se quieren ver //
//simulacion.printTablero(); //
// simulacion.step(); //
        
        simulacion.printTablero();  //1
        simulacion.step();
        simulacion.printTablero();  //2
        simulacion.step();
        simulacion.printTablero();  //3
        simulacion.step();
        simulacion.printTablero();  //4
        simulacion.step();
        simulacion.printTablero();  //5
        simulacion.step();
        simulacion.printTablero();  //6
        simulacion.step();
        simulacion.printTablero();  //7
        simulacion.step();
        simulacion.printTablero();  //8
        simulacion.step();
        simulacion.printTablero();  //9
        simulacion.step();
        simulacion.printTablero();  //10
        simulacion.step();
        simulacion.printTablero();  //11
        simulacion.step();
        simulacion.printTablero();  //12
        simulacion.step();

       


    }

}
