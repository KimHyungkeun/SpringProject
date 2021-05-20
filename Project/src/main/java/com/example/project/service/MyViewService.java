package com.example.project.service;

import com.example.project.entity.ArticleEntity;
import com.example.project.vo.Article;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyViewService {
    private List<ArticleEntity> articles = new LinkedList<>();
    private long currentId = 0;

    public List<ArticleEntity> show () {
        return articles;
    }

    public void register (Article article) {
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setTitle(article.getTitle());
        articleEntity.setContent(article.getContent());
        articleEntity.setId(currentId);
        ++currentId;
        articles.add(articleEntity);
    }

    public boolean delete (long id) {
        for (int i = 0 ; i < articles.size() ;i++) {
            if (articles.get(i).getId() == id) {
                articles.remove(i);
                return true;
            }
        }
        return false;

    }


}
