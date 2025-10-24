package com.example.ProjetoBackEnd.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetoBackEnd.model.Especialidade;
import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.repository.EspecialidadeRepository;
import com.example.ProjetoBackEnd.repository.MedicoRepository;
import com.example.ProjetoBackEnd.repository.PacienteRepository;
import com.example.ProjetoBackEnd.services.EspecialidadeService;
import com.example.ProjetoBackEnd.services.MedicoService;
import com.example.ProjetoBackEnd.services.PacienteService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/especialidades")
@CrossOrigin(origins = "http://localhost:5173")
public class EspecialidadeController {
    private final EspecialidadeRepository especialidadeRepository;
    private final EspecialidadeService especialidadeService;

    public EspecialidadeController(EspecialidadeService especialidadeService, EspecialidadeRepository especialidadeRepository){
        this.especialidadeRepository = especialidadeRepository;
        this.especialidadeService = especialidadeService;  
    }

    @GetMapping("/buscarEspecialidade/{nome}")
    public Especialidade Especialidade(@PathVariable String nome){
        return especialidadeService.buscarEspecialidade(nome);
    }
    @PostMapping("/cadastrarEspecialidade")
    public Especialidade EspecialidadeService(@RequestBody Especialidade especialidade){
        return especialidadeService.cadastrarEspecialidade(especialidade);
    }
    @PutMapping("/salvarEspecialidade")
    public Especialidade salvarEspecialidade(@RequestBody Especialidade especialidade){
        return especialidadeService.salvarEspecialidade(especialidade.getId(), especialidade);
    }
    @DeleteMapping("/excluirEspecialidade")
    public void excluirEspecialidade(@PathVariable Long id){
        especialidadeService.excluirEspecialidade(id);
    } 
    
    }
    
      




