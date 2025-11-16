package com.example.ProjetoBackEnd.controller;

import com.example.ProjetoBackEnd.dto.EspecialidadeDTO;
import com.example.ProjetoBackEnd.dto.EspecialidadeResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ProjetoBackEnd.model.Especialidade;
import com.example.ProjetoBackEnd.repository.EspecialidadeRepository;
import com.example.ProjetoBackEnd.services.EspecialidadeService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class EspecialidadeController {
    private final EspecialidadeRepository especialidadeRepository;
    private final EspecialidadeService especialidadeService;

    public EspecialidadeController(EspecialidadeService especialidadeService, EspecialidadeRepository especialidadeRepository){
        this.especialidadeRepository = especialidadeRepository;
        this.especialidadeService = especialidadeService;  
    }

    @GetMapping("/buscarEspecialidade/{nome}")
    @Transactional
    public ResponseEntity<EspecialidadeResponse> buscarPorNome(@PathVariable String nome){
        Especialidade especialidade = especialidadeRepository.findByNome(nome);

        EspecialidadeResponse especialidadeResponse = new EspecialidadeResponse(especialidade);
        return ResponseEntity.ok(especialidadeResponse);
    }


    @PostMapping("/cadastrarEspecialidade")
    @Transactional
    public ResponseEntity<EspecialidadeResponse> cadastrarEspecialidade(@RequestBody @Valid EspecialidadeDTO especialidadeDTO) {


        Especialidade especialidadeSalva = especialidadeService.cadastrarEspecialidade(especialidadeDTO);


        EspecialidadeResponse especialidadeResponse = new EspecialidadeResponse(especialidadeSalva);

        return ResponseEntity.ok(especialidadeResponse);
    }
    @PutMapping("/atualizarEspecialidade/{id}")
    public ResponseEntity<EspecialidadeResponse> atualizarEspecialidade(@PathVariable Long id,@RequestBody EspecialidadeDTO especialidade){
        Especialidade especialidadeAtualizada = especialidadeService.atualizarEspecialidade(id, especialidade);
        EspecialidadeResponse especialidadeResponse = new EspecialidadeResponse(especialidadeAtualizada);
        return ResponseEntity.ok(especialidadeResponse);
    }
    @DeleteMapping("/excluirEspecialidade/{id}")
    public void excluirEspecialidade(@PathVariable Long id){
        especialidadeService.excluirEspecialidade(id);
    } 
    
    }
    
      




