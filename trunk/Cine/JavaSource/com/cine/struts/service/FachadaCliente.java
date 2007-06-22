package com.cine.struts.service;

import java.util.*;
import com.cine.*;

public interface FachadaCliente 
{
	public boolean reservarButacas(List<Butaca> butacas);
	public boolean cancelarReserva(List<Butaca> butacas);
}
