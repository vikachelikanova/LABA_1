/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.chelikanova;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.rmi.*;

/**
 *
 * @author Администратор
 */
public interface RemoteHelloService extends Remote {

    Object sayHello(String name, String mess, String track) throws RemoteException;

}
