package br.com.ada.projectflix.dao;

import br.com.ada.projectflix.model.Noticia;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoticiaDAO {

    public static List<Noticia> noticias = new ArrayList<>();
    public static int proximoId = 1;

    public void adicionarNoticia(Noticia noticia){
        noticia.setId(proximoId++);
        noticias.add(noticia);
    }

    public void atualizarNoticia(Noticia noticia){
        for (int i = 0; i < noticias.size(); i++) {
            Noticia n = noticias.get(i);
            if(noticia.getId() == n.getId()){
                noticias.set(i, noticia);
                break;
            }
        }
    }

    public void removerNoticia(int id){
        noticias.removeIf(n -> n.getId() == id);
    }

    public Noticia buscarNoticiaPorId(int id){
        return noticias.stream()
                .filter(n -> n.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Noticia> listarTodasNoticias(){
        return noticias;
    }


}
