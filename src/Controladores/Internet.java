package Controladores;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Internet {

    private final List<InternetConnectionListener> listeners;

    public Internet() {
        listeners = new ArrayList<>();
    }

    // Método para agregar un listener
    public void addListener(InternetConnectionListener listener) {
        listeners.add(listener);
    }

    // Método para remover un listener
    public void removeListener(InternetConnectionListener listener) {
        listeners.remove(listener);
    }

    // Método para notificar a todos los listeners
    private void notifyListeners(boolean isConnected) {
        for (InternetConnectionListener listener : listeners) {
            listener.onInternetConnectionChange(isConnected);
        }
    }

    // Método para iniciar la detección de conexión a Internet
    public void startMonitoring() {
        new Thread(() -> {
            try {
                while (true) {
                    // Obtener todas las interfaces de red
                    Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
                    boolean isConnected = false;
                    
                    // Verificar si alguna interfaz tiene conexión
                    while (interfaces.hasMoreElements()) {
                        NetworkInterface networkInterface = interfaces.nextElement();
                        if (networkInterface.isUp() && !networkInterface.isLoopback()) {
                            isConnected = true;
                            break;
                        }
                    }
                    
                    // Notificar a los listeners
                    notifyListeners(isConnected);
                    
                    // Esperar un tiempo antes de volver a verificar
//                    Thread.sleep(5000); // Espera 5 segundos antes de volver a verificar
                }
            } catch (SocketException e) {
                e.printStackTrace();
                System.err.println("error: " + e);
            }
        }).start();
    }

    // Interfaz para los listeners
    public interface InternetConnectionListener {

        void onInternetConnectionChange(boolean isConnected);
    }
}
