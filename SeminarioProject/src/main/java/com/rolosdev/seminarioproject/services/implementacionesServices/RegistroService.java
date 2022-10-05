package com.rolosdev.seminarioproject.services.implementacionesServices;

import com.rolosdev.seminarioproject.services.interfacesServices.IRegistroService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("registroService")
@Transactional
public class RegistroService implements IRegistroService {
}
