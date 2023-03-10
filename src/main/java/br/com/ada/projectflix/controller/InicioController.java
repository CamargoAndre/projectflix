package br.com.ada.projectflix.controller;

import br.com.ada.projectflix.dao.FilmeDAO;
import br.com.ada.projectflix.dao.NoticiaDAO;
import br.com.ada.projectflix.model.Filme;
import br.com.ada.projectflix.model.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class InicioController {

    @Autowired
    private FilmeDAO filmeDAO;
    @Autowired
    private NoticiaDAO noticiaDAO;

    @GetMapping
    public String inicio(Model model){
        List<Filme> filmes = filmeDAO.buscarTodosFilmes();
        List<Noticia> noticias = noticiaDAO.listarTodasNoticias();

        model.addAttribute("filmes", filmes);
        model.addAttribute("notcias", noticias);

        return "index";


    }


}
