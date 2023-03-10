package br.com.ada.projectflix.controller;

import br.com.ada.projectflix.dao.FilmeDAO;
import br.com.ada.projectflix.model.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeDAO filmeDAO;

    @GetMapping
    public String listarFilme(Model model){
        List<Filme> lista = filmeDAO.buscarTodosFilmes();
        model.addAttribute("filmes", lista);
        return "filme_listar";
    }
    @GetMapping("/editarfilme/{id}")
    public String editarFilme(@PathVariable int id, Model model){
        Filme filme = filmeDAO.buscarFilmePorId(id);
        model.addAttribute("filme", filme);
        return "filme_editar";
    }

    @PostMapping("/editarfilme")
    public String atualizar(Filme filme){
        filmeDAO.atualizarFilme(filme);
        return "redirect:/filme";
    }
    @GetMapping("/removerfilme/{id}")
    public String removerFilme(@PathVariable int id){
        filmeDAO.remove(id);
        return "redirect:/filme";
    }

    @GetMapping("/novofilme")
    public String novoFilme(Model model){
        model.addAttribute("filme", new Filme());
        return "filme_novo";
    }

    @PostMapping("/novofilme")
    public String adicionar(Filme filme){
        filmeDAO.adicionarFilme(filme);
        return "redirect:/filme";
    }

    @GetMapping("/darlike/{id}")
    public String darLike(@PathVariable int id){
        filmeDAO.darLike(id);
        return "redirect:/filme";
    }

    @GetMapping("/dardislike/{id}")
    public String darDislike(@PathVariable int id){
        filmeDAO.darDislike(id);
        return "redirect:/filme";
    }



}
