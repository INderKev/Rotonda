package com.rolosdev.seminarioproject.services.implementacionesServices;

import com.rolosdev.seminarioproject.services.interfacesServices.ICompraService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("compraService")
@Transactional
public class CompraService implements ICompraService {
}
