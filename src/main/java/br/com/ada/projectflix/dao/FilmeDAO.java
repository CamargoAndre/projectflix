package br.com.ada.projectflix.dao;

import br.com.ada.projectflix.model.Filme;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class FilmeDAO {

    public static List<Filme> filmes = new ArrayList<>();
    public static int proximoId = 1;

    public void adicionarFilme(Filme filme){
        filme.setId(proximoId++);
        filmes.add(filme);
    }
    public void atualizarFilme(Filme filme){
        for (int i = 0; i < filmes.size(); i++) {
            Filme f = filmes.get(i);
            if(f.getId() == filme.getId()){
                filmes.set(i, filme);
                break;
            }
        }
    }
    public void remove(int id){
        filmes.removeIf(f -> f.getId() == id);
    }

    public Filme buscarFilmePorId(int id){
        return filmes.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Filme> buscarTodosFilmes(){
        return filmes;
    }

    public void darLike(int id){
        for (int i = 0; i < filmes.size(); i++) {
            Filme f = filmes.get(i);
            if(f.getId() == id){
                int like = filmes.get(i).getLike();
                filmes.get(i).setLike(like+1);
                break;
            }
        }
    }

    public void darDislike(int id){
        for (int i = 0; i < filmes.size(); i++) {
            Filme f = filmes.get(i);
            if(f.getId() == id){
                int dislike = filmes.get(i).getDislike();
                filmes.get(i).setDislike(dislike+1);
                break;
            }
        }
    }

}
