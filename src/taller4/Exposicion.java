package taller4;


import java.util.ArrayList;
import java.util.Scanner;


/*
 * Anyeli Jaramillo
 * Maria Vallejo
 */
public class Exposicion { 
         private  ArrayList<Perros>misPerros;
         private  Scanner lector;
    
      public Exposicion() {
         //Permite inicializar los productos de una clase
         misPerros= new ArrayList<>();
         lector = new Scanner(System.in);
     }
           
      public void mostrarMenu() {
    	    boolean activo = true;
    	    do {
    	        // Imprimir el menú de opciones
    	        System.out.println("====== Menu de opciones ======");
    	        System.out.println("1. Registrar un canino");
    	        System.out.println("2. Mostrar los caninos registrados");
    	        System.out.println("3. Mostrar listado de los caninos en orden");
    	        System.out.println("4. Modificar la información de un canino");
    	        System.out.println("5. Mostrar el canino ganador");
    	        System.out.println("6. Mostrar el canino con menor puntaje");
    	        System.out.println("7. Mostrar el canino mayor en edad");
    	        System.out.println("8. Eliminar información de un canino");
    	        System.out.println("9. Salir del programa");
    	        System.out.println("ESCRIBA LA OPCION QUE DESEA :)");
    	        System.out.println("=======================================");

    	        // Leer la opción seleccionada por el usuario
    	        int opcion = lector.nextInt();

    	        // Ejecutar la acción correspondiente según la opción seleccionada
    	        switch (opcion) {
    	            case 1:
    	                // Registrar un nuevo canino
    	                try {
    	                    agregarPerro();
    	                } catch (NombreDuplicadoException p) {
    	                    System.out.println(p.getMessage());
    	                }
    	                break;
    	            case 2:
    	                // Mostrar los caninos registrados
    	                if (misPerros.size() == 0) {
    	                    System.out.println("No se han agregado caninos.");
    	                } else {
    	                    mostrarInformacion();
    	                }
    	                break;
    	            case 3:
    	                // Mostrar el listado de caninos en orden
    	                if (misPerros.size() == 0) {
    	                    System.out.println("No se han agregado caninos.");
    	                } else {
    	                    listadoPerros();
    	                }
    	                break;
    	            case 4:
    	                // Modificar la información de un canino
    	                if (misPerros.size() == 0) {
    	                    System.out.println("No se han agregado caninos.");
    	                } else {
    	                    modificarInformacion();
    	                }
    	                break;
    	            case 5:
    	                // Mostrar el canino ganador
    	                if (misPerros.size() == 0) {
    	                    System.out.println("No se han agregado caninos.");
    	                } else {
    	                    perroGanador();
    	                }
    	                break;
    	            case 6:
    	                // Mostrar el canino con menor puntaje
    	                if (misPerros.size() == 0) {
    	                    System.out.println("No se han agregado caninos.");
    	                } else {
    	                    puntajeMenor();
    	                }
    	                break;
    	            case 7:
    	                // Mostrar el canino mayor en edad
    	                if (misPerros.size() == 0) {
    	                    System.out.println("No se han agregado caninos.");
    	                } else {
    	                    mayorEdad();
    	                }
    	                break;
    	            case 8:
    	                // Eliminar información de un canino
    	                if (misPerros.size() == 0) {
    	                    System.out.println("No se han agregado caninos.");
    	                } else {
    	                    eliminarInformacionPerro();
    	                }
    	                break;
    	            case 9:
    	                // Salir del programa
    	                activo = false;
    	                System.out.println("PROGRAMA TERMINADO BYE");
    	                break;
    	            default:
    	                // Para opciones inválidas
    	                System.out.println("Opción no válida");
    	        }
    	    } while (activo); // Bucle para continuar mostrando el menú mientras la variable activo sea true
    	}
   // Método para agregar un nuevo perro a la lista de perros
   //lanzando una excepción si el nombre se repite
      public void agregarPerro() throws NombreDuplicadoException {
          lector.nextLine(); 
          System.out.println("Escriba el nombre del canino: ");
          String nombrePerro = lector.nextLine();
          
          // Verificar si la lista de perros no está vacía 
          if (!misPerros.isEmpty()) {
           //  verifica si existe un perro con el mismo nombre
              for (Perros p : misPerros) {
                  if (p.getNombrePerros().equalsIgnoreCase(nombrePerro)) {
                      // Si se encuentra un perro con el mismo nombre, lanza la excepción
                      throw new NombreDuplicadoException();
                  }
              }
          }
          System.out.println("Escriba la raza del canino: ");
          String raza = lector.nextLine();
          System.out.println("Escriba la edad del canino en meses: ");
          int edadMeses = lector.nextInt();
          System.out.println("Escriba el puntaje del canino de 1-10: ");
          int puntaje = lector.nextInt(); lector.nextLine(); // Limpiar el buffer de entrada
          System.out.println("Ingrese la foto del canino: ");
          String foto = lector.nextLine();
          System.out.println("===========================================");
          
          // Crear un nuevo objeto Perros 
          Perros nuevoPerro = new Perros(nombrePerro, edadMeses, raza, puntaje, foto);
          misPerros.add(nuevoPerro);
          System.out.println("EL CANINO FUE REGISTRADO CON ÉXITO !");
      }

      // Mustra la información de todos los perros registrados
      public void mostrarInformacion() {
          System.out.println("========= EL REGISTRO DE LOS CANINOS ===========");
          for (Perros p : misPerros) {
              System.out.println("Nombre del Perro: " + p.getNombrePerros());
              System.out.println("Puntaje: " + p.getPuntaje());
              System.out.println("Foto: " + p.getFoto());
              System.out.println("Raza: " + p.getRaza());
              System.out.println("Edad en Meses: " + p.getEdadMeses());
              System.out.println("======================================================");
              System.out.println("");
          }
      }
  
   // Permitir al usuario ordenarlos por edad o puntaje
      public void listadoPerros() {
          // Verificar si la lista de perros está vacía
          if (misPerros.isEmpty()) {
              // Si la lista está vacía, imprimir un mensaje y salir del método
              System.out.println("No hay caninos en la lista.");
              System.out.println("============================================================");
              return;
          }
          
          // Bucle para repetir el menú 
          do {
              System.out.println("========== ¿EN QUÉ ORDEN DESEA VER LOS CANINOS? ==========");
              System.out.println("1. Por edad.");
              System.out.println("2. Por puntaje.");
              System.out.println("3. Salir del menú de opciones.");
              System.out.println("============================================================");
              
              // Leer la opción ingresada por el usuario
              int opcion = lector.nextInt();
              lector.nextLine(); 
              
              // Opción seleccionada por el usuario
              switch (opcion) {
                  case 1:
                      // Organizar la lista de perros por edad y mustrar el listado
                      organizarPorEdad();
                      mostrarListadoPerros("Edad");
                      break;
                  case 2:
                      // Organiza la lista de perros por puntaje y mustrar el listado
                      organizarPorPuntaje();
                      mostrarListadoPerros("Puntaje");
                      break;
                  case 3:
                      // Salir del menú de opciones
                      System.out.println("Salió del menú de opciones.");
                      System.out.println("=======================================");
                      return;
                  default:
                      // Para opciones inválidas
                      System.out.println("Opción no válida.");
                      break;
              }
          } while (true); // Repite el menú hasta que el usuario decida salir
      }

      // Ordena la lista de perros por edad en orden ascendente
      private void organizarPorEdad() {
          for (int i = 0; i < misPerros.size() - 1; i++) {
              for (int j = 0; j < misPerros.size() - i - 1; j++) {
                  if (misPerros.get(j).getEdadMeses() > misPerros.get(j + 1).getEdadMeses()) {
                      // Intercambiar perros si el perro actual tiene una edad mayor que el siguiente perro
                      Perros p = misPerros.get(j);
                      misPerros.set(j, misPerros.get(j + 1));
                      misPerros.set(j + 1, p);
                  }
              }
          }
      }

      // Ordenar la lista de perros por puntaje en orden ascendente
      private void organizarPorPuntaje() {
          for (int i = 0; i < misPerros.size() - 1; i++) {
              for (int j = 0; j < misPerros.size() - i - 1; j++) {
                  if (misPerros.get(j).getPuntaje() > misPerros.get(j + 1).getPuntaje()) {
                      // Intercambiar perros si el perro actual tiene un puntaje mayor que el siguiente perro
                      Perros p = misPerros.get(j);
                      misPerros.set(j, misPerros.get(j + 1));
                      misPerros.set(j + 1, p);
                  }
              }
          }
      }

      // Mustrar el listado de perros ordenado por edad o puntaje
      private void mostrarListadoPerros(String orden) {
          System.out.println("Listado de caninos ordenado por " + orden + ":");
          for (Perros perro : misPerros) {
              System.out.println("Nombre del perro: " + perro.getNombrePerros() + ", Edad: " + perro.getEdadMeses() + " meses, Puntaje: " + perro.getPuntaje());
          }
          System.out.println("============================================================");
      }
       
      // Metodo para modificar informacion
public void modificarInformacion() {
           lector.nextLine();
           System.out.println("Escriba el nombre del canino que desea modificar la informacion:");
           String nombre = lector.nextLine();
           boolean activo = false;
           
           for (Perros perro : misPerros) {
           if (perro.getNombrePerros().equalsIgnoreCase(nombre)) {
           do {
               System.out.println("====== MENU PARA MODIFICAR LA INFORMACION ======");
               System.out.println("1. Para modificar la edad.");
               System.out.println("2. Para cambiar la raza.");
               System.out.println("3. Para modificar el puntaje.");
               System.out.println("4. Para salir del menu de modificaciones.");
               System.out.println("=======================================");
                       
            int opcion = lector.nextInt();
                       lector.nextLine(); 
                       switch (opcion) {
                           case 1:
                               modificarEdad(perro);
                               break;
                           case 2:
                               modificarRaza(perro);
                               break;
                           case 3:
                               modificarPuntaje(perro);
                               break;
                           case 4:
                               salir();
                               activo = true;
                               break;
                           default:
                               System.out.println("Opción no válida");
                               break;
                       }
                   } while (!activo);
               }
           }
       }

public void modificarEdad(Perros perro) {
    System.out.println("Ingrese la nueva edad en meses:");
    int nuevaEdadMeses = lector.nextInt();
    // Actualizar la edad del perro 
    perro.setEdadMeses(nuevaEdadMeses);
    System.out.println("Edad modificada con éxito.");
}

public void modificarRaza(Perros perro) {
    System.out.println("Ingrese la nueva raza:");
    // Lee la nueva raza proporcionada por el usuario
    String nuevaRaza = lector.nextLine();
    // Actualizar la raza del perro 
    perro.setRaza(nuevaRaza);
    System.out.println("Raza modificada con éxito.");
}

public void modificarPuntaje(Perros perro) {
    System.out.println("Ingrese el nuevo puntaje:");
    // Lee el nuevo puntaje proporcionado por el usuario
    int nuevoPuntaje = lector.nextInt();
    // Actualizar el puntaje del perro 
    perro.setPuntaje(nuevoPuntaje);
    System.out.println("Puntaje modificado con éxito.");
}

// Método de salida
public void salir() {
    System.out.println("Salió de las modificaciones.");
    System.out.println("=======================================");    
}
        
//Método para mostrar al canino ganador 
public void perroGanador() {
 // Verificar si no hay caninos registrados en la exposición
 if (misPerros.isEmpty()) {
     System.out.println("No hay caninos registrados");
 } else {
     System.out.println("========== CANINO GANADOR ==========");
     // Ordenar los perros por puntaje de manera descendente
     for (int i = 0; i < misPerros.size() - 1; i++) {
         for (int j = i + 1; j < misPerros.size(); j++) {
             Perros perro1 = misPerros.get(i);
             Perros perro2 = misPerros.get(j);
             if (perro1.getPuntaje() < perro2.getPuntaje()) {
                 // Intercambiar perros para ordenar de manera descendente
                 misPerros.set(i, perro2);
                 misPerros.set(j, perro1);
             }
         }
     }
     Perros ganador = misPerros.get(0); 
     System.out.println("El canino ganador es: " + ganador.getNombrePerros() + " con un puntaje de: " + ganador.getPuntaje());
 }
}

//Método para determinar el puntaje más bajo
public void puntajeMenor() {
 // Verificar si no hay caninos registrados en la exposición
 if (misPerros.isEmpty()) {
     System.out.println("No hay caninos registrados");
     System.out.println("=======================================");
 } else {
     System.out.println("========== CANINO CON MENOR PUNTAJE ==========");
     // Ordenar los perros por puntaje de manera ascendente
     for (int i = 0; i < misPerros.size(); i++) {
         for (int j = i + 1; j < misPerros.size(); j++) {
             Perros perro1 = misPerros.get(i);
             Perros perro2 = misPerros.get(j);
             if (perro1.getPuntaje() > perro2.getPuntaje()) {
                 // Intercambiar perros para ordenar de manera ascendente
                 misPerros.set(i, perro2);
                 misPerros.set(j, perro1);
                 break;
             }
         }
     }
     Perros menorPuntaje = misPerros.get(0);
     System.out.println("El canino con menor puntaje es: " + menorPuntaje.getNombrePerros() + " con una puntaje de: " + menorPuntaje.getPuntaje());
 }
}

//Método para encontrar la edad mayor en meses
public void mayorEdad() {
 // Verificar si no hay caninos registrados en la exposición
 if (misPerros.isEmpty()) {
     System.out.println("No hay caninos registrados");
 } else {
     System.out.println("========== CANINO CON MAYOR EDAD ==========");
     // Ordenar los perros por edad de manera ascendente
     for (int i = 0; i < misPerros.size(); i++) {
         for (int j = i + 1; j < misPerros.size(); j++) {
             Perros perro1 = misPerros.get(i);
             Perros perro2 = misPerros.get(j);
             if (perro1.getEdadMeses() > perro2.getEdadMeses()) {
                 // Intercambiar perros para ordenar de manera ascendente
                 misPerros.set(i, perro2);
                 misPerros.set(j, perro1);
                 break;
             }
         }
     }
     Perros mayorEdad = misPerros.get(misPerros.size() - 1);
     System.out.println("El canino mayor es: " + mayorEdad.getNombrePerros() + " con una edad de: " + mayorEdad.getEdadMeses());
 }
}

//Método para eliminar el registro
public void eliminarInformacionPerro() {
 System.out.println("Escriba el nombre del canino a eliminar");
 lector.nextLine();
 String nombre = lector.nextLine();
 boolean encontrado = false;
 for (Perros e : misPerros) {
     if (e.getNombrePerros().equalsIgnoreCase(nombre)) {
         System.out.println("¿Está seguro de eliminar el registro?");
         System.out.println("Ingrese: 1 para eliminar o 2 para Salir: ");
         int opcion = lector.nextInt();
         if (opcion == 1) {
             misPerros.remove(e);
             System.out.println("El canino con nombre: " + nombre + " se eliminó.");
         } else if (opcion == 2) {
             System.out.println("El canino no fue eliminado.");
         }
         encontrado = true;
         break;
     }
 }
 if (!encontrado) {
     System.out.println("No se encontró ningún canino con el nombre.");
 }
}

//Método principal para iniciar el programa
public static void main(String[] args) {
 // Crea un Objeto de la clase Exposicion
 Exposicion organizador = new Exposicion();
 // Llama al método de mostrarMenu para la ejecución
 organizador.mostrarMenu();
}
}