Una empresa que gestiona una inmobiliaria de Palma, nos ha solicitado el desarrollo de un programa de gestión. Tras recabar los requisitos, el analista nos ha pedido que hagamos lo siguiente:



1. **Clase Inmobiliaria.(0,5 puntos)** Se caracteriza por tener <span style="text-decoration:underline;">una lista de Inmuebles, nombre de la inmobiliaria y CIF de la inmobiliaria</span>. Esta clase implementa constructor vacío, getters/setters y método toString.
2. **Clase Inmueble. (0,5 puntos)** Un inmueble se caracteriza por tener unos metros cuadrados,  precio, población, ~~lista de visitas (visitas es una clase que se define más abajo) y~~ un identificador. Para controlar el identificador, utilizaremos otro atributo para controlar el último ID asignado en un inmueble. Esta clase implementa el constructor vacío, constructor con todos los atributos, constructor copia, getters/setters y método toString. El precio nunca puede ser menor o igual a cero en toda nuestra aplicación.
3. **Clase Terreno. (0,5 puntos)** Un terreno es una especialización de la clase inmueble, y además de los atributos de la clase Inmueble, tiene los atributos <span style="text-decoration:underline;">tipo de calificación que únicamente puede ser rústico, urbano y urbanizable</span>. Esta clase implementa el constructor vacío, getters/setters y método toString.
4. **Clase Vivienda. (0,5 puntos)** Una vivienda es una especialización de la clase Inmueble y además de los atributos de la clase Inmueble, t<span style="text-decoration:underline;">iene los atributos número de habitaciones y descripción</span>. Esta clase implementa el constructor vacío, constructor copia getters/setters y método toString. Debemos controlar que cuando se soliciten los datos de una vivienda, esta debe tener al menos una habitación, de lo contrario solicitará al usuario de nuevo el número de habitaciones.
5. El **programa principal(1 punto)** incluido en la Clase GestionInmobiliaria, que se caracteriza por tener una lista de Inmobiliarias y el main con el que se gestionará el resto del programa. El main **tendrá un menú que se llamará indefinidamente hasta que el usuario quiera salir de la aplicación. Hay que tener en cuenta que el menú trabaja con una inmobiliaria concreta y ofreciendo para ella todas las opciones que se detallan a continuación, por tanto es imprescindible saber primero con qué inmobiliaria trabajaremos, por ello, desarrolla la solución que consideres más conveniente.
    *   <span style="text-decoration:underline;">Añadir Terreno</span>. **(1 punto)** Llamará al método solicitar Datos **(aparece en el punto F) **y devolverá un terreno que se añadirá a la lista de inmuebles. Este método pertenece a la **clase Terreno**.
    *   <span style="text-decoration:underline;">Añadir Vivienda</span>.**(1 punto)** Llamará al método solicitar Datos y devolverá una vivienda que se añadirá a la lista de inmuebles. Este método pertenece a la **clase Vivienda**.
    *   <span style="text-decoration:underline;">Buscar Vivienda.</span> **(1,5 puntos)** Recibirá como parámetro una lista de Inmuebles y solicitará al usuario un número de habitaciones. El método mostrará toda la información **de todas aquellas Viviendas que cumplan con el criterio: ** número de habitaciones. Este método pertenece a la **clase Inmueble**.
    *   <span style="text-decoration:underline;">Buscar Terreno</span>.**(1,5 puntos)** Recibirá como parámetro una lista de Inmuebles y solicitará al usuario un tipo de calificación (<span style="text-decoration:underline;">rústico, urbano y urbanizable).</span> El método mostrará toda la información **del primer terreno **que cumpla con la calificación buscada (<span style="text-decoration:underline;">rústico, urbano y urbanizable)</span>. Este método pertenece a la **clase Inmueble**.

Ejemplo del menú:


```
Dime el CIF de la inmobiliaria que quieres trabajar
Inmo00
1. Opcion 1 - Añadir terreno
2. Opcion 2 - Añadir vivienda
3. Opcion 3 - Buscar vivienda
3. Opcion 4 - Buscar terreno
5. Opcion 5 - Salir
Escribe una de las opciones

```



6. Método <span style="text-decoration:underline;">solicitar Datos. **(0,5 puntos)**</span> Este método aparecerá en las tres clases, en cada una de las clases solicitará los datos correspondientes a la propia clase **completando la información de la instancia que esté haciendo uso de este método.**
7. <span style="text-decoration:underline;">Calcular PrecioCompraventa.</span> **(1 punto).** Este método será de obligada implementación por las clases herederas, ya que el precio de compraventa es su precio+impuestos y los impuestos varían según el tipo de Inmueble. Este método se llamará desde el método toString de las diferentes clases implicadas, así mostrará el precio de compraventa según sea Vivienda o Terreno.
    *   En el caso de la clase Vivienda los impuestos vendrán dados por el cálculo: precio * IVA que es de un 10%, después del cálculo imprimirá los datos de la vivienda y a continuación el importe de compraventa. 
    *   Para el caso de los terrenos, su precio de compraventa será de precio*IVA, pero su IVA varía según la calificación (<span style="text-decoration:underline;">rústico 4%, urbano 6% y urbanizable 8%)</span>. Después del cálculo imprimirá los datos de la vivienda y a continuación el importe de compraventa. 

**Se adjunta un método que inicia varias inmobiliarias con viviendas y terrenos. Podéis utilizarlo y si fuera necesario adaptarlo a vuestras necesidades.**


```
public static void iniciarInmobiliaria(ArrayList<Inmobiliaria> listaInmobiliaria) {
        Inmobiliaria inmoTemp;
        Terreno terrenoTemp;
        Vivienda viviendaTemp;


        for (int i=0;i<3;i++){
            inmoTemp=new Inmobiliaria();
            inmoTemp.setCIF("Inmo0"+i);
            inmoTemp.setNombreInmobiliaria("nombreInmo"+1);
            for (int j=0;j<3;j++){
                terrenoTemp = new Terreno();
                terrenoTemp.setId(i+j);
                terrenoTemp.setMetrosCuadrados(j*80);
                terrenoTemp.setPoblacion("poblac"+j);
                terrenoTemp.setPrecio(30000*(i+1));
                terrenoTemp.setTipoCalificacion(Calificacion.RUSTICO);
                inmoTemp.getListaInmuebles().add(terrenoTemp);


                viviendaTemp = new Vivienda();
                viviendaTemp.setId(i+j);
                viviendaTemp.setMetrosCuadrados(j*80);
                viviendaTemp.setPoblacion("poblac"+j);
                viviendaTemp.setPrecio(30000*(i+1));                
                viviendaTemp.setDescripcion("descripcion vivienda "+i);
                viviendaTemp.setNumHabitaciones(i+j+1);


                inmoTemp.getListaInmuebles().add(viviendaTemp);


            }
            listaInmobiliaria.add(inmoTemp);
        }


    }


