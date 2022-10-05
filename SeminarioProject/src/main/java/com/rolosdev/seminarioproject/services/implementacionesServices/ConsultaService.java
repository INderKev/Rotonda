package com.rolosdev.seminarioproject.services.implementacionesServices;

import com.rolosdev.seminarioproject.services.interfacesServices.IConsultaService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("consultaService")
@Transactional
public class ConsultaService implements IConsultaService {
}
