/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.chelikanova;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vika
 */
public class RemoteHelloServiceImpl implements RemoteHelloService {

    public static final String BINDING_NAME = "sample/HelloService";

    Date now = new Date();

    DateFormat formatter = new SimpleDateFormat("���� dd ����� MM ��� yyyy ����� hh:mm:ms");
    String s = formatter.format(now);
  

    
    public Object sayHello(String name, String mess, String track) {
        String string = "������������, " + name + "  ���� ������ ����������������:  "
                + "����� ���������" + " " + s + "����� ������ ������������:  "
                + " " + mess + " " + "�������� �����:"
                + track + " " + "  ������ � ���� �:   " + s;
        try {
            System.out.println(name + " from " + UnicastRemoteObject.getClientHost());
        } catch (ServerNotActiveException e) {
            System.out.println(e.getMessage());
        }

        return string;
    }

    public static void main(String... args) throws Exception {
        System.out.print("Starting registry...");
        final Registry registry = LocateRegistry.createRegistry(2099);
        System.out.println(" OK");

        final RemoteHelloService service = new RemoteHelloServiceImpl();
        Remote stub = UnicastRemoteObject.exportObject(service, 0);

        System.out.print("Binding service...");
        registry.bind(BINDING_NAME, stub);
        System.out.println(" OK");

        while (true) {
            Thread.sleep(Integer.MAX_VALUE);
        }
    }
}
