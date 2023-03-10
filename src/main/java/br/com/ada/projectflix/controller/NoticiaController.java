package br.com.ada.projectflix.controller;

import br.com.ada.projectflix.dao.NoticiaDAO;
import br.com.ada.projectflix.model.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/noticia")
public class NoticiaController {
    @Autowired
    private NoticiaDAO noticiaDAO;
    @GetMapping
    public String listarNoticia(Model model){
        List<Noticia> noticias = noticiaDAO.listarTodasNoticias();
        model.addAttribute("noticias", noticias);
        return "noticia_listar";
    }

    @GetMapping("/editarnoticia/{id}")
    public String editarNoticia(@PathVariable int id, Model model){
        Noticia noticia = noticiaDAO.buscarNoticiaPorId(id);
        model.addAttribute("noticia", noticia);
        return "noticia_editar";
    }
    @PostMapping("/editarnoticia")
    public String atualizar(Noticia noticia){
        noticiaDAO.atualizarNoticia(noticia);
        return "redirect:/noticia";
    }
    @GetMapping("/removernoticia/{id}")
    public String removerNoticia(@PathVariable int id){
        noticiaDAO.removerNoticia(id);
        return "redirect:/noticia";
    }
    @GetMapping("/novanoticia")
    public String novaNoticia(Model model){
        model.addAttribute("noticia", new Noticia());
        return "nova_noticia";
    }
    @PostMapping("/novanoticia")
    public String adicionarNoticia(Noticia noticia){
        noticiaDAO.adicionarNoticia(noticia);
        return "redirect:/noticia";
    }





}
