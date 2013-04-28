package com.ada.sme.model;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class StatusModel extends Thread {

	public static Inet4Address a;
	String ip;

	public static Boolean status;

	public StatusModel(String ipaddress) {
		ip = ipaddress;
		try {
			a = (Inet4Address) InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
		}

	}

	public static boolean check() {
		try {
			status = a.isReachable(600);
                        return status;
		} catch (IOException e) {
			e.printStackTrace();
		}
                return false;
	}
	
	public static boolean getStatus(){
		return status;
	}

}
