/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.chelikanova;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Администратор
 */
public class HelloServiceClient {

    public static void main(String... args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 2099);
        RemoteHelloService service = (RemoteHelloService) registry.lookup("sample/HelloService");
        String[] names = {"John", "Jan", "Иван"};
        String[] messages = {"С днем рождения!", "С днем свадьбы!", "С новым годом!"};
        String[] tracks = {"In the end", "Dangerous", "You belong to me"};
        for (int i=0; i<names.length; i++ ) {
            
                    System.out.println(service.sayHello(names[i], messages[i],
                            tracks[i]));
                }
           
        
    }

}
