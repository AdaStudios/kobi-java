package com.ada.sme.model;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class StatusModel extends Thread {

	Inet4Address a;
	String ip;

	Boolean status;

	public StatusModel(String ipaddress) {
		ip = ipaddress;
		try {
			a = (Inet4Address) InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
		}

	}

	public void check() {
		try {
			status = a.isReachable(600);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean getStatus(){
		return status;
	}

}
