package FinalProyect;

import controller.ClientController;
import model.Client;
import java.util.Scanner;
import controller.TransporterController;
import controller.SuplierController;
import model.Suplier;
import model.Transporter;

public class view {
//comentario de pueba para un commit
    private static ClientController objClientController = new ClientController();
    private static TransporterController objTransporterController = new TransporterController();
    private static SuplierController objSuplierController = new SuplierController();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        register();
//        search();
//        update();
         remove();
        list();
        scan.close();
    }

    public static void register() {
        char sw;

        do {
            System.out.println("\nSeleccionar tipo de persona para registrar:");
            System.out.println("1. Cliente");
            System.out.println("2. Transportista");
            System.out.println("3. Proveedor");
            System.out.print("Ingrese una opción: ");
            int opc = scan.nextInt();

            switch (opc) {
                case 1 -> {
                    System.out.println("Tipo de documento: ");
                    String typePerson = scan.next();
                    System.out.println("Nombre: ");
                    String firstName = scan.next();

                    System.out.print("Apellido: ");
                    String lastName = scan.next();

                    System.out.print("Direccion: ");
                    String adress = scan.next();

                    System.out.print("Telefono: ");
                    String phoneNumber = scan.next();

                    Client objClient = new Client(firstName, lastName, adress, phoneNumber, typePerson);

                    if (objClientController.register(objClient, null, null)) {
                        System.out.println("\nCliente registrado exitosamente!");
                    } else {
                        System.out.println("\nError al registrar la Cliente. Intente de nuevo.");
                    }
                    break;
                }
                case 2 -> {
                    System.out.println("Tipo de documento: ");
                    String typeDocument = scan.next();

                    System.out.print("Nombre: ");
                    String name = scan.next();

                    System.out.print("Capacidad: ");
                    String ability = scan.next();

                    System.out.print("Tipo de transporte, 1 par aereo, 2 para terrestre: ");
                    byte typeTransport = scan.nextByte();

                    Transporter objTransporter = new Transporter(typeTransport, ability, name, typeDocument);

                    if (objTransporterController.register(null, null, objTransporter)) {
                        System.out.println("\nTransportadora registrada exitosamente!");
                    } else {
                        System.out.println("\nError al registrar la Transportadora. Intente de nuevo.");
                    }
                    break;
                }
                case 3 -> {
                    System.out.println("Tipo de documento: ");
                    String typeDocument = scan.next();

                    System.out.print("Nombre: ");
                    String name = scan.next();

                    System.out.print("Ciudad: ");
                    String city = scan.next();

                    System.out.print("Fecha: ");
                    String date = scan.next();

                    Suplier objsuplier = new Suplier(typeDocument, name, city, date);

                    if (objSuplierController.register(null, objsuplier, null)) {
                        System.out.println("\nProveedor registrado exitosamente!");
                    } else {
                        System.out.println("\nError al registrar el proveedor. Intente de nuevo.");
                    }
                    break;
                }
                default ->
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

            System.out.println("\nDesea ingresar otra persona (S/N): ");
            sw = scan.next().toUpperCase().charAt(0);
        } while (sw == 'S');

    }

    private static void search() {
        char sw;

        do {
            System.out.println("\nConsultar");
            System.out.println("\nSeleccionar tipo de persona para consultar:");
            System.out.println("1. Cliente");
            System.out.println("2. Transportista");
            System.out.println("3. Proveedor");
            System.out.print("Ingrese una opción: ");
            int opc = scan.nextInt();

            switch (opc) {
                case 1 -> {
                    System.out.println("Ingrese el nombre del cliente que desea buscar: ");
                    String name = scan.next();

                    String result = objClientController.search(name);
                    if (result != "") {
                        System.out.println("\nDatos del cliente");
                        System.out.println(result);
                    } else {
                        System.out.println("\nCliente no se encontro. Verifique!!...");
                    }
                    break;
                }
                case 2 -> {
                    System.out.println("Ingrese el nombre del transportista que desea buscar: ");
                    String name = scan.next();

                    String result = objTransporterController.search(name);
                    if (result != "") {
                        System.out.println("\nDatos del transportista");
                        System.out.println(result);
                    } else {
                        System.out.println("\ntransportista no se encontro. Verifique!!...");
                    }
                    break;
                }
                case 3 -> {
                    System.out.println("Ingrese el nombre del provedor que desea buscar: ");
                    String name = scan.next();

                    String result = objSuplierController.search(name);
//                    String resultTwo = objSuplierController(typeDocument, name, city, date);
                    if (result != "") {
                        System.out.println("\nDatos del provedor");
                        System.out.println(result);
                    } else {
                        System.out.println("\nprovedor no se encontro. Verifique!!...");
                    }
                    break;
                }
                default ->
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

            System.out.println("\nDesea consultar otro cliente (S/N): ");
            sw = scan.next().toUpperCase().charAt(0);
        } while (sw == 'S');
    }

    private static void update() {
        char sw;

        do {
            System.out.println("\nActualizar");
            System.out.println("\nSeleccionar tipo de persona para Actualizar:");
            System.out.println("1. Cliente");
            System.out.println("2. Transportista");
            System.out.println("3. Proveedor");
            System.out.print("Ingrese una opción: ");
            int opc = scan.nextInt();

            switch (opc) {
                case 1 -> {
                    System.out.println("Ingrese el nombre del cliente que desea buscar para actualizar: ");
                    String searchName = scan.next();

                    String result = objClientController.search(searchName);

                    if (result != "") {
                        System.out.println("\nDatos del cliente");
                        System.out.println(result);

                        System.out.println("\nDesea actualizar los datos del cliente (S/N): ");
                        sw = scan.next().toUpperCase().charAt(0);

                        if (sw == 'S') {
                            System.out.println("Tipo de persona: ");
                            String typePerson = scan.nextLine();
                            System.out.print("Nombre: ");
                            String firstName = scan.nextLine();

                            System.out.print("Apellido: ");
                            String lastName = scan.nextLine();

                            System.out.print("Direccion: ");
                            String adress = scan.nextLine();

                            System.out.print("Telefono: ");
                            String phoneNumber = scan.nextLine();

                            Client objClient = new Client(firstName, lastName, adress, phoneNumber, typePerson);

                            if (objClientController.update(searchName, objClient, null, null)) {
                                System.out.println("\nCliente actualizado correctamente!!...");
                            } else {
                                System.out.println("\nCliente no se logro actualizar. Verifique!!...");
                            }
                        }

                    } else {
                        System.out.println("\nCliente no se encontro. Verifique!!...");
                    }
                    break;
                }
                case 2 -> {
                    System.out.println("Ingrese el nombre del transportista que desea buscar para actualizar: ");
                    String searchName = scan.next();

                    String result = objTransporterController.search(searchName);

                    if (result != "") {
                        System.out.println("\nDatos del transportista");
                        System.out.println(result);

                        System.out.println("\nDesea actualizar los datos del transportista (S/N): ");
                        sw = scan.next().toUpperCase().charAt(0);

                        if (sw == 'S') {
                            System.out.println("Tipo de documento: ");
                            String typeDocument = scan.nextLine();

                            System.out.print("Nombre: ");
                            String name = scan.nextLine();

                            System.out.print("Capacidad: ");
                            String ability = scan.nextLine();

                            System.out.print("Tipo de transporte, 1 par aereo, 2 para terrestre: ");
                            byte typeTransport = scan.nextByte();

                            Transporter objTransporter = new Transporter(typeTransport, ability, name, typeDocument);

                            if (objTransporterController.update(searchName, null, null, objTransporter)) {
                                System.out.println("\nTransportista actualizado correctamente!!...");
                            } else {
                                System.out.println("\nTransportista no se logro actualizar. Verifique!!...");
                            }
                        }

                    } else {
                        System.out.println("\nCliente no se encontro. Verifique!!...");
                    }
                    break;
                }
                case 3 -> {
                    System.out.println("Ingrese el nombre del proveedor que desea buscar para actualizar: ");
                    String searchName = scan.next();

                    String result = objSuplierController.search(searchName);

                    if (result != "") {
                        System.out.println("\nDatos del proveedor");
                        System.out.println(result);

                        System.out.println("\nDesea actualizar los datos del proveedor (S/N): ");
                        sw = scan.next().toUpperCase().charAt(0);

                        if (sw == 'S') {
                            System.out.println("Tipo de documento: ");
                            String typeDocument = scan.nextLine();

                            System.out.print("Nombre: ");
                            String name = scan.nextLine();

                            System.out.print("Ciudad: ");
                            String city = scan.nextLine();

                            System.out.print("Fecha: ");
                            String date = scan.nextLine();

                            Suplier objsuplier = new Suplier(typeDocument, name, city, date);

                            if (objSuplierController.update(searchName, null, objsuplier, null)) {
                                System.out.println("\nproveedor actualizado correctamente!!...");
                            } else {
                                System.out.println("\nproveedor no se logro actualizar. Verifique!!...");
                            }
                        }
                    } else {
                        System.out.println("\nproveedor no se encontro. Verifique!!...");
                    }
                    break;
                }
                default ->
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

            System.out.println("\nDesea actualizar otra persona (S/N): ");
            sw = scan.next().toUpperCase().charAt(0);
        } while (sw == 'S');
    }

    private static void remove() {
        char sw;

        do {
            System.out.println("\nRemover Cliente");
            System.out.println("\nSeleccionar tipo de persona para remover:");
            System.out.println("1. Cliente");
            System.out.println("2. Transportista");
            System.out.println("3. Proveedor");
            System.out.print("Ingrese una opción: ");
            int opc = scan.nextInt();

            switch (opc) {
                case 1 -> {
                    System.out.println("Ingrese el nombre del cliente que desea remover: ");
                    String name = scan.next();

                    String result = objClientController.search(name);
                    if (result != "") {
                        System.out.println("\nDatos del cliente");
                        System.out.println(result);

                        System.out.println("\nDesea remover los datos del cliente (S/N): ");
                        sw = scan.next().toUpperCase().charAt(0);

                        if (sw == 'S') {
                            if (objClientController.remove(name)) {
                                System.out.println("\nCliente removido exitosamente!!...");
                            } else {
                                System.out.println("\nCliente no se logró remover. Verifique!!...");
                            }
                        }
                    } else {
                        System.out.println("\nCliente no se encontro. Verifique!!...");
                    }
                    break;
                }
                case 2 -> {
                    System.out.println("Ingrese el nombre del Transportista que desea remover: ");
                    String name = scan.next();

                    String result = objTransporterController.search(name);
                    if (result != "") {
                        System.out.println("\nDatos del cliente");
                        System.out.println(result);

                        System.out.println("\nDesea remover los datos del cliente (S/N): ");
                        sw = scan.next().toUpperCase().charAt(0);

                        if (sw == 'S') {
                            if (objTransporterController.remove(name)) {
                                System.out.println("\nTransportista removido exitosamente!!...");
                            } else {
                                System.out.println("\nTransportista no se logró remover. Verifique!!...");
                            }
                        }
                    } else {
                        System.out.println("\nTransportista no se encontro. Verifique!!...");
                    }
                    break;
                }
                case 3 -> {
                    System.out.println("Ingrese el nombre del Proveedor que desea remover: ");
                    String name = scan.next();

                    String result = objSuplierController.search(name);
                    if (result != "") {
                        System.out.println("\nDatos del Proveedor");
                        System.out.println(result);

                        System.out.println("\nDesea remover los datos del Proveedor (S/N): ");
                        sw = scan.next().toUpperCase().charAt(0);

                        if (sw == 'S') {
                            if (objSuplierController.remove(name)) {
                                System.out.println("\nProveedor removido exitosamente!!...");
                            } else {
                                System.out.println("\nProveedor no se logró remover. Verifique!!...");
                            }
                        }
                    } else {
                        System.out.println("\nProveedor no se encontro. Verifique!!...");
                    }
                    break;
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println("\nDesea consultar otra persona para remover (S/N): ");
            sw = scan.next().toUpperCase().charAt(0);
        } while (sw == 'S');
    }

    private static void list() {
        
        String result = objClientController.list();
        String resultTran = objTransporterController.list();
        String resultPro = objSuplierController.list();


        if (result != "") {
            System.out.println("\nLista de clientes");
            System.out.println(result);
            System.out.println("\nLista de Transportistas");
            System.out.println(resultTran);
            System.out.println("\nLista de Proveedores");
            System.out.println(resultPro);
        } else {
            System.out.println("\nNo hay personas registrados!!...");
        }

    }
}
