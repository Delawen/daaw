package com.cine;

import com.cine.SesionCine;

public class Butaca 
{
	private long ID;
	private boolean ocupado;
	private int fila;
	private int columna;
	private SesionCine sesion;
	
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public long getID() {
		return ID;
	}
	public void setID(long id) {
		ID = id;
	}
	public SesionCine getSesionCine()
	{
		return sesion;
	}
	public void setSesionCine(SesionCine s)
	{
		this.sesion = s;
	}
}
