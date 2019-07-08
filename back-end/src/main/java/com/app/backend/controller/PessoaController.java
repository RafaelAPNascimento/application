package com.app.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.backend.entidade.Pessoa;
import com.app.backend.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	// @Autowired
	// PessoaRepository pessoaDao;

	// @PostMapping(value = "/salvar")
	// public ResponseEntity<?> salvarPessoa(@RequestBody Pessoa pessoa) {

	// try {
	// pessoa = pessoaDao.save(pessoa);
	// ResponseEntity<Pessoa> response = new ResponseEntity<>(pessoa,
	// HttpStatus.OK);
	// return response;
	// }
	// catch(Exception e) {
	// e.printStackTrace();
	// ResponseEntity<String> response = new ResponseEntity<>(e.getMessage(),
	// HttpStatus.INTERNAL_SERVER_ERROR);
	// return response;
	// }
	// }

	// @GetMapping(value = "/todas")
	// public ResponseEntity<?> getTodas() {

	// List<Pessoa> result = pessoaDao.findAll();
	// ResponseEntity<List<Pessoa>> response = new ResponseEntity<>(result,
	// HttpStatus.OK);
	// return response;
	// }
}
