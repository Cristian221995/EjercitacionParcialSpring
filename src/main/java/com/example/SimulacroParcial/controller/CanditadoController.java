package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.models.Candidato;
import com.example.SimulacroParcial.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/candidato")
@RestController
public class CanditadoController {
    @Autowired
    CandidatoRepository candidatoRepository;

    @PostMapping("")
    public void addPersona(@RequestBody Candidato c) {
        candidatoRepository.save(c);
    }

    @GetMapping("")
    public List<Candidato> getAll(){
        return candidatoRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Candidato> getbyid(@PathVariable Integer id){
        return candidatoRepository.findById(id);
    }

    @PostMapping("/votar/{id}")
    public void votar(@PathVariable Integer id) throws Exception {
        Candidato candidato = null;
        candidato = candidatoRepository.getOne(id);
        if(candidato != null){
            candidato.setCantidadDeVotos(candidato.getCantidadDeVotos()+1);
            candidatoRepository.save(candidato);
        }else{
            throw new Exception("El candidato no existe");
        }
    }

    @GetMapping("/votos")
    public Map<String,Integer> getVotos(){
        List<Candidato> candidatos = this.getAll();
        Map<String,Integer> cand = new HashMap<>();
        for (Candidato c:candidatos) {
            cand.put(c.getNombre()+c.getApellido(),c.getCantidadDeVotos());
        }
        return cand;
    }

    @Scheduled
    public void eliminarVotos5Min(){

    }
}
